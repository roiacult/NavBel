package oxxy.kero.roiaculte.team7.khbich.dagger.module;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import oxxy.kero.roiaculte.team7.khbich.MyApp;
import oxxy.kero.roiaculte.team7.khbich.Utils.KeyCrypting;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class AppModule {
    private MyApp application ;
    private final String BASE_URL = "http://192.168.43.68/project/";
    public AppModule(MyApp application) {
        this.application = application;
    }
     @Provides @Singleton
     Context getApplicationContext(){
        return application.getApplicationContext() ;
     }


     @Provides @Singleton Retrofit provideRetrofite(Gson gson , OkHttpClient okHttpClient){
        return  new retrofit2.Retrofit.Builder()
                 .baseUrl(BASE_URL).client(okHttpClient)
                 .addConverterFactory(GsonConverterFactory.create(gson))
                 .build();
     }
     @Provides @Singleton
    OkHttpClient provideOkhttpClient (){
        return   new OkHttpClient.Builder().addInterceptor(new HttpLoggingInterceptor()
                .setLevel(HttpLoggingInterceptor.Level.BODY)).build();
     }
     @Provides @Singleton
    Gson provideGson (){
        return   new GsonBuilder().setLenient().create();
     }

}
