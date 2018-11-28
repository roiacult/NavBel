package oxxy.kero.roiaculte.team7.khbich.ui.Registration.Login;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import oxxy.kero.roiaculte.team7.khbich.R;
import oxxy.kero.roiaculte.team7.khbich.base.BaseFragment;
import oxxy.kero.roiaculte.team7.khbich.databinding.LoginBinding;


public class Login  extends BaseFragment implements LoginContract.VIEW {


    private LoginBinding binding;
    @Inject LoginContract.PRESENTER presenter;

    public static Login getInstance() {
        return new Login();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding  = DataBindingUtil.inflate(inflater,R.layout.login,container, false);

        return binding.getRoot();
    }

    @Override
    public String getEmail() {
        return binding.loginEmail.getText().toString();
    }

    @Override
    public String getPassword() {
        return binding.loginPassword.getText().toString();
    }
}
