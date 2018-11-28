package oxxy.kero.roiaculte.team7.khbich.Registration.signIn;

import android.content.Context;
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
import oxxy.kero.roiaculte.team7.khbich.databinding.SigneinBinding;

public class SignIn extends BaseFragment implements ContractSignIn.VIEW {

    private SigneinBinding binding;
    @Inject ContractSignIn.PRESENTER presenter;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater,R.layout.signein,container,false);
        getComponent().inject(this);
        presenter.onAttach(this);

        return binding.getRoot();
    }

    @Override
    public String getEmail() {
        return binding.signeinEmail.getText().toString();
    }

    @Override
    public String getPasssword() {
        return binding.signeinPassword.getText().toString();
    }

    @Override
    public String getRepeatPassword() {
        return binding.signeinRepeatpassword.getText().toString();
    }

    @Override
    public void showLoading(boolean visible) {
        binding.progressBar.setVisibility(visible ?View.VISIBLE : View.GONE);
    }
}
