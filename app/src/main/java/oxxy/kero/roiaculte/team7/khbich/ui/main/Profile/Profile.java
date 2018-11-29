package oxxy.kero.roiaculte.team7.khbich.ui.main.Profile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import oxxy.kero.roiaculte.team7.khbich.R;
import oxxy.kero.roiaculte.team7.khbich.base.BaseActivity;
import oxxy.kero.roiaculte.team7.khbich.base.BaseFragment;
import oxxy.kero.roiaculte.team7.khbich.databinding.ProfileBinding;

public class Profile extends BaseFragment implements ContractProfile.VIEW {

    private ProfileBinding binding;
    @Inject ContractProfile.PRESENTER presenter;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        getComponent().inject(this) ;

        binding = DataBindingUtil.inflate(inflater,R.layout.profile,container,false);
        presenter.onAttach(this);
        return binding.getRoot();
    }

    @Override
    public void setName(String name) {
        binding.name.setText(name);
    }

    @Override
    public void setPoint(String point) {
        binding.ponints.setText(point);
    }

    @Override
    public void setLevel(String level) {
        binding.level.setText(level);
    }

    @Override
    public void setTests(String tests) {
        binding.qsolved.setText(tests);
    }
}
