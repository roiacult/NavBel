package oxxy.kero.roiaculte.team7.khbich.ui.Registration.Login;


import oxxy.kero.roiaculte.team7.khbich.base.BasePresenter;
import oxxy.kero.roiaculte.team7.khbich.base.MvpBasePresenter;
import oxxy.kero.roiaculte.team7.khbich.base.MvpView;

public class LoginContract{

    public interface VIEW extends MvpView {
        String getEmail();
        String getPassword();
    }

    public interface PRESENTER extends MvpBasePresenter<VIEW> {

        void onLoginCliked();
        void onCreatAcountCliked();
    }
}



//public class Contract{
//
//    public interface VIEW{
//
//    }
//
//    public interface PRESENTER{
//
//    }
//}
