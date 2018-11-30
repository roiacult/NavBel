package oxxy.kero.roiaculte.team7.khbich.Utils;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import static oxxy.kero.roiaculte.team7.khbich.MainActivity.TAG;

public class TextUtils {
    public static List<Long> getLOng(String qsolved){
        String s ="";
        List<Long> longs = new ArrayList<>();
        int i=0 ;
        for (char c:
             qsolved.toCharArray()) {
            i++;
            if(c=='@'){
                longs.add(Long.parseLong(s));
                s="";
            }else if (c==':'){
                s="";
            }else {
                s=s+c;
            }
            Log.d(TAG, "getLOng: "+s);
        }
        return longs;
    }

}
