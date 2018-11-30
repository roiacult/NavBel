package oxxy.kero.roiaculte.team7.khbich.ui.main.Profile;

import android.util.Log;

import java.util.List;

import androidx.lifecycle.ViewModelProviders;
import androidx.room.util.StringUtil;
import io.reactivex.observers.DisposableObserver;
import oxxy.kero.roiaculte.team7.khbich.base.BasePresenter;
import oxxy.kero.roiaculte.team7.khbich.model.models.Test;
import oxxy.kero.roiaculte.team7.khbich.model.repositoriesInterfaces.AuthentificationRepository;
import oxxy.kero.roiaculte.team7.khbich.model.repositoriesInterfaces.DataFlowRepository;
import oxxy.kero.roiaculte.team7.khbich.ui.UserView;
import oxxy.kero.roiaculte.team7.khbich.ui.main.MainViewModel;

import static oxxy.kero.roiaculte.team7.khbich.MainActivity.TAG;

public class ProfilePresenter extends BasePresenter<ContractProfile.VIEW> implements ContractProfile.PRESENTER {

    private AuthentificationRepository repo;
    private DataFlowRepository flowRepo;
    private MainViewModel viewModel;

    public ProfilePresenter(AuthentificationRepository repo,DataFlowRepository flowRepository) {
        this.repo = repo;
        this.flowRepo = flowRepository;
    }

    @Override
    public void onAttach(ContractProfile.VIEW mvpView) {
        super.onAttach(mvpView);
        viewModel = ViewModelProviders.of(getView().getBaseActivity()).get(MainViewModel.class);
        viewModel.setUser(repo.getUserLocal());
        viewModel.getUser().observe(getView().getBaseActivity(),new UserObserver());

//        viewModel.setTests(repo.get);
        flowRepo.getTestSolved(new DisposableObserver<List<Test>>() {
            @Override
            public void onNext(List<Test> tests) {
                viewModel.setTests(tests);
                Log.d(TAG, "onNext: "+"bsbsbsbbsb");
                Log.d(TAG, "onNext: "+tests.size());
                if (tests == null || tests.size() == 0) getView().showMessage("list est vide");
                else {
                    getView().showMessage("list n'est pas vide");
                    //TODO notify adapter
                    getView().notifyAdapter();
                }

            }

            @Override
            public void onError(Throwable e) {
                getView().showMessage("onError");
            }

            @Override
            public void onComplete() {

            }
        });
    }

    private class UserObserver implements androidx.lifecycle.Observer<UserView> {
        @Override
        public void onChanged(UserView userView) {

            String name = userView.getName();
            String  prenam = userView.getPrename();
            String qSoleved = userView.getQsolved();
            if (name == null) name="";
            getView().setName(userView.getName());
            getView().setLevel(String.valueOf(userView.getLevel()));
            getView().setPoint(String.valueOf(userView.getPoints()));

            getView().setTests(String.valueOf(qSoleved.length()-qSoleved.replace("@","").length()));
            getView().setImage(userView.getPictureUri());
        }
    }
}
