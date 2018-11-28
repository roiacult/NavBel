package oxxy.kero.roiaculte.team7.khbich.dagger.module;

import dagger.Module;
import dagger.Provides;
import oxxy.kero.roiaculte.team7.khbich.model.repositoriesInterfaces.AuthentificationRepository;
import oxxy.kero.roiaculte.team7.khbich.ui.Registration.Login.LoginContract;
import oxxy.kero.roiaculte.team7.khbich.ui.Registration.Login.LoginPresenter;
import oxxy.kero.roiaculte.team7.khbich.ui.Registration.signIn.ContractSignIn;
import oxxy.kero.roiaculte.team7.khbich.ui.Registration.signIn.SigneInPresenter;
import oxxy.kero.roiaculte.team7.khbich.dagger.PerActivity;

@Module
public class UserModule {

    @Provides @PerActivity
    ContractSignIn.PRESENTER provideSignIn(AuthentificationRepository repo){
        return new SigneInPresenter(repo);
    }

    @Provides @PerActivity
    LoginContract.PRESENTER provdeLogin(){
        return new LoginPresenter();
    }

}
