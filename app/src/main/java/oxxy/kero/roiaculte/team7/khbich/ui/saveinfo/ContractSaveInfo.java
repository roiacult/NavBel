package oxxy.kero.roiaculte.team7.khbich.ui.saveinfo;

import android.content.Intent;
import android.graphics.Bitmap;

import androidx.annotation.Nullable;
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
        void onActivityResult(int requestCode, int resultCode, @Nullable Intent data);
    }
}