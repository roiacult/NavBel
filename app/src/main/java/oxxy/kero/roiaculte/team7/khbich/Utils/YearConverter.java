package oxxy.kero.roiaculte.team7.khbich.Utils;

import oxxy.kero.roiaculte.team7.khbich.model.models.UserState;

public class YearConverter {

    public static String from(UserState state){
        String year;
        switch (state){
            case USER_1CS:year = "1CS";
            break;
            case USER_2CS:year = "2CS";
            break;
            case USER_3CS:year = "3CS";
            break;
            case  USER_1CPI:year = "1CPi";
            break;
            case USER_2CPI: year = "2CPi";
            break;
            default:year = "Don't exist";
        }

        return year;
    }

    public static UserState to(String year){
        UserState state ;

        switch (year){
            case "1CS":  state = UserState.USER_1CS;
            break;
            case "2CS": state = UserState.USER_2CS;
            break;
            case  "3CS" :state = UserState.USER_3CS;
            break;
            case "1CPi" :state = UserState.USER_1CPI;
            break;
            case  "2CPi" : state =UserState.USER_2CPI;
            break;
            default: state = UserState.USER_DONT_EXISTE;
        }
        return state;
    }
}
