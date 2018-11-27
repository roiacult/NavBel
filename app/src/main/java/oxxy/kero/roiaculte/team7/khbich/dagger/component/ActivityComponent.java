package oxxy.kero.roiaculte.team7.khbich.dagger.component;

import dagger.Component;
import oxxy.kero.roiaculte.team7.khbich.dagger.PerActivity;
import oxxy.kero.roiaculte.team7.khbich.dagger.module.ActivityModule;
@PerActivity
@Component(dependencies = AppComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

}
