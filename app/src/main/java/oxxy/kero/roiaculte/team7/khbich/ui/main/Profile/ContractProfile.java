package oxxy.kero.roiaculte.team7.khbich.ui.main.Profile;

import android.net.Uri;

import java.util.List;

import oxxy.kero.roiaculte.team7.khbich.base.MvpBasePresenter;
import oxxy.kero.roiaculte.team7.khbich.base.MvpView;
import oxxy.kero.roiaculte.team7.khbich.model.models.Test;
import oxxy.kero.roiaculte.team7.khbich.ui.registration.signIn.ContractSignIn;

public class ContractProfile {

    public interface VIEW extends MvpView {

        void setName(String name);
        void setPoint(String point);
        void setLevel(String level);
        void setTests(String tests);
        void notifyAdapter();
        void setImage(Uri path);
    }

    public interface PRESENTER extends MvpBasePresenter<ContractProfile.VIEW> {
    }
}
