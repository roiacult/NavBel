package oxxy.kero.roiaculte.team7.khbich.dagger.component;


import android.content.Context;

import javax.inject.Singleton;

import dagger.Component;
import oxxy.kero.roiaculte.team7.khbich.MyApp;
import oxxy.kero.roiaculte.team7.khbich.dagger.module.AppModule;
import retrofit2.Retrofit;

@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {
    Context context();
    Retrofit retrofit();

}
