package oxxy.kero.roiaculte.team7.khbich.model.repositories.remote.dao;

import org.json.JSONObject;

import oxxy.kero.roiaculte.team7.khbich.model.models.User;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RemoteDao {
    @POST("index.php?op=signin")
    Call<String> saveUser(@Body User user, @Query("skey") String Skey ) ;

    @GET("index.php?p=check&")
    Call<String>  checkUser(@Query("email") String email , @Query("skey") String Skey);



}
