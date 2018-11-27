package oxxy.kero.roiaculte.team7.khbich.base;

import android.content.Context;

import androidx.annotation.StringRes;


public interface MvpView {

    Context getContexte();

    void showToast(String message);

    void openActivityOnTokenExpire();

    void onError(@StringRes int resId);

    void onError(String message);

    void showMessage(String message);

    void showMessage(@StringRes int resId);

    boolean isNetworkConnected();

    void hideKeyboard();

    BaseActivity getBaseActivity();
}
