package oxxy.kero.roiaculte.team7.khbich.ui.splash;

import android.content.Intent;

import androidx.lifecycle.Observer;
import oxxy.kero.roiaculte.team7.khbich.base.BasePresenter;
import oxxy.kero.roiaculte.team7.khbich.model.repositoriesInterfaces.AuthentificationRepository;
import oxxy.kero.roiaculte.team7.khbich.ui.main.Main;
import oxxy.kero.roiaculte.team7.khbich.ui.registration.Registration;

public class SplashPresnter extends BasePresenter<SplashCotract.VIEW> implements SplashCotract.PRESENTER {

    private AuthentificationRepository repo;

    public SplashPresnter(AuthentificationRepository repo) {
        this.repo = repo;
    }

    @Override
    public void onAttach(SplashCotract.VIEW mvpView) {
        super.onAttach(mvpView);

        repo.isUserLoggedIn().observe(getView().getBaseActivity(), new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if (aBoolean){
                    loadMain();
                }else {
                    loadSignIn();
                }
                getView().getBaseActivity().finish();
            }
        });
    }

    @Override
    public void loadMain() {
        getView().getBaseActivity().startActivity(new Intent(getView().getBaseActivity(),Main.class));

    }

    @Override
    public void loadSignIn() {
        getView().getBaseActivity().startActivity(new Intent(getView().getBaseActivity(),Registration.class));
    }
}
