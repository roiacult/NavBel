package oxxy.kero.roiaculte.team7.khbich.ui.registration.signIn;


import oxxy.kero.roiaculte.team7.khbich.base.MvpBasePresenter;
import oxxy.kero.roiaculte.team7.khbich.base.MvpView;

public class ContractSignIn {

    public interface VIEW extends MvpView {

        String getEmail();
        String getPasssword();
        String getRepeatPassword();
        void showLoading(final  boolean visible);
    }

    public interface PRESENTER extends MvpBasePresenter<VIEW> {


        void onLoginCliked();
        void onSubmitCliked();


    }
}
