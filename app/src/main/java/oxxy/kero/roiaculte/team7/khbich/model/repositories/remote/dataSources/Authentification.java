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
import oxxy.kero.roiaculte.team7.khbich.model.models.User;
import oxxy.kero.roiaculte.team7.khbich.model.models.UserState;
import oxxy.kero.roiaculte.team7.khbich.model.repositories.remote.dao.RemoteDao;
import oxxy.kero.roiaculte.team7.khbich.model.repositories.remote.exeptions.UserNotRegistred;
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
    public Completable SignUpUser(final User user) {
         final String Key  = KeyCrypting.CrypteIt();
         return Completable.create(new CompletableOnSubscribe() {
             @Override
             public void subscribe(final CompletableEmitter emitter) throws Exception {
                 dao.saveUser(user, Key).enqueue(new Callback<String>() {
                     @Override
                     public void onResponse(Call<String> call, Response<String> response) {
                         Log.d(TAG, "onResponse:  entered onREsponse"+response.body());
                          if(!emitter.isDisposed()){
                              if(response.body().equals("1")){
                                  emitter.onComplete();
                              }else {
                                  emitter.onError(new UserNotRegistred());
                              }
                          }
                     }
                     @Override
                     public void onFailure(Call<String> call, Throwable t) {
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
            public void subscribe(ObservableEmitter<UserState> emitter) throws Exception {


            }
        });
    }

}
