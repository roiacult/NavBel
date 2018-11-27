package oxxy.kero.roiaculte.team7.khbich.dagger.component;

import dagger.Component;
import oxxy.kero.roiaculte.team7.khbich.dagger.PerActivity;
import oxxy.kero.roiaculte.team7.khbich.dagger.module.ActivityModule;
import oxxy.kero.roiaculte.team7.khbich.dagger.module.UserModule;
@PerActivity
@Component( dependencies = AppComponent.class, modules = {UserModule.class, ActivityModule.class})
public interface UserComponent {

}
