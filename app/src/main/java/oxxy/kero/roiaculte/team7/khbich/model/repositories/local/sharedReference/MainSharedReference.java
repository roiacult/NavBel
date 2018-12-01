package oxxy.kero.roiaculte.team7.khbich.model.repositories.local.sharedReference;

import android.content.SharedPreferences;

import java.util.Calendar;
import java.util.Date;

import javax.inject.Inject;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import oxxy.kero.roiaculte.team7.khbich.Utils.UserConverter;
import oxxy.kero.roiaculte.team7.khbich.model.models.User;
import oxxy.kero.roiaculte.team7.khbich.ui.UserView;

public class MainSharedReference {
    private static final String IS_USER_LOGGED="oxxy.kero.roiaculte.team7.khbich.IS_USER_LOGGED";
    private static  final String USER_NAME ="oxxy.kero.roiaculte.team7.khbich.USERNAME";
    private static final String USER_PASSWORD= "oxxy.kero.roiaculte.team7.khbich.PASSWORD";
    private static final String USER_MAIL = "oxxy.kero.roiaculte.team7.khbich.USERMAIL";
    private static final String USER_PICTURE = "oxxy.kero.roiaculte.team7.khbich.USERPICTURE";
    private static final String USER_YEAR = "oxxy.kero.roiaculte.team7.khbich.USER_YEAR";
    private static final String USER_POINT = "oxxy.kero.roiaculte.team7.khbich.USE_POINTS";
    private static final String QSOLVED = "oxxy.kero.roiaculte.team7.khbich.QSOLVED";
    private static final String LEVEL = "oxxy.kero.roiaculte.team7.khbich.LEVEL";
    private static final String Date= "oxxy.kero.roiaculte.team7.khbich.DATE";
    private SharedPreferences preferences ;
    @Inject
    public MainSharedReference(SharedPreferences preferences) {
        this.preferences = preferences;
    }

    public void LogUserIn(UserView userView){
         SaveUser();
         SharedPreferences.Editor editor = preferences.edit();
         ///WE DONT NEED TO SAVE  THE PASSWORD
         editor.putBoolean(IS_USER_LOGGED, true);
         editor.putString(USER_PASSWORD, userView.getPassword());
         editor.putString(USER_NAME , userView.getName());
         editor.putString(USER_MAIL, userView.getEmail());
         editor.putString(USER_PICTURE, userView.getPicture());
         editor.putInt(USER_YEAR, UserConverter.froUserState(userView.getYear()));
         editor.putInt(USER_POINT, userView.getPoints());
         editor.putString(QSOLVED, userView.getQsolved());
         editor.putInt(LEVEL, userView.getLevel());
         editor.putString(Date, UserConverter.fromDate(userView.getDate()));
         editor.commit();
    }
    public void SaveUser(){
        SharedPreferences.Editor  editor = preferences.edit();
        editor.putBoolean(IS_USER_LOGGED, true).commit();
    }
    public Boolean IsUserLOgged(){
      return   preferences.getBoolean(IS_USER_LOGGED, false);
    }

   public LiveData<UserView> getUserViewLocal(){
       MutableLiveData<UserView> liveData= new MutableLiveData<>();
       liveData.setValue( new UserView(preferences.getString(USER_NAME, ""),
               preferences.getString("USER_MAIL", ""), preferences.getString(USER_PICTURE, ""),
               preferences.getString(USER_PASSWORD, "password")
               , UserConverter.fromInt(preferences.getInt(USER_YEAR, 0)),
               preferences.getInt(USER_POINT, 0),UserConverter.fromString( preferences.getString(Date, UserConverter
               .fromDate(Calendar.getInstance().getTime())))
               ,preferences.getString(QSOLVED, "qsolved")
               , preferences.getInt(LEVEL, 0)));
        return liveData;
   }
   public void signUserOut(){
        SharedPreferences.Editor editor= preferences.edit();
        editor.remove(IS_USER_LOGGED);
       editor.remove(USER_PASSWORD);
       editor.remove(USER_NAME);
       editor.remove(USER_MAIL);
       editor.remove(USER_PICTURE);
       editor.remove(USER_YEAR);
       editor.remove(USER_POINT);
       editor.remove(QSOLVED);
       editor.remove(LEVEL);
       editor.remove(Date);
       editor.commit();
   }
        }
