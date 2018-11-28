package oxxy.kero.roiaculte.team7.khbich.Utils;

import java.util.Calendar;
import java.util.Date;

import oxxy.kero.roiaculte.team7.khbich.model.models.User;
import oxxy.kero.roiaculte.team7.khbich.model.models.UserState;
import oxxy.kero.roiaculte.team7.khbich.ui.UserView;

public class UserConverter {
    public static UserState fromInt(int userState){
        switch (userState){
            case -1 : return UserState.USER_ALREADY_REGISTRED;
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
            case USER_ALREADY_REGISTRED: return -1;
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
        return new User("\""+userView.getName()+" "+userView.getPrename()+"\"","\""+userView.getEmail()+"\""
        , "\""+userView.getPassword()+"\"", "\""+userView.getPicture()+"\"",
                "\""+fromDate(userView.getDate())+"\"", "\""+froUserState(userView.getYear())+"\"",
                "\""+String.valueOf(userView.getPoints())+"\"", "\""+userView.getQsolved()+"\"",
                "\""+String.valueOf(userView.getLevel())+"\"") ;
    }
    public static  UserView toView(User user){
        int nameLength= user.getName().length();
        return new UserView(user.getName().substring(1 , user.getName().length()-1),
                            user.getEmail().substring(1, user.getName().length()-1),
                          user.getPicture().substring(1, user.getPicture().length()-1),
                          user.getPassword().substring(1, user.getPassword().length()-1),
                         UserConverter.fromInt(Integer.parseInt(user.getYear().substring(1, user.getYear().length()-1)))
                                 , Integer.parseInt(user.getPoints().substring(1, user.getPoints().length()-1)),
                Calendar.getInstance().getTime(),user.getQsolved().substring(1, user.getQsolved().length()-1),
                Integer.parseInt(user.getLevel().substring(1, user.getLevel().length()-1))
                );
    }
}
