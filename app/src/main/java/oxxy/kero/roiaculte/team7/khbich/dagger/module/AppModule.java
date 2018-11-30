package oxxy.kero.roiaculte.team7.khbich.dagger.module;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;

import javax.inject.Singleton;

import androidx.room.PrimaryKey;
import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import oxxy.kero.roiaculte.team7.khbich.MyApp;
import oxxy.kero.roiaculte.team7.khbich.Utils.JobExecutor;
import oxxy.kero.roiaculte.team7.khbich.model.repositories.AuthentificationImpl;
import oxxy.kero.roiaculte.team7.khbich.model.repositories.local.database.LocalData;
import oxxy.kero.roiaculte.team7.khbich.model.repositories.local.database.LocalDatabase;
import oxxy.kero.roiaculte.team7.khbich.model.repositories.local.sharedReference.MainSharedReference;
import oxxy.kero.roiaculte.team7.khbich.model.repositories.remote.DataFlowImpl;
import oxxy.kero.roiaculte.team7.khbich.model.repositories.remote.dataSources.Authentification;
import oxxy.kero.roiaculte.team7.khbich.model.repositories.remote.dataSources.RemoteData;
import oxxy.kero.roiaculte.team7.khbich.model.repositoriesInterfaces.AuthentificationRepository;
import oxxy.kero.roiaculte.team7.khbich.model.repositoriesInterfaces.DataFlowRepository;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class AppModule {
    private final String SharedPreferenceName  ="SHARED_PREFERENCE_NAME";
    private MyApp application ;
    private final String BASE_URL = "http://192.168.43.68/project/";
    public AppModule(MyApp application) {
        this.application = application;
    }

     @Provides @Singleton Retrofit provideRetrofite(Gson gson , OkHttpClient okHttpClient){
        return  new retrofit2.Retrofit.Builder()
                 .baseUrl(BASE_URL).client(okHttpClient)
                 .addConverterFactory(GsonConverterFactory.create(gson))
                 .build();
     }
     @Provides @Singleton
    OkHttpClient provideOkhttpClient (){
        return new OkHttpClient.Builder().addInterceptor(new HttpLoggingInterceptor()
                .setLevel(HttpLoggingInterceptor.Level.BODY)).build();
     }
     @Provides @Singleton
    Gson provideGson (){
        return   new GsonBuilder().setLenient().create();
     }
     @Provides @Singleton
    AuthentificationRepository provideREpository (Authentification auth, JobExecutor executor,MainSharedReference preferenc){
        return new AuthentificationImpl(auth, executor, preferenc);
     }
    @Provides @Singleton
    SharedPreferences provideSharedPreferences(Context context){
        return context.getSharedPreferences(SharedPreferenceName, Context.MODE_PRIVATE);
    }
    @Provides
    @Singleton
    LocalDatabase database(Context context){
        return LocalDatabase.getDatabase(context);
    }
    @Provides @Singleton
    Context getApplicationContext(){
        return application.getApplicationContext() ;
    }

    @Provides @Singleton
    DataFlowRepository provideDataFlowRepo(LocalData testDao, RemoteData data, SharedPreferences preferences){
        return new DataFlowImpl(testDao,data,preferences);
    }
}
