package oxxy.kero.roiaculte.team7.khbich.Registration.signIn;

import android.text.TextUtils;

import oxxy.kero.roiaculte.team7.khbich.base.BasePresenter;

public class SigneInPresenter extends BasePresenter<ContractSignIn.VIEW> implements ContractSignIn.PRESENTER {

    private ContractSignIn.VIEW view;

    @Override
    public void onCreatAcountclicked() {
        if (getView()!= null){

            if(TextUtils.isEmpty(getView().getEmail()) ){
                getView().showToast("Email should not be emty");
                return;
            }
            if (TextUtils.isEmpty(getView().getPasssword()) || getView().getPasssword().length()<8 ){
                getView().showToast("Passsword is invalid ");
                return;
            }

            if(!getView().getPasssword().equals(getView().getRepeatPassword())){
                getView().showToast("password are not the same");
                return;
            }





        }
    }

    @Override
    public void onSubmitCliked() {

    }
}
