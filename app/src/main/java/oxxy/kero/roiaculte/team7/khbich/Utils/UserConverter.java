package oxxy.kero.roiaculte.team7.khbich.Utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import androidx.room.TypeConverter;
import oxxy.kero.roiaculte.team7.khbich.model.models.User;
import oxxy.kero.roiaculte.team7.khbich.model.models.UserState;
import oxxy.kero.roiaculte.team7.khbich.ui.UserView;

public class UserConverter {
    @TypeConverter
    public static UserState fromInt(int userState){
        switch (userState){
            case -1 : return UserState.USER_ALREADY_REGISTRED;
            case 0 :return UserState.USER_DONT_EXISTE;
            case 1 :return  UserState.Cpi1;
            case 2 :return UserState.Cpi2;
            case 3: return UserState.Cs1;
            case 4 : return UserState.Cs2;
            case  5 : return UserState.Cs3;
            default:return UserState.USER_DONT_EXISTE;
        }
    }
    @TypeConverter
    public static int froUserState (UserState state){
        switch (state){
            case USER_DONT_EXISTE: return 0;
            case USER_ALREADY_REGISTRED: return -1;
            case Cpi1: return  1 ;
            case Cpi2: return 2;
            case Cs1: return 3 ;
            case Cs2: return 4;
            case Cs3: return 5;
            default:return 0;
        }
    }
    public static String fromDate(Date date ){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH.mm.ss");
        return dateFormat.format(date);
    }
    public static Date fromString (String date){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH.mm.ss");
        Date dat=null ;
        try {
            dat= dateFormat.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return dat;
    }
    public static User fromViewToRemote(UserView userView) {
        return new User("\""+userView.getName()+(userView.getPrename()==null?"":" "+userView.getPrename())+"\"","\""+userView.getEmail()+"\""
        , "\""+userView.getPassword()+"\"", "\""+userView.getPicture()+"\"",
                "\""+fromDate(userView.getDate())+"\"", "\""+froUserState(userView.getYear())+"\"",
                "\""+String.valueOf(userView.getPoints())+"\"", "\""+userView.getQsolved()+"\"",
                "\""+String.valueOf(userView.getLevel())+"\"") ;
    }
    public static  UserView toView(User user){
        return new UserView(user.getName(),
                            user.getEmail(),
                          user.getPicture(),
                          user.getPassword(),
                         UserConverter.fromInt(Integer.parseInt(user.getYear()))
                                 , Integer.parseInt(user.getPoints()),
                Calendar.getInstance().getTime(),user.getQsolved(),
                Integer.parseInt(user.getLevel())
                );
    }
}
