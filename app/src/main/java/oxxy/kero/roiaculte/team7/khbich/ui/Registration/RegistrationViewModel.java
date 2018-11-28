package oxxy.kero.roiaculte.team7.khbich.ui.Registration;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import oxxy.kero.roiaculte.team7.khbich.model.models.UserState;

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
