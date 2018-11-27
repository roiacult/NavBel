package oxxy.kero.roiaculte.team7.khbich.base;


import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import oxxy.kero.roiaculte.team7.khbich.MyApp;
import oxxy.kero.roiaculte.team7.khbich.R;
import oxxy.kero.roiaculte.team7.khbich.dagger.HasComponent;
import oxxy.kero.roiaculte.team7.khbich.dagger.component.ActivityComponent;
import oxxy.kero.roiaculte.team7.khbich.dagger.component.AppComponent;
import oxxy.kero.roiaculte.team7.khbich.dagger.component.DaggerActivityComponent;
import oxxy.kero.roiaculte.team7.khbich.dagger.module.ActivityModule;


public abstract class BaseActivity extends AppCompatActivity implements MvpView , HasComponent<ActivityComponent> {

    public ActionBarDrawerToggle toggle;
    public ActivityComponent component;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        component = DaggerActivityComponent.builder().activityModule(getActivityModule())
                    .appComponent(getApplicationComponent())
                    .build();

    }

//    public void showSnackBar(String message) {
//        Snackbar snackbar = Snackbar.make(findViewById(android.R.id.content),
//                message, Snackbar.LENGTH_SHORT);
//        View sbView = snackbar.getView();
//        TextView textView = (TextView) sbView
//                .findViewById(R.id.);
//        textView.setTextColor(ContextCompat.getColor(this, R.color.white));
//        snackbar.show();
//    }

    public void  setToolbar(Toolbar toolbar){
        setSupportActionBar(toolbar);
    }

    public void setDrawer(DrawerLayout drawer , Toolbar toolbar){
         toggle= new ActionBarDrawerToggle(this, drawer, toolbar, R.string.open_drawer, R.string.close_drawer ){
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                hideKeyboard() ;
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }
        };
         toggle.syncState();


    }

    protected void addFragment(int containerViewId, Fragment fragment) {
        final FragmentTransaction fragmentTransaction = this.getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(containerViewId, fragment);
        fragmentTransaction.commit();
    }

    public AppComponent getApplicationComponent() {
        return ((MyApp) getApplication()).getComponent();
    }

    protected  void startActivityIntent(Class<BaseActivity> baseActivityClass  ){
        Intent intent = new Intent(this, baseActivityClass);
        startActivity(intent);
    }

    public ActivityModule getActivityModule() {
        return new ActivityModule(this);
    }

    @Override
    public void hideKeyboard() {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager)
                    getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    @Override
    public Context getContexte() {
        return getApplicationComponent().context();
    }

    @Override
    public void showToast(String message) {
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void openActivityOnTokenExpire() {
        //TODO open signIn Activity

        //todo  i dont thik its a good idea to allow each activity to signout just let onee activity to sign out
        // this method will be caled when ever the user is loged out
        //or his auhentification expired (dok rigalha manba3d )
    }


    @Override
    public void onError(String message) {
//        if (message != null) {
//            showSnackBar(message);
//        } else {
//            showSnackBar(getString(R.string.some_error));
//        }
    }

    @Override
    public void onError(@StringRes int resId) {
        onError(getString(resId));
    }

    @Override
    public void showMessage(String message) {
        if (message != null) {
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, getString(R.string.some_error), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void showMessage(@StringRes int resId) {
        showMessage(getString(resId));
    }

    @Override
    public boolean isNetworkConnected() {
            ConnectivityManager cm = (ConnectivityManager) getContexte().getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
            return activeNetwork != null && activeNetwork.isConnectedOrConnecting();
        }

    @Override
    public ActivityComponent getComponent() {
        return component;
    }

    @Override
    public BaseActivity getBaseActivity() {
        return this;
    }
}
