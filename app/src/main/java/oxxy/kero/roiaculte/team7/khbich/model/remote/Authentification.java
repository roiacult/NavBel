package oxxy.kero.roiaculte.team7.khbich.model.remote;

import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;

import io.reactivex.Completable;
import oxxy.kero.roiaculte.team7.khbich.MyApp;
import oxxy.kero.roiaculte.team7.khbich.Utils.KeyCrypting;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface Authentification {
    @POST("index.php?skey=8ef3dc4a3004f439efba52aecac7c710f18ad74a4c65d33f9b2711691c4571aa&op=signin")
    @FormUrlEncoded
    Call<String> saveUser(@Field("name") String name ,
                                 @Field("email") String email,
                                 @Field("password")String password,
                                 @Field("picture")String picture,
                                 @Field("date")String date,
                                 @Field("level")String level,
                                 @Field("year")String Year,
                                 @Field("point")String point,
                                 @Field("Qsolved")String solved
                           );
//      @SerializedName("name")
//    private String Name ;
//    @SerializedName("email")
//    private String email ;
//    @SerializedName("picture")
//    String picture ;
//    @SerializedName("picture")
//    private String password;
//    @SerializedName("date")
//    String date ;
////    private Date date  ;  we will handle it later
//    @SerializedName("year")
//    private String Year;
//    @SerializedName("point")
//    private int points ;
//    @SerializedName("Qsolved")
//    private String Qsolved ;
//    @SerializedName("level")
//    private int Level ;

}
