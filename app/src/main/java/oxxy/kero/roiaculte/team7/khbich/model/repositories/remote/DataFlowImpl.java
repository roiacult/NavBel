package oxxy.kero.roiaculte.team7.khbich.model.repositories.remote;

import android.content.SharedPreferences;
import android.util.Log;

import javax.inject.Inject;

import io.reactivex.Completable;
import io.reactivex.CompletableEmitter;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableOnSubscribe;
import io.reactivex.functions.Action;
import oxxy.kero.roiaculte.team7.khbich.Utils.TestConverter;
import oxxy.kero.roiaculte.team7.khbich.model.repositories.local.database.LocalData;
import oxxy.kero.roiaculte.team7.khbich.model.repositories.local.database.daos.TestDao;
import oxxy.kero.roiaculte.team7.khbich.model.repositories.local.sharedReference.MainSharedReference;
import oxxy.kero.roiaculte.team7.khbich.model.repositories.remote.dataSources.RemoteData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static oxxy.kero.roiaculte.team7.khbich.model.repositories.remote.dataSources.Authentification.TAG;

public class DataFlowImpl {

    private LocalData testDao ;
     private RemoteData data ;
     private SharedPreferences preferences ;
     private TestsRemote remote= new TestsRemote(new TestRemote[]{});

    @Inject
    public DataFlowImpl(LocalData testDao, RemoteData data, SharedPreferences preferences) {
        this.testDao = testDao;
        this.data = data;
        this.preferences= preferences;
    }
    Completable UpdateDataBase(){
        return Completable.create(new CompletableOnSubscribe() {
            @Override
            public void subscribe(final CompletableEmitter emitter) throws Exception {
            data.getTests(String.valueOf(preferences.getInt("oxxy.kero.roiaculte.team7.khbich.USER_YEAR"
                    , 1 ))).enqueue(new Callback<TestsRemote>() {
                @Override
                public void onResponse(Call<TestsRemote> call, Response<TestsRemote> response) {
                    if(response.body()!=null){
                       remote= response.body();
                       emitter.onComplete();
                    }
                    Log.d(TAG, "onResponse: "+response.body().getTests()[1].getDEsc());
                    Log.d(TAG, "onResponse: "+response.message());
                }

                @Override
                public void onFailure(Call<TestsRemote> call, Throwable t) {
                    Log.d(TAG, "onFailure: "+t.getLocalizedMessage());
                    Log.d(TAG, "onFailure: "+t.getMessage());
                    t.printStackTrace();
                    emitter.onError(t);
                }
            });
    }
}).andThen(Completable.fromAction(new Action() {
            @Override
            public void run() throws Exception {
              testDao.deletDatabase();
            }
        })).andThen(testDao.saveTests(TestConverter.fromTestRemote(remote)));
    }
}
