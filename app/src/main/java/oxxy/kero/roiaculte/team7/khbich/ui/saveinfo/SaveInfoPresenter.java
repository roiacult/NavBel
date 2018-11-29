package oxxy.kero.roiaculte.team7.khbich.ui.saveinfo;

import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;

import com.theartofdev.edmodo.cropper.CropImage;

import java.util.Calendar;

import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProviders;
import io.reactivex.observers.DisposableCompletableObserver;
import oxxy.kero.roiaculte.team7.khbich.Utils.ImageUtil;
import oxxy.kero.roiaculte.team7.khbich.base.BasePresenter;
import oxxy.kero.roiaculte.team7.khbich.model.repositoriesInterfaces.AuthentificationRepository;
import oxxy.kero.roiaculte.team7.khbich.ui.main.Main;

import static android.app.Activity.RESULT_OK;

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
            repo.AddUserLocal(viewModel.getUserView());
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

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE) {
            CropImage.ActivityResult result = CropImage.getActivityResult(data);
            if(resultCode == RESULT_OK && result.getBitmap() != null){
                viewModel.getUserView().setPicture(ImageUtil.convert(result.getBitmap()));
            }
        }
    }
}
