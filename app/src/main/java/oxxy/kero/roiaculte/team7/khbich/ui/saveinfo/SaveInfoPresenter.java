package oxxy.kero.roiaculte.team7.khbich.ui.saveinfo;

import androidx.lifecycle.ViewModelProviders;
import oxxy.kero.roiaculte.team7.khbich.base.BasePresenter;

public class SaveInfoPresenter extends BasePresenter<ContractSaveInfo.VIEW> implements ContractSaveInfo.PRESENTER {

    private SaveInfoViewModel viewModel;


    @Override
    public void onAttach(ContractSaveInfo.VIEW mvpView) {
        super.onAttach(mvpView);
        viewModel = ViewModelProviders.of(getView().getBaseActivity()).get(SaveInfoViewModel.class);
    }

    @Override
    public void onNextClicked() {

    }
}
