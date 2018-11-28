package oxxy.kero.roiaculte.team7.khbich.model.repositories.remote.dao;

import org.json.JSONObject;

import oxxy.kero.roiaculte.team7.khbich.model.models.User;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface RemoteDao {
    @POST("index.php?skey={skey}&op=signin")
    Call<JSONObject> saveUser(@Body User user, @Path("skey") String Skey ) ;

    @GET("index.php?skey={skey}&op=check&email={mail}")
    Call<String>  checkUser(@Path("mail") String email , @Path("skey") String Skey);



}
