package oxxy.kero.roiaculte.team7.khbich;

import androidx.appcompat.app.AppCompatActivity;
import io.reactivex.CompletableObserver;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import oxxy.kero.roiaculte.team7.khbich.Utils.KeyCrypting;
import oxxy.kero.roiaculte.team7.khbich.base.BaseActivity;
import oxxy.kero.roiaculte.team7.khbich.model.remote.Authentification;
import oxxy.kero.roiaculte.team7.khbich.model.remote.JobExecutor;
import oxxy.kero.roiaculte.team7.khbich.model.remote.User;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;


import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

public class MainActivity extends BaseActivity {
    @Inject Retrofit retrofit ;
    private String BASE_URL = "http://192.168.43.68/project/";
//    index.php?skey="+KeyCrypting.CrypteIt()
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Gson gson = new GsonBuilder().create();//setLenient().
//     if(retrofit==null){
//         OkHttpClient.Builder clientBuilder = new OkHttpClient.Builder();
//         HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
//         loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.HEADERS);
//         clientBuilder.addInterceptor(loggingInterceptor);
//          retrofit =new retrofit2.Retrofit.Builder()
//                  .baseUrl(BASE_URL)
//                   .client(clientBuilder.build())
//                  .addConverterFactory(GsonConverterFactory.create(gson))
//                  .build();
//     }
        User user = new User("akram", "a.boutouchent@esi-sba.dz", "zebi", "hellooow"
                , "2cpi", "150", "sdfghj", "12");
        JSONObject object = new JSONObject();
        try {
            object.put("name", user.getName());
            object.put("email", user.getEmail());
            object.put("password", user.getPassword());
            object.put("picture", user.getPicture());
            object.put("date", user.getDate());
            object.put("level", user.getLevel());
            object.put("year", user.getYear());
            object.put("point", user.getPoints());
            object.put("Qsolved", user.getQsolved());
        } catch (JSONException e) {
            e.printStackTrace();
        }

        JsonParser parser = new JsonParser();
        JsonObjectRequest objectRequest = new JsonObjectRequest(JsonObjectRequest.Method.POST, "http://192.168.43.68/project/index.php?skey=8ef3dc4a3004f439efba52aecac7c710f18ad74a4c65d33f9b2711691c4571aa&op=signin",
               object, new com.android.volley.Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.d("errr", "onResponse: ");
            }
        }, new com.android.volley.Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
                Log.d("errr", "onErrorResponse: "+error.getMessage());
            }
        }){
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("Content-Type", "application/json");
                return params;
            }

            @Override
            public String getBodyContentType() {
                return "application/json";
            }
        };
        Volley.newRequestQueue(getApplicationContext()).add(objectRequest);

//        User user = new User("akram", "a.boutouchent@esi-sba.dz", "zebi", "2018-06-01 07:07:45"
//                , "2cpi", 150, "sdfghj", 12);

//              /*Create handle for the RetrofitInstance interface*/
//        Authentification authentification = retrofit.create(Authentification.class) ;
//     Call<String> calls = authentification.saveUser(user.getName(),
//             user.getEmail(), user.getPassword(),user.getPicture() ,user.getDate(), user.getLevel() ,user.getYear()
//             , user.getPoints() , user.getQsolved() );
//
//       calls.enqueue(new Callback<String>() {
//            @Override
//            public void onResponse(Call<String> call, Response<String> response) {
//                Log.d("errr", "onResponse: "+response.toString());
//            }
//
//            @Override
//            public void onFailure(Call<String> call, Throwable t) {
//                Log.d("errr", "onFailure: "+t.getLocalizedMessage());
//            }
//        });
    }

}