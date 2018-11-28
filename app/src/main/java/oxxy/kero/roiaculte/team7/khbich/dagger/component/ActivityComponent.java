package oxxy.kero.roiaculte.team7.khbich.dagger.component;

import dagger.Component;
import oxxy.kero.roiaculte.team7.khbich.base.BaseActivity;
import oxxy.kero.roiaculte.team7.khbich.dagger.PerActivity;
import oxxy.kero.roiaculte.team7.khbich.dagger.module.ActivityModule;
import oxxy.kero.roiaculte.team7.khbich.ui.saveinfo.SaveInfo;
import oxxy.kero.roiaculte.team7.khbich.ui.splash.SplashScren;
import retrofit2.Retrofit;

@PerActivity
@Component(dependencies = AppComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(SaveInfo saveInfo);
    void inject(SplashScren splashScren);
}
