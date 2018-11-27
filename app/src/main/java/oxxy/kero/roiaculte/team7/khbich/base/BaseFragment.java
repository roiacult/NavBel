package oxxy.kero.roiaculte.team7.khbich.base;

import android.content.Context;

import androidx.fragment.app.Fragment;
import oxxy.kero.roiaculte.team7.khbich.dagger.HasComponent;
import oxxy.kero.roiaculte.team7.khbich.dagger.component.AppComponent;
import oxxy.kero.roiaculte.team7.khbich.dagger.component.DaggerUserComponent;
import oxxy.kero.roiaculte.team7.khbich.dagger.component.UserComponent;
import oxxy.kero.roiaculte.team7.khbich.dagger.module.ActivityModule;
import oxxy.kero.roiaculte.team7.khbich.dagger.module.UserModule;


public class BaseFragment extends Fragment implements MvpView, HasComponent<UserComponent>{

    protected BaseActivity mActivity;
    private UserComponent component;

    public void hideKeyboeard(){
        if(mActivity !=null){
            mActivity.hideKeyboard();
        }
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context  instanceof  BaseActivity){
            mActivity= (BaseActivity) context ;
            component = DaggerUserComponent.builder().appComponent(mActivity.getApplicationComponent())
                    .userModule(new UserModule(this)).build();
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mActivity = null ;
    }


    protected <C> C getComponent(Class<C> componentType) {
        return componentType.cast(((HasComponent<C>) getActivity()).getComponent());
    }

    @Override
    public UserComponent getComponent() {
        return component;
    }

    @Override
    public Context getContexte() {
        return mActivity.getContexte();
    }

    @Override
    public void showToast(String message) {
        mActivity.showToast(message);
    }

    @Override
    public void openActivityOnTokenExpire() {
        mActivity.openActivityOnTokenExpire();
    }

    @Override
    public void onError(int resId) {
        mActivity.onError(resId);
    }

    @Override
    public void onError(String message) {
        mActivity.onError(message);
    }

    @Override
    public void showMessage(String message) {
        mActivity.showMessage(message);
    }

    @Override
    public void showMessage(int resId) {
        mActivity.showMessage(resId);
    }

    @Override
    public boolean isNetworkConnected() {
        return mActivity.isNetworkConnected();
    }

    @Override
    public void hideKeyboard() {
        mActivity.hideKeyboard();
    }

    @Override
    public BaseActivity getBaseActivity() {
        return mActivity;
    }
}
