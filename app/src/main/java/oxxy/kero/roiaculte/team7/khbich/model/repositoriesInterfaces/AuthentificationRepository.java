package oxxy.kero.roiaculte.team7.khbich.model.repositoriesInterfaces;

import androidx.lifecycle.LiveData;
import io.reactivex.Completable;
import io.reactivex.observers.DisposableCompletableObserver;
import oxxy.kero.roiaculte.team7.khbich.model.models.User;
import oxxy.kero.roiaculte.team7.khbich.model.models.UserState;

public interface AuthentificationRepository {

     void SaveUserRemote(User user, DisposableCompletableObserver observer);

     LiveData<UserState> checkUser(String mail);
     LiveData<Boolean> isUserLoggedIn();
}
