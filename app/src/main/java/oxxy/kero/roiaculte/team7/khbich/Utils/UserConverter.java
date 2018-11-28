package oxxy.kero.roiaculte.team7.khbich.Utils;

import java.util.Date;

import oxxy.kero.roiaculte.team7.khbich.model.models.User;
import oxxy.kero.roiaculte.team7.khbich.model.models.UserState;
import oxxy.kero.roiaculte.team7.khbich.ui.UserView;

public class UserConverter {
    public static UserState fromInt(int userState){
        switch (userState){
            case 0 :return UserState.USER_DONT_EXISTE;
            case 1 :return  UserState.USER_1CPI ;
            case 2 :return UserState.USER_2CPI;
            case 3: return UserState.USER_1CS ;
            case 4 : return UserState.USER_2CS;
            case  5 : return UserState.USER_3CS ;
            default:return UserState.USER_DONT_EXISTE;
        }
    }
    public static int froUserState (UserState state){
        switch (state){
            case USER_DONT_EXISTE: return 0;
            case USER_1CPI: return  1 ;
            case USER_2CPI: return 2;
            case USER_1CS: return 3 ;
            case USER_2CS: return 4;
            case  USER_3CS: return 5;
            default:return 0;
        }
    }
    public static String fromDate(Date date ){
        return String.valueOf(date.getYear()+1900)+"-"+String.valueOf(date.getMonth()+1)+"-"+
                String.valueOf(date.getDay())+" "+String.valueOf(date.getHours())+":"
                +String.valueOf(date.getMinutes())+":"+String.valueOf(date.getSeconds());
    }
    public static User fromViewToRemote(UserView userView) {
        return new User("\""+userView.getName()+"\"","\""+userView.getEmail()+"\""
        , "\""+userView.getPassword()+"\"", "\""+userView.getPassword()+"\"",
                "\""+fromDate(userView.getDate())+"\"", "'"+froUserState(userView.getYear())+"\"",
                "\""+String.valueOf(userView.getPoints())+"\"", "\""+userView.getQsolved()+"\"",
                "\""+String.valueOf(userView.getLevel())+"\"") ;
    }
}
