package oxxy.kero.roiaculte.team7.khbich;

import android.app.Application;

import oxxy.kero.roiaculte.team7.khbich.dagger.component.AppComponent;
import oxxy.kero.roiaculte.team7.khbich.dagger.component.DaggerAppComponent;
import oxxy.kero.roiaculte.team7.khbich.dagger.module.AppModule;

public class MyApp extends Application {
    AppComponent component ;
    @Override
    public void onCreate() {
        super.onCreate();
        component = DaggerAppComponent.builder().
                appModule(new AppModule(this)).build();
    }
    public AppComponent getComponent(){
        return component;
    }
}
