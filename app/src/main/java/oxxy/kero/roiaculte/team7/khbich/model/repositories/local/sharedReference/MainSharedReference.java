package oxxy.kero.roiaculte.team7.khbich.model.repositories.local.sharedReference;

import android.content.SharedPreferences;

import java.util.Calendar;
import java.util.Date;

import javax.inject.Inject;

import oxxy.kero.roiaculte.team7.khbich.Utils.UserConverter;
import oxxy.kero.roiaculte.team7.khbich.ui.UserView;

public class MainSharedReference {
    private static final String IS_USER_LOGGED="oxxy.kero.roiaculte.team7.khbich.IS_USER_LOGGED";
    private static  final String USER_NAME ="oxxy.kero.roiaculte.team7.khbich.USERNAME";
    private static final String USER_MAIL = "oxxy.kero.roiaculte.team7.khbich.USERMAIL";
    private static final String USER_PICTURE = "oxxy.kero.roiaculte.team7.khbich.USERPICTURE";
    private static final String USER_YEAR = "oxxy.kero.roiaculte.team7.khbich.USER_YEAR";
    private static final String USER_POINT = "oxxy.kero.roiaculte.team7.khbich.USE_POINTS";
    private static final String QSOLVED = "oxxy.kero.roiaculte.team7.khbich.QSOLVED";
    private static final String LEVEL = "oxxy.kero.roiaculte.team7.khbich.LEVEL";
    private static final String Date= "oxxy.kero.roiaculte.team7.khbich.DATE";

//      private String name ;
//    private String email ;
//    private String picture ;
//    private String password;
//    private UserState year;
//    private int points ;
//    //todo configure this to a liste of questions
//    private String qsolved;
//    private int level ;
    private SharedPreferences preferences ;
    @Inject
    public MainSharedReference(SharedPreferences preferences) {
        this.preferences = preferences;
    }
    public void LogUserIn(UserView userView){
         SaveUser();
         SharedPreferences.Editor editor = preferences.edit();
         editor.putString(USER_NAME , userView.getName());
         editor.putString(USER_MAIL, userView.getEmail());
         editor.putString(USER_PICTURE, userView.getPassword());
         editor.putInt(USER_YEAR, UserConverter.froUserState(userView.getYear()));
         editor.putInt(USER_POINT, userView.getPoints());
         editor.putString(QSOLVED, userView.getQsolved());
         editor.putInt(LEVEL, userView.getLevel());
         java.util.Date date  = Calendar.getInstance().getTime();
         editor.putString(Date, UserConverter.fromDate(date));
         editor.commit();
    }
    public void SaveUser(){
        SharedPreferences.Editor  editor = preferences.edit();
        editor.putBoolean(IS_USER_LOGGED, true).commit();
    }
    public Boolean IsUserLOgged(){
      return   preferences.getBoolean(IS_USER_LOGGED, false);
    }


}
