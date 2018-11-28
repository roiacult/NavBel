package oxxy.kero.roiaculte.team7.khbich.dagger.module;

import dagger.Module;
import dagger.Provides;
import oxxy.kero.roiaculte.team7.khbich.Registration.signIn.ContractSignIn;
import oxxy.kero.roiaculte.team7.khbich.Registration.signIn.SigneInPresenter;
import oxxy.kero.roiaculte.team7.khbich.base.BaseFragment;
import oxxy.kero.roiaculte.team7.khbich.dagger.PerActivity;

@Module
public class UserModule {

    @Provides @PerActivity
    ContractSignIn.PRESENTER provideSignIn(){
        return new SigneInPresenter();
    }

}
