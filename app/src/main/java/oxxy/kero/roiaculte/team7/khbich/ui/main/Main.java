package oxxy.kero.roiaculte.team7.khbich.ui.main;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import oxxy.kero.roiaculte.team7.khbich.R;
import oxxy.kero.roiaculte.team7.khbich.base.BaseActivity;
import oxxy.kero.roiaculte.team7.khbich.databinding.MainBinding;
import oxxy.kero.roiaculte.team7.khbich.model.repositoriesInterfaces.AuthentificationRepository;
import oxxy.kero.roiaculte.team7.khbich.model.repositoriesInterfaces.DataFlowRepository;
import oxxy.kero.roiaculte.team7.khbich.ui.main.Profile.Profile;
import oxxy.kero.roiaculte.team7.khbich.ui.registration.Registration;

public class Main extends BaseActivity {

    private MainBinding binding;
    @Inject AuthentificationRepository repo;
    @Inject DataFlowRepository flowRepository;

    private Profile profile;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this,R.layout.main);
        getComponent().inject(this);
binding.navigatione.addItem(new AHBottomNavigationItem(R.string.main, R.drawable.nav_botom_main, R.color.colorPrimary));
        binding.navigatione.addItem(new AHBottomNavigationItem(R.string.Forume, R.drawable.nav_botom_forum, R.color.colorPrimary));
        binding.navigatione.addItem(new AHBottomNavigationItem(R.string.rewards, R.drawable.nav_botom_rewards, R.color.colorPrimary));
        binding.navigatione.addItem(new AHBottomNavigationItem(R.string.moyene, R.drawable.nav_botom_profile, R.color.colorPrimary));
         binding.navigatione.setDefaultBackgroundColor(Color.parseColor("#ffffff"));
         binding.navigatione.setForceTint(true);
      binding.navigatione.setTitleState(AHBottomNavigation.TitleState.SHOW_WHEN_ACTIVE);
binding.navigatione.setOnTabSelectedListener(new AHBottomNavigation.OnTabSelectedListener() {
    @Override
    public boolean onTabSelected(int position, boolean wasSelected) {
        switch (position){
            case 3:
                if (profile == null) profile = new Profile();
                        getSupportFragmentManager().beginTransaction()
                                .addToBackStack("profile")
                                .replace(R.id.main_container,profile)
                                .commit();
        }
        return true;
    }
});

//  todo ida ma3jbatkch hadi ta9der t3wed treje3 l 9dima 3dk bedel l id ta3ha f xml l navigation

//                binding.navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
//
//                switch (menuItem.getItemId()){
//                    case R.id.navigation_home:
//                        break;
//                    case R.id.navigation_Forum:
//
//                        break;
//                    case R.id.navigation_rewards:
//                        break;
//                    case R.id.navigation_profile:
//                          menuItem.setEnabled(true);
//                        if (profile == null) profile = new Profile();
//                        getSupportFragmentManager().beginTransaction()
//                                .addToBackStack("profile")
//                                .replace(R.id.main_container,profile)
//                                .commit();
//                        break;
//
//                }
//
//
//                return false;
//            }
//        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_options,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.signout :
                repo.signOutUser();
                flowRepository.dropTable();
                startActivity(new Intent(this,Registration.class));
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
