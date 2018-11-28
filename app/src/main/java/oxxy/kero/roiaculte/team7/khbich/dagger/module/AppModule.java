package oxxy.kero.roiaculte.team7.khbich.dagger.module;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import oxxy.kero.roiaculte.team7.khbich.MyApp;
import oxxy.kero.roiaculte.team7.khbich.Utils.KeyCrypting;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class AppModule {
    MyApp application ;
    private String BASE_URL = "http://192.168.43.68/project/index.php?skey="+KeyCrypting.CrypteIt();


    public AppModule(MyApp application) {
        this.application = application;
    }
     @Provides @Singleton
     Context getApplicationContext(){
        return application.getApplicationContext() ;
     }
     @Provides @Singleton Retrofit provideRetrofite(){
        return  new retrofit2.Retrofit.Builder()
                 .baseUrl(BASE_URL)
                 .addConverterFactory(GsonConverterFactory.create())
                 .build();
     }
}
