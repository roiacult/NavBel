package oxxy.kero.roiaculte.team7.khbich.ui.splash;

import android.content.SharedPreferences;
import android.os.Bundle;

import javax.inject.Inject;

import androidx.annotation.Nullable;
import oxxy.kero.roiaculte.team7.khbich.R;
import oxxy.kero.roiaculte.team7.khbich.base.BaseActivity;

public class SplashScren extends BaseActivity implements SplashCotract.VIEW{

    @Inject SplashCotract.PRESENTER presenter;
SharedPreferences preferences;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);
        getComponent().inject(this);
               preferences = getSharedPreferences("SHARED_PREFERENCE_NAME", MODE_PRIVATE);
        presenter.onAttach(this);
//         preferences.edit()
//                .putBoolean("oxxy.kero.roiaculte.team7.khbich.IS_USER_LOGGED", false).commit();
    }
}
