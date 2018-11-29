package oxxy.kero.roiaculte.team7.khbich.dagger.component;

import dagger.Component;
import oxxy.kero.roiaculte.team7.khbich.ui.main.Profile.Profile;
import oxxy.kero.roiaculte.team7.khbich.ui.registration.login.Login;
import oxxy.kero.roiaculte.team7.khbich.ui.registration.signIn.SignIn;
import oxxy.kero.roiaculte.team7.khbich.dagger.PerActivity;
import oxxy.kero.roiaculte.team7.khbich.dagger.module.ActivityModule;
import oxxy.kero.roiaculte.team7.khbich.dagger.module.UserModule;
@PerActivity
@Component( dependencies = AppComponent.class, modules = {UserModule.class, ActivityModule.class})
public interface UserComponent {

    void inject(SignIn signIn);
    void inject(Login login);

    void inject(Profile profile);

}
