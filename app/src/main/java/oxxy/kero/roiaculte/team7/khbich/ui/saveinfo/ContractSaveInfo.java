package oxxy.kero.roiaculte.team7.khbich.ui.saveinfo;

import android.graphics.Bitmap;

import oxxy.kero.roiaculte.team7.khbich.base.MvpBasePresenter;
import oxxy.kero.roiaculte.team7.khbich.base.MvpView;
import oxxy.kero.roiaculte.team7.khbich.ui.UserView;

public class ContractSaveInfo{

    public interface VIEW extends MvpView {
        String getName();
        String getPrenam();
        void setUser(UserView user);
        Bitmap getImage();
    }

    public interface PRESENTER extends MvpBasePresenter<VIEW> {
        void onNextClicked();
    }
}