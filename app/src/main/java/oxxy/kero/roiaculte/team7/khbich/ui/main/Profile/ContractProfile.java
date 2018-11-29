package oxxy.kero.roiaculte.team7.khbich.ui.main.Profile;

import oxxy.kero.roiaculte.team7.khbich.base.MvpBasePresenter;
import oxxy.kero.roiaculte.team7.khbich.base.MvpView;
import oxxy.kero.roiaculte.team7.khbich.ui.registration.signIn.ContractSignIn;

public class ContractProfile {

    public interface VIEW extends MvpView {

        void setName(String name);
        void setPoint(String point);
        void setLevel(String level);
        void setTests(String tests);
    }

    public interface PRESENTER extends MvpBasePresenter<ContractProfile.VIEW> {
    }
}
