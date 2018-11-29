package oxxy.kero.roiaculte.team7.khbich.ui.registration;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import oxxy.kero.roiaculte.team7.khbich.model.models.UserState;
import oxxy.kero.roiaculte.team7.khbich.ui.UserView;

public class RegistrationViewModel extends ViewModel {

    public static final int FRAGMENT_LOG_IN =1;
    public static final int FRAGMENT_REGISTRE=2;

    private int fragment;
    private LiveData<UserState> userState;


    public RegistrationViewModel() {
        fragment = FRAGMENT_REGISTRE;
    }

    public int getFragment() {
        return fragment;
    }

    public void setFragment(int fragment) {
        this.fragment = fragment;
    }

    public LiveData<UserState> getUserState() {
        return userState;
    }

    public void setUserState(LiveData<UserState> userState) {
        this.userState = userState;
    }

}
