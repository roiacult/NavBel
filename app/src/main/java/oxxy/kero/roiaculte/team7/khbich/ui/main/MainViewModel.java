package oxxy.kero.roiaculte.team7.khbich.ui.main;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import oxxy.kero.roiaculte.team7.khbich.ui.UserView;

public class MainViewModel extends ViewModel {

    private LiveData<UserView> user;

    public LiveData<UserView> getUser() {
        return user;
    }

    public void setUser(LiveData<UserView> user) {
        this.user = user;
    }
}
