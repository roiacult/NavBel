package oxxy.kero.roiaculte.team7.khbich.ui.main;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import oxxy.kero.roiaculte.team7.khbich.R;
import oxxy.kero.roiaculte.team7.khbich.base.BaseActivity;
import oxxy.kero.roiaculte.team7.khbich.databinding.MainBinding;
import oxxy.kero.roiaculte.team7.khbich.ui.main.Profile.Profile;

public class Main extends BaseActivity {

    private MainBinding binding;

    private Profile profile;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this,R.layout.main);

        binding.navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId()){
                    case R.id.navigation_home:
                        break;
                    case R.id.navigation_Forum:
                        break;
                    case R.id.navigation_rewards:
                        break;
                    case R.id.navigation_profile:

                        if (profile == null) profile = new Profile();
                        getSupportFragmentManager().beginTransaction()
                                .addToBackStack("profile")
                                .add(R.id.main_container,profile);


                        break;

                }


                return false;
            }
        });

    }
}
