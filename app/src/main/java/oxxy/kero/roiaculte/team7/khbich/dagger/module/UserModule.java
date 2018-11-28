package oxxy.kero.roiaculte.team7.khbich.dagger.module;

import dagger.Module;
import dagger.Provides;
import oxxy.kero.roiaculte.team7.khbich.ui.Registration.signIn.ContractSignIn;
import oxxy.kero.roiaculte.team7.khbich.ui.Registration.signIn.SigneInPresenter;
import oxxy.kero.roiaculte.team7.khbich.dagger.PerActivity;

@Module
public class UserModule {

    @Provides @PerActivity
    ContractSignIn.PRESENTER provideSignIn(){
        return new SigneInPresenter();
    }

}
