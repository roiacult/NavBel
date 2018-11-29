package oxxy.kero.roiaculte.team7.khbich.model.repositories.remote.dataSources;

import android.util.Log;

import org.json.JSONObject;

import javax.inject.Inject;

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
    @Inject
    public Authentification(Retrofit retrofit) {
        this.dao = retrofit.create(RemoteDao.class);
    }
//    public Completable signUpUsere(final User user){
//        final String Key  = KeyCrypting.CrypteIt();
//        return Completable.create(new CompletableOnSubscribe() {
//            @Override
//            public void subscribe(final CompletableEmitter emitter) throws Exception {
//                 dao.saveUser(user, Key).enqueue(new Callback<Message>() {
//                     @Override
//                     public void onResponse(Call<Message> call, Response<Message> response) {
//                         Log.d(TAG, "onResponse:  entered onREsponse"+response.body());
//                         if(!emitter.isDisposed()){
//                             if(response.body().getResponse().equals("1")){
//                                 emitter.onComplete();
//                             }else {
//                                 emitter.onError(new UserNotRegistred());
//                             }
//                         }
//                     }
//
//                     @Override
//                     public void onFailure(Call<Message> call, Throwable t) {
//                         if(!emitter.isDisposed()){
//                             emitter.onError(t);
//                         }
//                     }
//                 });
//            }
//        });
//    }

    public Completable SignUpUser(final UserView user) {
         final String Key  = KeyCrypting.CrypteIt();
        final User userz = UserConverter.fromViewToRemote(user);
         return Completable.create(new CompletableOnSubscribe() {
             @Override
             public void subscribe(final CompletableEmitter emitter) throws Exception {
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
                                if (response.body().getYear() == null) {
                                    Log.d(TAG, "onResponse: errroooorr");
                                    //todo handle the json vide *.*  this post is util https://proandroiddev.com/concise-error-handling-with-livedata-and-retrofit-15937ceb555b
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
                        Log.d(TAG, "onFailure: "+t.getLocalizedMessage());
                        Log.d(TAG, "onFailure: "+t.getMessage());
                        t.printStackTrace();
                    }
                });
            }
        });

    }


}
