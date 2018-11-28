package oxxy.kero.roiaculte.team7.khbich.dagger.module;

import dagger.Module;
import dagger.Provides;
import oxxy.kero.roiaculte.team7.khbich.model.repositoriesInterfaces.AuthentificationRepository;
import oxxy.kero.roiaculte.team7.khbich.ui.registration.login.LoginContract;
import oxxy.kero.roiaculte.team7.khbich.ui.registration.login.LoginPresenter;
import oxxy.kero.roiaculte.team7.khbich.ui.registration.signIn.ContractSignIn;
import oxxy.kero.roiaculte.team7.khbich.ui.registration.signIn.SigneInPresenter;
import oxxy.kero.roiaculte.team7.khbich.dagger.PerActivity;
import oxxy.kero.roiaculte.team7.khbich.ui.saveinfo.ContractSaveInfo;
import oxxy.kero.roiaculte.team7.khbich.ui.saveinfo.SaveInfoPresenter;
import oxxy.kero.roiaculte.team7.khbich.ui.splash.SplashCotract;
import oxxy.kero.roiaculte.team7.khbich.ui.splash.SplashPresnter;

@Module
public class UserModule {

    @Provides @PerActivity
    ContractSignIn.PRESENTER provideSignIn(AuthentificationRepository repo){
        return new SigneInPresenter(repo);
    }

    @Provides @PerActivity
    LoginContract.PRESENTER provdeLogin(AuthentificationRepository repo){
        return new LoginPresenter(repo);
    }

    @Provides @PerActivity
    ContractSaveInfo.PRESENTER provideSaveInfo(AuthentificationRepository repo){
        return  new SaveInfoPresenter(repo);
    }


}
