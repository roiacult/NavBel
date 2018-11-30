package oxxy.kero.roiaculte.team7.khbich.ui.registration.login;

import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;


import androidx.lifecycle.ViewModelProviders;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableCompletableObserver;
import io.reactivex.observers.DisposableObserver;
import oxxy.kero.roiaculte.team7.khbich.base.BasePresenter;
import oxxy.kero.roiaculte.team7.khbich.model.repositoriesInterfaces.AuthentificationRepository;
import oxxy.kero.roiaculte.team7.khbich.model.repositoriesInterfaces.DataFlowRepository;
import oxxy.kero.roiaculte.team7.khbich.ui.UserView;
import oxxy.kero.roiaculte.team7.khbich.ui.main.Main;
import oxxy.kero.roiaculte.team7.khbich.ui.registration.Registration;
import oxxy.kero.roiaculte.team7.khbich.ui.registration.RegistrationViewModel;

import static oxxy.kero.roiaculte.team7.khbich.model.repositories.remote.dataSources.Authentification.TAG;

public class LoginPresenter extends BasePresenter<LoginContract.VIEW> implements LoginContract.PRESENTER {

    private AuthentificationRepository repo;
    private DataFlowRepository flowRepository;


    public LoginPresenter(AuthentificationRepository repo,DataFlowRepository flowRepository) {
        this.repo = repo;
        this.flowRepository = flowRepository;
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



        repo.login(getView().getEmail(),getView().getPassword(),new LoginObserver());

    }

    @Override
    public void onCreatAcountCliked() {
        ((Registration)getView().getBaseActivity()).removeRegistreAndShowLogin();
    }

    private class LoginObserver extends DisposableObserver<UserView> {
        @Override
        public void onNext(UserView userView) {

            if (userView == null){
                getView().showToast("your password is  not correct");
                return;
            }
            repo.AddUserLocal(userView);
            if (getView()!= null) {
                repo.AddUserLocal(userView);
                Log.d(TAG, "onNext: logggege");
                flowRepository.updateLOcalDatabase(new UpdateLocal());

            }
        }

        @Override
        public void onError(Throwable e) {
            getView().showMessage("passsword or email is incorrect");
        }

        @Override
        public void onComplete() {

        }
    }
    private class UpdateLocal extends DisposableCompletableObserver{
        @Override
        public void onComplete() {
            getView().getBaseActivity().startActivity(new Intent(getView().getBaseActivity(), Main.class));
            getView().getBaseActivity().finish();
        }

        @Override
        public void onError(Throwable e) {
     e.printStackTrace();
        }
    }

}
