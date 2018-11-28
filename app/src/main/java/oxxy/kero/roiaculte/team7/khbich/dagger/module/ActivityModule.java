package oxxy.kero.roiaculte.team7.khbich.dagger.module;

import dagger.Module;
import dagger.Provides;
import oxxy.kero.roiaculte.team7.khbich.base.BaseActivity;
import oxxy.kero.roiaculte.team7.khbich.dagger.PerActivity;
import oxxy.kero.roiaculte.team7.khbich.model.repositoriesInterfaces.AuthentificationRepository;
import oxxy.kero.roiaculte.team7.khbich.ui.saveinfo.ContractSaveInfo;
import oxxy.kero.roiaculte.team7.khbich.ui.saveinfo.SaveInfoPresenter;
import oxxy.kero.roiaculte.team7.khbich.ui.splash.SplashCotract;
import oxxy.kero.roiaculte.team7.khbich.ui.splash.SplashPresnter;

@Module()
public class ActivityModule {
    private BaseActivity activity ;

    public ActivityModule(BaseActivity activity) {
        this.activity = activity;
    }


    @Provides
    @PerActivity
    ContractSaveInfo.PRESENTER provideSaveInfo(AuthentificationRepository repo){
        return  new SaveInfoPresenter(repo);
    }


    @Provides @PerActivity
    SplashCotract.PRESENTER provideSplash(AuthentificationRepository repo){
        return new SplashPresnter(repo);
    }

}
