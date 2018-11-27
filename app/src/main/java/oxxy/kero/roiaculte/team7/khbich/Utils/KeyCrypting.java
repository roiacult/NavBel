package oxxy.kero.roiaculte.team7.khbich.Utils;

import org.apache.commons.codec.binary.Hex;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Calendar;

public class KeyCrypting {
    public static String CrypteIt(){
        final String Pwd = "team7";
        try {
            MessageDigest digest = MessageDigest.getInstance("MD5");
            char[] carac = Hex.encodeHex(digest.digest(Pwd.getBytes()));
            String Md5Pasword = "";
            for (char c :
                    carac) {
                Md5Pasword = String.valueOf(c)+Md5Pasword;
            }
            digest.reset();
            Calendar calendar = Calendar.getInstance();
            String Time = String.valueOf(calendar.getTime().getMinutes()) + String.valueOf(calendar.getTime().getSeconds());
            carac = Hex.encodeHex(digest.digest(Time.getBytes()));
            String MD5tIME = "";
            for (char c :
                    carac) {
                MD5tIME = MD5tIME + String.valueOf(c);
            }
            String FinalToken = "";
            for (int i = 0; i < Md5Pasword.length(); i++) {
                FinalToken = FinalToken + String.valueOf(Md5Pasword.charAt(i)) + String.valueOf(MD5tIME.charAt(i));
            }

            return FinalToken;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }
}
