package oxxy.kero.roiaculte.team7.khbich.Utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Base64;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;

public class ImageUtil {

    public static Bitmap convert(String base64Str) throws IllegalArgumentException {

        byte[] decodedBytes = Base64.decode(
                base64Str.substring(base64Str.indexOf(",")  + 1),
                Base64.DEFAULT
        );

        return BitmapFactory.decodeByteArray(decodedBytes, 0, decodedBytes.length);
    }

    public static String convert(Bitmap bitmap) {



        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, outputStream);

        return Base64.encodeToString(outputStream.toByteArray(), Base64.DEFAULT);
    }

    public static Uri getImage(Context context,String uri,String name) {
        String path = null;
        try {
             path= MediaStore.Images.Media.insertImage(context.getContentResolver(),uri,name,null);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return Uri.parse(path);
    }

}
