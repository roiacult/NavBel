package oxxy.kero.roiaculte.team7.khbich.Utils;

import oxxy.kero.roiaculte.team7.khbich.model.models.UserState;

public class YearConverter {

    public static String from(UserState state){
        String year;
        switch (state){
            case Cs1:year = "1CS";
            break;
            case Cs2:year = "2CS";
            break;
            case Cs3:year = "3CS";
            break;
            case Cpi1:year = "1CPi";
            break;
            case Cpi2: year = "2CPi";
            break;
            default:year = "Don't exist";
        }

        return year;
    }

    public static UserState to(String year){
        UserState state ;

        switch (year){
            case "1CS":  state = UserState.Cs1;
            break;
            case "2CS": state = UserState.Cs2;
            break;
            case  "3CS" :state = UserState.Cs3;
            break;
            case "1CPi" :state = UserState.Cpi1;
            break;
            case  "2CPi" : state =UserState.Cpi2;
            break;
            default: state = UserState.USER_DONT_EXISTE;
        }
        return state;
    }
}
