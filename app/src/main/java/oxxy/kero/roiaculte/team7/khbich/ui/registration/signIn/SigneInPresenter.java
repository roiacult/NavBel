package oxxy.kero.roiaculte.team7.khbich.ui.registration.signIn;

import android.content.Intent;
import android.text.TextUtils;
import androidx.lifecycle.ViewModelProviders;
import oxxy.kero.roiaculte.team7.khbich.Utils.YearConverter;
import oxxy.kero.roiaculte.team7.khbich.base.BasePresenter;
import oxxy.kero.roiaculte.team7.khbich.model.models.UserState;
import oxxy.kero.roiaculte.team7.khbich.model.repositoriesInterfaces.AuthentificationRepository;
import oxxy.kero.roiaculte.team7.khbich.ui.registration.Registration;
import oxxy.kero.roiaculte.team7.khbich.ui.registration.RegistrationViewModel;
import oxxy.kero.roiaculte.team7.khbich.ui.saveinfo.SaveInfo;

public class SigneInPresenter extends BasePresenter<ContractSignIn.VIEW> implements ContractSignIn.PRESENTER {

    public static String YEAR = "year";

    private ContractSignIn.VIEW view;
    private RegistrationViewModel viewModel;
    private AuthentificationRepository repo;

    @Override
    public void onAttach(ContractSignIn.VIEW mvpView) {
        super.onAttach(mvpView);
        if (getView()!= null){
            viewModel = ViewModelProviders.of(getView().getBaseActivity()).get(RegistrationViewModel.class);
        }
    }

    public SigneInPresenter(AuthentificationRepository repo) {
        this.repo = repo;
    }

    @Override
    public void onLoginCliked() {
        ((Registration)getView().getBaseActivity()).loadLogin();
    }

    @Override
    public void onSubmitCliked() {
        if (getView()!= null) {

            if(TextUtils.isEmpty(getView().getEmail()) ){
                getView().showToast("Email should not be empty");
                return;
            }
            if (TextUtils.isEmpty(getView().getPasssword()) || getView().getPasssword().length()<8 ){
                getView().showToast("Passsword is invalid ");
                return;
            }

            if(!getView().getPasssword().equals(getView().getRepeatPassword())){
                getView().showToast("password are not the same");
                return;
            }
            getView().showLoading(true);


            viewModel.setUserState(repo.checkUser(getView().getEmail()));

            viewModel.getUserState().observe(getView().getBaseActivity(),new USerStateObserver());
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();

    }

    private class USerStateObserver implements androidx.lifecycle.Observer<UserState> {

        @Override
        public void onChanged(UserState userState) {

            getView().showLoading(false);

            switch (userState){
                case USER_DONT_EXISTE :
                    getView().showMessage("User not exist");
                    break;
                case USER_ALREADY_REGISTRED:
                    getView().showMessage("you are alredy registered");
                    break;

                default: //todo start save info activity
                    Intent intent = new Intent(getView().getBaseActivity(),SaveInfo.class);
                    intent.putExtra(YEAR,YearConverter.from(userState));
                    getView().getBaseActivity().startActivity(intent);
                    getView().getBaseActivity().finish();
            }
        }

    }
}
