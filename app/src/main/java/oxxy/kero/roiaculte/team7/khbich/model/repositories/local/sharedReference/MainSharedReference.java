package oxxy.kero.roiaculte.team7.khbich.model.repositories.local.sharedReference;

import android.content.SharedPreferences;

import javax.inject.Inject;

public class MainSharedReference {
    private static final String IS_USER_LOGGED="oxxy.kero.roiaculte.team7.khbich.IS_USER_LOGGED";
    private SharedPreferences preferences ;
    @Inject
    public MainSharedReference(SharedPreferences preferences) {
        this.preferences = preferences;
    }
    public void SaveUser(){
        SharedPreferences.Editor  editor = preferences.edit();
        editor.putBoolean(IS_USER_LOGGED, true).commit();
    }
    public Boolean IsUserLOgged(){
      return   preferences.getBoolean(IS_USER_LOGGED, false);
    }


}
