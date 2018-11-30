package oxxy.kero.roiaculte.team7.khbich.ui.saveinfo;

import android.Manifest;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.nfc.Tag;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;
import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;

import javax.inject.Inject;

import androidx.annotation.NonNull;
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

import static oxxy.kero.roiaculte.team7.khbich.ui.saveinfo.SaveInfoPresenter.REQUEST_PERMITION;

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
                presenter.startPickingImage();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        presenter.onActivityResult(requestCode,resultCode,data);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        presenter.onRequestPermissionsResult(requestCode,permissions,grantResults);
    }

    @Override
    public void requestStoragePermition() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE},REQUEST_PERMITION);
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

    @Override
    public void setImage(String img) {

        showMessage("setting image");
        Uri uri=Uri.parse(img);
        viewModel.getUserView().setPictureUri(uri);
        binding.signeInImage.setImageURI(uri);
        Picasso.get().load(Uri.parse(img)).into(new Target() {
            @Override
            public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
                binding.signeInImage.setImageBitmap(bitmap);
                showMessage("image set");
            }

            @Override
            public void onBitmapFailed(Exception e, Drawable errorDrawable) {
                showMessage("error in loading image");
            }

            @Override
            public void onPrepareLoad(Drawable placeHolderDrawable) {

            }
        });
    }
}
