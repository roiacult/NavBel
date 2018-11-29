package oxxy.kero.roiaculte.team7.khbich.ui.main.Profile;

import androidx.lifecycle.ViewModelProviders;
import oxxy.kero.roiaculte.team7.khbich.base.BasePresenter;
import oxxy.kero.roiaculte.team7.khbich.model.repositoriesInterfaces.AuthentificationRepository;
import oxxy.kero.roiaculte.team7.khbich.ui.UserView;
import oxxy.kero.roiaculte.team7.khbich.ui.main.MainViewModel;

public class ProfilePresenter extends BasePresenter<ContractProfile.VIEW> implements ContractProfile.PRESENTER {

    private AuthentificationRepository repo;
    private MainViewModel viewModel;

    public ProfilePresenter(AuthentificationRepository repo) {
        this.repo = repo;
        viewModel = ViewModelProviders.of(getView().getBaseActivity()).get(MainViewModel.class);
        viewModel.setUser(repo.getUserLocal());

        viewModel.getUser().observe(getView().getBaseActivity(),new UserObserver());
    }

    @Override
    public void onAttach(ContractProfile.VIEW mvpView) {
        super.onAttach(mvpView);

    }

    private class UserObserver implements androidx.lifecycle.Observer<UserView> {
        @Override
        public void onChanged(UserView userView) {
            getView().setName(userView.getName()+", "+userView.getPrename());
            getView().setLevel(String.valueOf(userView.getLevel()));
            getView().setPoint(String.valueOf(userView.getPoints()));
            getView().setTests(userView.getQsolved());
        }
    }
}
