package oxxy.kero.roiaculte.team7.khbich.dagger.component;


import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;

import javax.inject.Singleton;

import dagger.Component;
import okhttp3.OkHttpClient;
import oxxy.kero.roiaculte.team7.khbich.MainActivity;
import oxxy.kero.roiaculte.team7.khbich.MyApp;
import oxxy.kero.roiaculte.team7.khbich.base.BaseActivity;
import oxxy.kero.roiaculte.team7.khbich.dagger.module.AppModule;
import oxxy.kero.roiaculte.team7.khbich.model.repositories.local.database.LocalDatabase;
import oxxy.kero.roiaculte.team7.khbich.model.repositoriesInterfaces.AuthentificationRepository;
import oxxy.kero.roiaculte.team7.khbich.model.repositoriesInterfaces.DataFlowRepository;
import retrofit2.Retrofit;

@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {
    void inject(BaseActivity activity );
    void inject(MainActivity activity);

    Context context();
    Retrofit retrofit();
    OkHttpClient okhttpClient();
    Gson gson();
    LocalDatabase localDatabase();
    AuthentificationRepository getAuthRepo();
    DataFlowRepository getDataFlowReop();
    SharedPreferences sharedpreference();

}
