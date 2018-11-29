package oxxy.kero.roiaculte.team7.khbich.ui.saveinfo;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;

import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;

import javax.inject.Inject;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;
import oxxy.kero.roiaculte.team7.khbich.R;
import oxxy.kero.roiaculte.team7.khbich.Utils.ImageUtil;
import oxxy.kero.roiaculte.team7.khbich.Utils.YearConverter;
import oxxy.kero.roiaculte.team7.khbich.base.BaseActivity;
import oxxy.kero.roiaculte.team7.khbich.databinding.SaveInfoBinding;
import oxxy.kero.roiaculte.team7.khbich.ui.UserView;
import oxxy.kero.roiaculte.team7.khbich.ui.registration.signIn.SigneInPresenter;

public class SaveInfo extends BaseActivity implements ContractSaveInfo.VIEW {

    private SaveInfoBinding binding;
    private SaveInfoViewModel viewModel;
    @Inject ContractSaveInfo.PRESENTER presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this ,R.layout.save_info);
        viewModel = ViewModelProviders.of(this).get(SaveInfoViewModel.class);
        getComponent().inject(this);
        presenter.onAttach(this);

        if (savedInstanceState == null){
            viewModel.getUserView().setYear(YearConverter.to(getIntent().getStringExtra(SigneInPresenter.YEAR)));
            viewModel.getUserView().setEmail(getIntent().getStringExtra(SigneInPresenter.EMAIL));
            viewModel.getUserView().setPassword(getIntent().getStringExtra(SigneInPresenter.PASSWORD));
        }

        setUser(viewModel.getUserView());

        binding.signeInName.addOnLayoutChangeListener(new View.OnLayoutChangeListener() {
            @Override
            public void onLayoutChange(View v, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
                viewModel.getUserView().setName(getName());
            }
        });

        binding.signeInPrenom.addOnLayoutChangeListener(new View.OnLayoutChangeListener() {
            @Override
            public void onLayoutChange(View v, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
                viewModel.getUserView().setPrename(getPrenam());
            }
        });

        binding.signeInNextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onNextClicked();
            }
        });

        binding.signeInImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CropImage.activity()
                .setCropShape ( CropImageView.CropShape.OVAL )
                .setAspectRatio(1,1 )
                .start(SaveInfo.this);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
//        presenter.onActivityResult(requestCode,resultCode,data);
        if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE) {
            CropImage.ActivityResult result = CropImage.getActivityResult(data);
            if(resultCode == RESULT_OK ){

                if (result.getBitmap() == null) {
                    showToast("Image is null");
                    return;
                }
                viewModel.getUserView().setPicture(ImageUtil.convert(result.getBitmap()));
            }
        }
    }

    @Override
    public String getName() {
        return binding.signeInName.getText().toString();
    }

    @Override
    public String getPrenam() {
        return binding.signeInPrenom.getText().toString();
    }

    @Override
    public void setUser(UserView user) {
        binding.setUser(user);
    }

    @Override
    public Bitmap getImage() {
        return null;
    }
}
