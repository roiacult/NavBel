package oxxy.kero.roiaculte.team7.khbich.ui.splash;

import oxxy.kero.roiaculte.team7.khbich.base.MvpBasePresenter;
import oxxy.kero.roiaculte.team7.khbich.base.MvpView;

public class SplashCotract {

    interface VIEW extends MvpView{


    }
    public interface PRESENTER extends MvpBasePresenter<VIEW>{
        void loadMain();
        void loadSignIn();
    }
}
