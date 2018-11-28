package oxxy.kero.roiaculte.team7.khbich;

import io.reactivex.CompletableObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableCompletableObserver;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import oxxy.kero.roiaculte.team7.khbich.Utils.JobExecutor;
import oxxy.kero.roiaculte.team7.khbich.base.BaseActivity;
import oxxy.kero.roiaculte.team7.khbich.model.repositories.remote.dao.RemoteDao;
import oxxy.kero.roiaculte.team7.khbich.model.models.User;
import oxxy.kero.roiaculte.team7.khbich.model.repositories.remote.dataSources.Authentification;
import oxxy.kero.roiaculte.team7.khbich.model.repositoriesInterfaces.AuthentificationRepository;
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
    public static final String TAG = "errr";
    @Inject
    AuthentificationRepository repository ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
getApplicationComponent().inject(this);
        User user = new User("\"mohamed\"", "\"m.slamat@esi-sba.dz\"", "\"hello\"", "\"picture\"",
                "\"hellooow\""
                , "\"2cpi\"", "\"150\"", "\"sdfghj\"", "\"12\"");
        if(repository==null){
            Log.d(TAG, "onCreate: ");
        }else
            repository.SaveUserRemote(user,
            new DisposableCompletableObserver() {
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