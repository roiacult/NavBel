package oxxy.kero.roiaculte.team7.khbich.Utils;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import oxxy.kero.roiaculte.team7.khbich.model.models.Test;

import static oxxy.kero.roiaculte.team7.khbich.MainActivity.TAG;

public class TextUtils {
    public static List<Long> getLOng(String qsolved){
        String s ="";
        List<Long> longs = new ArrayList<>();
        for (char c:
             qsolved.toCharArray()) {
            if(c=='@'){
                longs.add(Long.parseLong(s));

                s="";
            }else if (c==':'){
                s="";
            }else {
                s=s+c;
            }
        }
        return longs;
    }

    public static  int getQuestionById(String qsolved , long id ){
//        String s= "";
//        long bla  ;
//        int i =0 ;
//              for (char c : Qsolve.toCharArray()){
//                 if(c==':'){
//                    bla = Long.parseLong(s);
//                    if (bla ==id){
//                        return Integer.parseInt(Qsolve.substring(i+1, i+3));
//                    }else {
//                        s="";
//                    }
//                 }else if(c=='@'){
//                     s="";
//                 }else{
//                     s=s+c;
//                 }
//                  i++ ;
//              }
//              return 0;
        String [] s=qsolved.split(":");
        for (String t : s){
            String [] s2 = t.split("@");
            if (Long.valueOf(s2[0])==id){
                return Integer.valueOf(s2[1]);
            }
        }

        return 0;
    }
    public static  boolean IsSolved(long lon, List<Long> longs){
        for (Long l: longs
             ) {
            if(l==lon){
                return true ;
            }
        }
        return false ;
    }

}
