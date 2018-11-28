package oxxy.kero.roiaculte.team7.khbich.ui.Registration.signIn;


import oxxy.kero.roiaculte.team7.khbich.base.BaseActivity;
import oxxy.kero.roiaculte.team7.khbich.base.MvpBasePresenter;
import oxxy.kero.roiaculte.team7.khbich.base.MvpView;
import oxxy.kero.roiaculte.team7.khbich.ui.Registration.Registration;

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
