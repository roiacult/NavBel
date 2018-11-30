package oxxy.kero.roiaculte.team7.khbich.model.repositories.remote;

import android.content.SharedPreferences;
import android.util.Log;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Completable;
import io.reactivex.CompletableEmitter;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Action;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import oxxy.kero.roiaculte.team7.khbich.Utils.JobExecutor;
import oxxy.kero.roiaculte.team7.khbich.Utils.QuestionConvertere;
import oxxy.kero.roiaculte.team7.khbich.Utils.TestConverter;
import oxxy.kero.roiaculte.team7.khbich.model.models.QuestionConverter;
import oxxy.kero.roiaculte.team7.khbich.model.models.Test;
import oxxy.kero.roiaculte.team7.khbich.model.repositories.local.database.LocalData;
import oxxy.kero.roiaculte.team7.khbich.model.repositories.local.database.daos.TestDao;
import oxxy.kero.roiaculte.team7.khbich.model.repositories.local.sharedReference.MainSharedReference;
import oxxy.kero.roiaculte.team7.khbich.model.repositories.remote.dataSources.RemoteData;
import oxxy.kero.roiaculte.team7.khbich.model.repositoriesInterfaces.DataFlowRepository;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static oxxy.kero.roiaculte.team7.khbich.model.repositories.remote.dataSources.Authentification.TAG;

public class DataFlowImpl implements DataFlowRepository {

    private LocalData testDao ;
     private RemoteData data ;
     private SharedPreferences preferences ;
     private TestsRemote remote= new TestsRemote(new TestRemote[]{});
     private QuestionsRemote questionRemote= new QuestionsRemote(new QuestionRemote[]{});

    @Inject
    public DataFlowImpl(LocalData testDao, RemoteData data, SharedPreferences preferences) {
        this.testDao = testDao;
        this.data = data;
        this.preferences= preferences;
    }
    @Override
    public Completable updateLOcalDatabase() {
        final String year = String.valueOf(preferences.getInt("oxxy.kero.roiaculte.team7.khbich.USER_YEAR"
                , 1));
        return Completable.create(new CompletableOnSubscribe() {
            @Override
            public void subscribe(final CompletableEmitter emitter) throws Exception {
                data.getTests(year).enqueue(new Callback<TestsRemote>() {
                    @Override
                    public void onResponse(Call<TestsRemote> call, Response<TestsRemote> response) {
                        if (response.body() != null) {
                            remote = response.body();
                            emitter.onComplete();
                        }
                        Log.d(TAG, "onResponse: " + response.body().getTests()[1].getDEsc());
                        Log.d(TAG, "onResponse: " + response.message());
                    }

                    @Override
                    public void onFailure(Call<TestsRemote> call, Throwable t) {
                        Log.d(TAG, "onFailure: " + t.getLocalizedMessage());
                        Log.d(TAG, "onFailure: " + t.getMessage());
                        t.printStackTrace();
                        emitter.onError(t);
                    }
                });
            }
        }).andThen(testDao.saveTests(TestConverter.fromTestRemote(remote))).andThen(Completable.create(new CompletableOnSubscribe() {
            @Override
            public void subscribe(final CompletableEmitter emitter) throws Exception {
                data.getQuestions(year).enqueue(new Callback<QuestionsRemote>() {
                    @Override
                    public void onResponse(Call<QuestionsRemote> call, Response<QuestionsRemote> response) {
                        if (response.body() != null) {
                            questionRemote = response.body();
                            emitter.onComplete();
                        }
                        Log.d(TAG, "onResponse: " + response.body().getQuestionRemotes()[1].getQuestion());
                        Log.d(TAG, "onResponse: " + response.message());
                    }

                    @Override
                    public void onFailure(Call<QuestionsRemote> call, Throwable t) {
                        Log.d(TAG, "onFailure: " + t.getLocalizedMessage());
                        Log.d(TAG, "onFailure: " + t.getMessage());
                        t.printStackTrace();
                        emitter.onError(t);
                    }
                });
            }
        })).andThen(Completable.fromAction(new Action() {
            @Override
            public void run() throws Exception {
                testDao.saveQuestions(QuestionConvertere.fromRemote(questionRemote));
            }
        }));
    }

    @Override
    public void getTestSolved(DisposableObserver<List<Test>> tests) {
          testDao.getTestSolved(preferences.getString("oxxy.kero.roiaculte.team7.khbich.QSOLVED", ""))
                  .subscribeOn(Schedulers.from(new JobExecutor())).observeOn(AndroidSchedulers.mainThread())
                  .subscribeWith(tests);
    }

    @Override
    public void dropTable() {
        testDao.deletDatabase();
    }

}
