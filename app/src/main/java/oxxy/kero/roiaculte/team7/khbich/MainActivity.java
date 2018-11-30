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
import oxxy.kero.roiaculte.team7.khbich.Utils.UserConverter;
import oxxy.kero.roiaculte.team7.khbich.base.BaseActivity;
import oxxy.kero.roiaculte.team7.khbich.model.models.Message;
import oxxy.kero.roiaculte.team7.khbich.model.models.UserState;
import oxxy.kero.roiaculte.team7.khbich.model.repositories.remote.dao.RemoteDao;
import oxxy.kero.roiaculte.team7.khbich.model.models.User;
import oxxy.kero.roiaculte.team7.khbich.model.repositories.remote.dataSources.Authentification;
import oxxy.kero.roiaculte.team7.khbich.model.repositoriesInterfaces.AuthentificationRepository;
import oxxy.kero.roiaculte.team7.khbich.ui.UserView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import java.util.Calendar;
import java.util.Date;

import javax.inject.Inject;

public class MainActivity extends BaseActivity {
    public static final String TAG = "errr";
//    @Inject
//    Authentification authentification  ;
//    @Inject
//    AuthentificationRepository repository ;
//   @Inject
//    RemoteData data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getApplicationComponent().inject(this);
//        data.getTests("1");

//        repository.UpdateDataUser(new UserView("Nikmok", "a", "picture", "password", UserState.USER_2CPI, 250, Calendar.getInstance().getTime(),
//                "qsolved", 12), new DisposableCompletableObserver() {
//            @Override
//            public void onComplete() {
//                Log.d(TAG, "onComplete: ");
//            }
//
//            @Override
//            public void onError(Throwable e) {
//                Log.d(TAG, "onError: "+e.getMessage());
//            }
//        });
//        UserView userView= new UserView("akram", "a.boutouchent@esi-sba.dz", "picture",
//                "nopassword", UserState.USER_2CPI,250, Calendar.getInstance().getTime()
//                , "qsolved", 12);
//         User user = new User("\"akram\"","\"a.boutouchent@esi-sba.dz\"", "\"nopassword\"", "\"picture\"",
//                 "\"2018-15-10 2.25.30\"", "\"2\"","\"250\"", "\"qsolbed\"", "\"12\"");
//           User user1 = UserConverter.fromViewToRemote(userView);
//           authentification.SignUpUser(userView).subscribeOn(Schedulers.from(new JobExecutor())).observeOn(AndroidSchedulers.mainThread())
//                .subscribeWith(new DisposableCompletableObserver() {
//                    @Override
//                    public void onComplete() {
//                        Log.d(TAG, "onComplete: ");
//                    }
//                    @Override
//                    public void onError(Throwable e) {
//                        Log.d(TAG, "onError: "+e.getMessage());
//                        e.printStackTrace();
//                    }
//                });
//        Log.d(TAG, "onCreate: "+user.getYear());
//        Log.d(TAG, "onCreate: "+user.getPicture());
//        Log.d(TAG, "onCreate: "+user1.getQsolved());
//        Log.d(TAG, "onCreate: "+user1.getEmail());
//        Log.d(TAG, "onCreate: "+user1.getPoints());
//        Log.d(TAG, "onCreate: "+user1.getLevel());
//        Log.d(TAG, "onCreate: "+user1.getName());
//        authentification.signUpUsere(user).subscribeOn(Schedulers.from(new JobExecutor())).observeOn(AndroidSchedulers.mainThread())
//                .subscribeWith(new DisposableCompletableObserver() {
//                    @Override
//                    public void onComplete() {
//                        Log.d(TAG, "onComplete: ");
//                    }
//                    @Override
//                    public void onError(Throwable e) {
//                        Log.d(TAG, "onError: "+e.getMessage());
//                        e.printStackTrace();
//                    }
//                });
//        repository.SaveUserRemote(userView, new DisposableCompletableObserver() {
//            @Override
//            public void onComplete() {
//                Log.d(TAG, "onComplete: ");
//
//            }
//
//            @Override
//            public void onError(Throwable e) {
//                e.printStackTrace();
//        Log.d(TAG, "onFailure: "+e.getLocalizedMessage());
//        Log.d(TAG, "onFailure: "+e.getMessage());
//        Log.d(TAG, "onFailure: "+e.toString());
//               }
//        });

    }

}