package oxxy.kero.roiaculte.team7.khbich.ui.saveinfo;

import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;

import java.util.Calendar;

import androidx.lifecycle.ViewModelProviders;
import io.reactivex.observers.DisposableCompletableObserver;
import oxxy.kero.roiaculte.team7.khbich.base.BasePresenter;
import oxxy.kero.roiaculte.team7.khbich.model.repositoriesInterfaces.AuthentificationRepository;
import oxxy.kero.roiaculte.team7.khbich.ui.main.Main;

public class SaveInfoPresenter extends BasePresenter<ContractSaveInfo.VIEW> implements ContractSaveInfo.PRESENTER {

    private SaveInfoViewModel viewModel;
    private AuthentificationRepository repo;


    public SaveInfoPresenter(AuthentificationRepository repository) {
        this.repo = repository;
    }

    @Override
    public void onAttach(ContractSaveInfo.VIEW mvpView) {
        super.onAttach(mvpView);
        viewModel = ViewModelProviders.of(getView().getBaseActivity()).get(SaveInfoViewModel.class);
    }

    @Override
    public void onNextClicked() {

        if (TextUtils.isEmpty(getView().getName()) || TextUtils.isEmpty(getView().getPrenam())){
            getView().showToast("please fill the information ");
            return;
        }

        viewModel.getUserView().setDate(Calendar.getInstance().getTime());
        repo.SaveUserRemote(viewModel.getUserView(),new SaveUserObserver());
    }

    private class SaveUserObserver extends DisposableCompletableObserver {

        @Override
        public void onComplete() {
            //TODO open main
            getView().getBaseActivity().startActivity(new Intent(getView().getBaseActivity(),Main.class));
            getView().getBaseActivity().finish();
        }

        @Override
        public void onError(Throwable e) {
            Log.d("errr", "onError: "+ e.getMessage());
            e.printStackTrace();
            getView().showToast("Somthing went wrong !!");
        }
    }

}
