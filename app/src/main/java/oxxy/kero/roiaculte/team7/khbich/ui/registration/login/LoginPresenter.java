package oxxy.kero.roiaculte.team7.khbich.ui.registration.login;

import android.content.Intent;
import android.text.TextUtils;

import androidx.lifecycle.ViewModelProviders;
import oxxy.kero.roiaculte.team7.khbich.base.BasePresenter;
import oxxy.kero.roiaculte.team7.khbich.model.repositoriesInterfaces.AuthentificationRepository;
import oxxy.kero.roiaculte.team7.khbich.ui.UserView;
import oxxy.kero.roiaculte.team7.khbich.ui.main.Main;
import oxxy.kero.roiaculte.team7.khbich.ui.registration.Registration;
import oxxy.kero.roiaculte.team7.khbich.ui.registration.RegistrationViewModel;

public class LoginPresenter extends BasePresenter<LoginContract.VIEW> implements LoginContract.PRESENTER {

    private AuthentificationRepository repo;
    private RegistrationViewModel viewModel;


    public LoginPresenter(AuthentificationRepository repo) {
        this.repo = repo;
    }

    @Override
    public void onAttach(LoginContract.VIEW mvpView) {
        super.onAttach(mvpView);
        viewModel = ViewModelProviders.of(getView().getBaseActivity()).get(RegistrationViewModel.class);
    }

    @Override
    public void onLoginCliked() {

        if(TextUtils.isEmpty(getView().getEmail())){
            getView().showToast("email not valid");
            return;
        }

        if (TextUtils.isEmpty(getView().getPassword())|| getView().getPassword().length()<8){
            getView().showToast("passsword not valid");
            return;
        }

        viewModel.setUser(repo.login(getView().getEmail(),getView().getPassword()));
        viewModel.getUser().observe(getView().getBaseActivity(),new LoginObserver());

    }

    @Override
    public void onCreatAcountCliked() {
        ((Registration)getView().getBaseActivity()).removeRegistreAndShowLogin();
    }

    private class LoginObserver implements androidx.lifecycle.Observer<UserView> {

        @Override
        public void onChanged(UserView userView) {
            if (userView == null){
                getView().showToast("your password is  not correct");
                return;
            }

            repo.AddUserLocal(userView);

            getView().getBaseActivity().startActivity(new Intent(getView().getBaseActivity(),Main.class));
            getView().getBaseActivity().finish();
        }
    }

}
