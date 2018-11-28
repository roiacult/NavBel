package oxxy.kero.roiaculte.team7.khbich.model.remote.splash;

import oxxy.kero.roiaculte.team7.khbich.base.MvpBasePresenter;
import oxxy.kero.roiaculte.team7.khbich.base.MvpView;

public class SplashCotract {

    interface VIEW extends MvpView{

        void loadMain();
        void loadSignIn();

    }
    interface PRESENTER extends MvpBasePresenter<VIEW>{

    }
}
