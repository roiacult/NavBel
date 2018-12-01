package oxxy.kero.roiaculte.team7.khbich.model.repositories.remote.dataSources;

import android.content.ContentResolver;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.provider.MediaStore;
import android.util.Base64;
import android.util.Log;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.inject.Inject;

import cz.msebera.android.httpclient.Header;
import io.reactivex.Completable;
import io.reactivex.CompletableEmitter;
import io.reactivex.CompletableOnSubscribe;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.functions.Action;
import oxxy.kero.roiaculte.team7.khbich.Utils.KeyCrypting;
import oxxy.kero.roiaculte.team7.khbich.Utils.UserConverter;
import oxxy.kero.roiaculte.team7.khbich.model.models.Message;
import oxxy.kero.roiaculte.team7.khbich.model.models.User;
import oxxy.kero.roiaculte.team7.khbich.model.models.UserState;
import oxxy.kero.roiaculte.team7.khbich.model.repositories.remote.dao.RemoteDao;
import oxxy.kero.roiaculte.team7.khbich.model.repositories.remote.exeptions.UserNotRegistred;
import oxxy.kero.roiaculte.team7.khbich.ui.UserView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class Authentification {
    public static final String TAG = "errr";
    private RemoteDao dao ;
    Uri ImageUri ;
    Bitmap bitmap;
    RequestParams params = new RequestParams();
    String fileName ;
    private String encodedString;
    Context context;
    @Inject
    SharedPreferences preferences;

    @Inject
    public Authentification(Retrofit retrofit, Context context) {
        this.dao = retrofit.create(RemoteDao.class);
        this.context= context;
    }

    public Completable SignUpUser(final UserView user)  {
         final String Key  = KeyCrypting.CrypteIt();
        final User userz = UserConverter.fromViewToRemote(user);
         ImageUri = user.getPictureUri() ;
        Bitmap  b=null ;
        try {
            b = MediaStore.Images.Media.getBitmap(context.getContentResolver(),ImageUri);
        } catch (IOException e) {
            e.printStackTrace();
        }
        ContextWrapper wrapper = new ContextWrapper(context);
         File file = wrapper.getDir("Images", Context.MODE_PRIVATE);
        file = new File(file, user.getName()+".jpg");
        OutputStream stream = null ;
        try {
            stream = new FileOutputStream(file);
            b.compress(Bitmap.CompressFormat.JPEG, 100,stream );
            stream.flush();
            stream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
         Uri uri = Uri.parse(file.getAbsolutePath());
        SharedPreferences.Editor editor= preferences.edit();
        editor.putString("oxxy.kero.roiaculte.team7.khbich.USERPICTURE", uri.toString());
//        encodeImagetoString(Key); //todo image save user
         return Completable.create(new CompletableOnSubscribe() {
             @Override
             public void subscribe(final CompletableEmitter emitter) throws Exception {
                 userz.setPicture("http://192.168.43.68/project/index.php?op=img?skey=");
                 dao.saveUser(userz, Key).enqueue(new Callback<Message>() {
                     @Override
                     public void onResponse(Call<Message> call, Response<Message> response) {
                         Log.d(TAG, "onResponse:  entered onREsponse"+response.body());
                          if(!emitter.isDisposed()){
                              if(response.body().getResponse().equals("1")){
                                  emitter.onComplete();
                              }else {
                                  emitter.onError(new UserNotRegistred());
                              }
                          }
                     }
                     @Override
                     public void onFailure(Call<Message> call, Throwable t) {
                       if(!emitter.isDisposed()){
                           emitter.onError(t);
                           Log.d(TAG, "onFailure: "+t.getLocalizedMessage());
                       }
                     }
                 });
             }
         });
    }
    public Observable<UserState> CheckUser (final String email ){
        final String Key = KeyCrypting.CrypteIt();
        return Observable.create(new ObservableOnSubscribe<UserState>() {
            @Override
            public void subscribe(final ObservableEmitter<UserState> emitter) throws Exception {
                dao.checkUserJson(email, Key).enqueue(new Callback<Message>() {
                    @Override
                    public void onResponse(Call<Message> call, Response<Message> response) {
                        Log.d(TAG, "onResponse: " +response.body());
                        if(!emitter.isDisposed()){
                            emitter.onNext(UserConverter.fromInt(Integer.valueOf(response.body().getResponse())));
                        }
                    }
                    @Override
                    public void onFailure(Call<Message> call, Throwable t) {
                    if(!emitter.isDisposed()){
                         emitter.onError(t);
                    }
                    }
                });

            }
        });
    }


    public Observable<UserView> loginUser(final String mail , final String password) {
        final String Key = KeyCrypting.CrypteIt();
        return Observable.create(new ObservableOnSubscribe<UserView>() {
            @Override
            public void subscribe(final ObservableEmitter<UserView> emitter) throws Exception {
                dao.loginUser(mail, password, Key).enqueue(new Callback<User>() {
                    @Override
                    public void onResponse(Call<User> call, Response<User> response) {
                        if (!emitter.isDisposed()) {
                            Log.d(TAG, "onResponse: " + response.message());
                            Log.d(TAG, "onResponse: " + response.toString());
                            Log.d(TAG, "onResponse: "+response.body().getYear());
                            if (!emitter.isDisposed()) {
                                if (Integer.parseInt(response.body().getYear()) == -1) {
                                    Log.d(TAG, "onResponse: errroooorr");
                                    emitter.onNext(null);
                                    emitter.onComplete();
                                }else{
                                    emitter.onNext(UserConverter.toView(response.body()));
                                    emitter.onComplete();
                                }

                            }

                        }
                    }
                    @Override
                    public void onFailure(Call<User> call, Throwable t) {
                        emitter.onError(t);
                        Log.d(TAG, "onFailure: "+t.getLocalizedMessage());
                        Log.d(TAG, "onFailure: "+t.getMessage());
                        t.printStackTrace();
                    }
                });
            }
        });

    }

    public Completable updateUserData(final UserView userView){
        final String Key = KeyCrypting.CrypteIt();
        return Completable.create(new CompletableOnSubscribe() {
            @Override
            public void subscribe(final CompletableEmitter emitter) throws Exception {
               dao.updateUserData(UserConverter.fromViewToRemote(userView), Key).enqueue(new Callback<Message>() {
                   @Override
                   public void onResponse(Call<Message> call, Response<Message> response) {
                        if(!emitter.isDisposed()){
                            Log.d(TAG, "onResponse: "+response.toString());
                            Log.d(TAG, "onResponse: "+response.message());
                            if(response.body().getResponse().equals("1")){
                                emitter.onComplete();
                            }
                        }
                   }
                   @Override
                   public void onFailure(Call<Message> call, Throwable t) {
                       t.printStackTrace();
                       emitter.onError(t);
                   }
               });
            }
        });
    }

    public void encodeImagetoString(final String key) {
        String fileNameSegments[] = ImageUri.getPath().split("/");
        fileName = fileNameSegments[fileNameSegments.length - 1];
        // Put file name in Async Http Post Param which will used in Php web app
        params.put("filename", fileName);

        new AsyncTask<Void, Void, String>() {

            protected void onPreExecute() {

            };

            @Override
            protected String doInBackground(Void... params) {
//                BitmapFactory.Options options = null;
//                options = new BitmapFactory.Options();
                try {
                  bitmap=  MediaStore.Images.Media.getBitmap(context.getContentResolver(), ImageUri);
                } catch (IOException e) {
                    e.printStackTrace();
                }
//                options.inSampleSize = 3;
//                bitmap = BitmapFactory.decodeFile(imgPath,
//                        options);
                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                // Must compress the Image to reduce image size to make upload easy
                bitmap.compress(Bitmap.CompressFormat.PNG, 50, stream);
                byte[] byte_arr = stream.toByteArray();
                // Encode Image to String
                encodedString = Base64.encodeToString(byte_arr, 0);
                return "";
            }

            @Override
            protected void onPostExecute(String msg) {
                // Put converted Image string into Async Http Post param
                params.put("image", encodedString);
                // Trigger Image upload
                triggerImageUpload(key);
            }
        }.execute(null, null, null);
    }

    public void triggerImageUpload(String key) {
        makeHTTPCall(key);
    }

    public void makeHTTPCall(String key) {
//        prgDialog.setMessage("Invoking Php");
        AsyncHttpClient client = new AsyncHttpClient();
        // Don't forget to change the IP address to your LAN address. Port no as well.
        client.post("http://192.168.43.68/project/index.php?op=img?skey="+key,
                params, new AsyncHttpResponseHandler() {
                    // When the response returned by REST has Http
                    // response code '200'


                    // When the response returned by REST has Http
                    // response code other than '200' such as '404',
                    // '500' or '403' etc

                    @Override
                    public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                        Log.d(TAG, "onSuccess: "+"succes");
                    }

                    @Override
                    public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                        // When Http response code is '404'
                        if (statusCode == 404) {
                            Log.d(TAG, "onFailure: "+"Request ressource not found");

                        }
                        // When Http response code is '500'
                        else if (statusCode == 500) {
                            Log.d(TAG, "onFailure: "+"Something went wrong at server end");
//
                        }
                        // When Http response code other than 404, 500

                        else {
                            Log.d(TAG, "onFailure: "+"Error Occured n Most Common Error: n1. Device not connected to Internetn2. Web App is not deployed in App servern3. App server is not runningn HTTP Status code : "
                                    +statusCode);

                        }

                    }

                });
    }
}
