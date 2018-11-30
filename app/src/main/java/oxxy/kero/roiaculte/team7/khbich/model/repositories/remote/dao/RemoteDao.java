package oxxy.kero.roiaculte.team7.khbich.model.repositories.remote.dao;

import oxxy.kero.roiaculte.team7.khbich.model.models.Message;
import oxxy.kero.roiaculte.team7.khbich.model.models.User;
import oxxy.kero.roiaculte.team7.khbich.model.repositories.remote.QuestionRemote;
import oxxy.kero.roiaculte.team7.khbich.model.repositories.remote.TestsRemote;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface RemoteDao {
    @POST("index.php?op=signin")
    Call<Message> saveUser(@Body User user, @Query("skey") String Skey ) ;

    @GET("index.php?op=check")
    Call<Message> checkUserJson(@Query("email") String email , @Query("skey") String Skey);

    @GET("index.php?op=login")
    Call<User> loginUser(@Query("email") String mail , @Query("password") String password, @Query("skey")String Skey);
    @POST("index.php?op=update")
    Call<Message> updateUserData(@Body User user , @Query("skey") String Skey);



     @GET("index.php?op=qst")
     Call<QuestionRemote> getQuestions(@Query("year") String year, @Query("skey") String Skey);

    @GET("index.php?op=tests")
    Call<TestsRemote> getTests(@Query("year") String year , @Query("skey") String Key);
}
