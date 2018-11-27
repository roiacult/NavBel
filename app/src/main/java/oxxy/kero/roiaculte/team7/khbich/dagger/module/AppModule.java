package oxxy.kero.roiaculte.team7.khbich.dagger.module;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import oxxy.kero.roiaculte.team7.khbich.MyApp;
@Module
public class AppModule {
    MyApp application ;

    public AppModule(MyApp application) {
        this.application = application;
    }
     @Provides @Singleton
     Context getApplicationContext(){
        return application.getApplicationContext() ;
     }

}
