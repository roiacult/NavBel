package oxxy.kero.roiaculte.team7.khbich.Registration;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import oxxy.kero.roiaculte.team7.khbich.R;
import oxxy.kero.roiaculte.team7.khbich.Registration.Login.Login;
import oxxy.kero.roiaculte.team7.khbich.Registration.signIn.SignIn;
import oxxy.kero.roiaculte.team7.khbich.base.BaseActivity;
import oxxy.kero.roiaculte.team7.khbich.databinding.ActivityMainBinding;

public class Registration  extends BaseActivity {


    private ActivityMainBinding binding;
    private RegistrationViewModel viewModel;
    private SignIn signIn;
    private Login login;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        viewModel = ViewModelProviders.of(this).get(RegistrationViewModel.class);

        setFragment();
    }



    public void loadSignIn(){
        if(signIn == null) signIn = new SignIn();

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.main_activity_framelayout,signIn)
                .commit();

        viewModel.setFragment(RegistrationViewModel.FRAGMENT_REGISTRE);
    }


    public void setFragment(){
        switch (viewModel.getFragment()){
            case  RegistrationViewModel.FRAGMENT_REGISTRE :
                loadSignIn();
                break;

            case RegistrationViewModel.FRAGMENT_LOG_IN:
                loadLogin();
                break;
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.main_activity_framelayout);
        if(fragment == signIn){
            viewModel.setFragment(RegistrationViewModel.FRAGMENT_REGISTRE);
        }else if(fragment == login){
            viewModel.setFragment(RegistrationViewModel.FRAGMENT_LOG_IN);
        }
    }

    public void removeRegistreAndShowLogin(){
        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.main_activity_framelayout);


        if(fragment == login) {
            viewModel.setFragment(RegistrationViewModel.FRAGMENT_REGISTRE);
            getSupportFragmentManager().popBackStack();
        }

    }


    public void loadLogin(){

    }

    public RegistrationViewModel getViewModel() {
        return viewModel;
    }

    public  void goToSaveInfo(){
        //todo go to save info
    }

    public void goToMain(){
        //todo go to main
    }
}
