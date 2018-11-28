package oxxy.kero.roiaculte.team7.khbich.Registration;

import androidx.lifecycle.ViewModel;

public class RegistrationViewModel extends ViewModel {

    public static final int FRAGMENT_LOG_IN =1;
    public static final int FRAGMENT_REGISTRE=2;

    private int fragment;


    public RegistrationViewModel() {
        fragment = FRAGMENT_REGISTRE;
    }

    public int getFragment() {
        return fragment;
    }

    public void setFragment(int fragment) {
        this.fragment = fragment;
    }
}
