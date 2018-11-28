package oxxy.kero.roiaculte.team7.khbich.ui.saveinfo;

import androidx.lifecycle.ViewModel;
import oxxy.kero.roiaculte.team7.khbich.ui.UserView;

public class SaveInfoViewModel extends ViewModel {

    private UserView userView;

    public UserView getUserView() {
        if(userView == null) userView = new UserView();
        return userView;
    }

    public void setUserView(UserView userView) {
        this.userView = userView;
    }
}
