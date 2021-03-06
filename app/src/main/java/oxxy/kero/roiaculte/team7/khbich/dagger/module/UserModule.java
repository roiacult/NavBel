package oxxy.kero.roiaculte.team7.khbich.dagger.module;

import androidx.room.PrimaryKey;
import dagger.Module;
import dagger.Provides;
import oxxy.kero.roiaculte.team7.khbich.model.repositoriesInterfaces.AuthentificationRepository;
import oxxy.kero.roiaculte.team7.khbich.model.repositoriesInterfaces.DataFlowRepository;
import oxxy.kero.roiaculte.team7.khbich.ui.main.Profile.ContractProfile;
import oxxy.kero.roiaculte.team7.khbich.ui.main.Profile.ProfilePresenter;
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
    ContractSignIn.PRESENTER provideSignIn(AuthentificationRepository repo, DataFlowRepository flowRepository){
        return new SigneInPresenter(repo,flowRepository);
    }

    @Provides @PerActivity
    LoginContract.PRESENTER provdeLogin(AuthentificationRepository repo,DataFlowRepository flowRepository){
        return new LoginPresenter(repo,flowRepository);
    }

    @Provides @PerActivity
    ContractSaveInfo.PRESENTER provideSaveInfo(AuthentificationRepository repo){
        return  new SaveInfoPresenter(repo);
    }

    @Provides @PerActivity
    ContractProfile.PRESENTER provideProfile(AuthentificationRepository repo,DataFlowRepository flowRepository){
        return new ProfilePresenter(repo,flowRepository);
    }


}
