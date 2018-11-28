package oxxy.kero.roiaculte.team7.khbich.ui.splash;

import android.os.Bundle;

import javax.inject.Inject;

import androidx.annotation.Nullable;
import oxxy.kero.roiaculte.team7.khbich.R;
import oxxy.kero.roiaculte.team7.khbich.base.BaseActivity;

public class SplashScren extends BaseActivity implements SplashCotract.VIEW{

    @Inject SplashCotract.PRESENTER presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);
        getComponent().inject(this);

        presenter.onAttach(this);
    }
}
