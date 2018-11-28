package oxxy.kero.roiaculte.team7.khbich;

import io.reactivex.CompletableObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import oxxy.kero.roiaculte.team7.khbich.Utils.JobExecutor;
import oxxy.kero.roiaculte.team7.khbich.base.BaseActivity;
import oxxy.kero.roiaculte.team7.khbich.model.repositories.remote.dao.RemoteDao;
import oxxy.kero.roiaculte.team7.khbich.model.models.User;
import oxxy.kero.roiaculte.team7.khbich.model.repositories.remote.dataSources.Authentification;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import javax.inject.Inject;

public class MainActivity extends BaseActivity {
    @Inject
    Retrofit retrofit ;
    public static final String TAG = "errr";
    @Inject
    Authentification authentification;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
getApplicationComponent().inject(this);
        User user = new User("\"mohamed\"", "\"m.slamat@esi-sba.dz\"", "\"hello\"", "\"picture\"",
                "\"hellooow\""
                , "\"2cpi\"", "\"150\"", "\"sdfghj\"", "\"12\"");
        if(authentification==null && retrofit ==null){
            Log.d(TAG, "onCreate: ");
        }else
    authentification.SignUpUser(user).subscribeOn(Schedulers.from(new  JobExecutor()))
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(new CompletableObserver() {
                @Override
                public void onSubscribe(Disposable d) {

                }

                @Override
                public void onComplete() {
                    Log.d(TAG, "onComplete: ");
                }

                @Override
                public void onError(Throwable e) {
                    Log.d(TAG, "onError: "+e.getLocalizedMessage());
                }
            });

    }

}