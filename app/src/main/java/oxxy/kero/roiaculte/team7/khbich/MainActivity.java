package oxxy.kero.roiaculte.team7.khbich;

import io.reactivex.CompletableObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableCompletableObserver;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import oxxy.kero.roiaculte.team7.khbich.Utils.JobExecutor;
import oxxy.kero.roiaculte.team7.khbich.Utils.TextUtils;
import oxxy.kero.roiaculte.team7.khbich.Utils.UserConverter;
import oxxy.kero.roiaculte.team7.khbich.base.BaseActivity;
import oxxy.kero.roiaculte.team7.khbich.model.models.Message;
import oxxy.kero.roiaculte.team7.khbich.model.models.Test;
import oxxy.kero.roiaculte.team7.khbich.model.models.UserState;
import oxxy.kero.roiaculte.team7.khbich.model.repositories.local.database.LocalData;
import oxxy.kero.roiaculte.team7.khbich.model.repositories.remote.DataFlowImpl;
import oxxy.kero.roiaculte.team7.khbich.model.repositories.remote.QuestionRemote;
import oxxy.kero.roiaculte.team7.khbich.model.repositories.remote.TestsRemote;
import oxxy.kero.roiaculte.team7.khbich.model.repositories.remote.dao.RemoteDao;
import oxxy.kero.roiaculte.team7.khbich.model.models.User;
import oxxy.kero.roiaculte.team7.khbich.model.repositories.remote.dataSources.Authentification;
import oxxy.kero.roiaculte.team7.khbich.model.repositories.remote.dataSources.RemoteData;
import oxxy.kero.roiaculte.team7.khbich.model.repositoriesInterfaces.AuthentificationRepository;
import oxxy.kero.roiaculte.team7.khbich.model.repositoriesInterfaces.DataFlowRepository;
import oxxy.kero.roiaculte.team7.khbich.ui.UserView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

public class MainActivity extends BaseActivity {
    public static final String TAG = "errr";
//    @Inject
//    Authentification authentification  ;
//    @Inject
//    AuthentificationRepository repository ;
//    @Inject
//DataFlowRepository data ;
//   @Inject
//    RemoteData data;
    @Inject
    LocalData data ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getApplicationComponent().inject(this);
        List<Test> tests = new ArrayList<>();
        List<Long> longs= new ArrayList<>();
        longs.add(Long.valueOf(12));
        tests.add(new Test(164,  "namse", "descriptizzonE","imageUrl", 30, UserState.Cs1,
                3));
        tests.get(0).setResolved(true);
                data.saveTests(tests, longs).observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.from(new JobExecutor())).subscribeWith(new DisposableCompletableObserver() {
                    @Override
                    public void onComplete() {
                        Log.d(TAG, "onComplete: ");
                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });
//        data.getTestSolved(new DisposableObserver<List<Test>>() {
//                            @Override
//                            public void onNext(List<Test> tests) {
//                                Log.d(TAG, "onNext: "+String.valueOf(tests.size()));
//                                Log.d(TAG, "onNext: "+tests.get(1).getName());
//                            }
//
//                            @Override
//                            public void onError(Throwable e) {
//
//                            }
//
//                            @Override
//                            public void onComplete() {
//
//                            }
//                        });

//        String qsolved = "12@14:18@16:17@26:13@28";
//        int id = TextUtils.getQuestionById(qsolved, 13);
//        Log.d(TAG, "onCreate: "+String.valueOf(id));

//data.getQuestions("1").enqueue(new Callback<QuestionRemote>() {
//    @Override
//    public void onResponse(Call<QuestionRemote> call, Response<QuestionRemote> response) {
//
//    }
//
//    @Override
//    public void onFailure(Call<QuestionRemote> call, Throwable t) {
//
//    }
//});

    }

}