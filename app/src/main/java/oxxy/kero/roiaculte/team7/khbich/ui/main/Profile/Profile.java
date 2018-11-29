package oxxy.kero.roiaculte.team7.khbich.ui.main.Profile;

import android.os.Bundle;

import javax.inject.Inject;

import androidx.annotation.Nullable;
import oxxy.kero.roiaculte.team7.khbich.base.BaseActivity;
import oxxy.kero.roiaculte.team7.khbich.databinding.ProfileBinding;

public class Profile extends BaseActivity implements ContractProfile.VIEW {

    private ProfileBinding binding;
    @Inject ContractProfile.PRESENTER presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
