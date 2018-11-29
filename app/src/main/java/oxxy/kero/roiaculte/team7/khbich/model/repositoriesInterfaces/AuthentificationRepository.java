package oxxy.kero.roiaculte.team7.khbich.model.repositoriesInterfaces;

import androidx.lifecycle.LiveData;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.observers.DisposableCompletableObserver;
import io.reactivex.observers.DisposableObserver;
import oxxy.kero.roiaculte.team7.khbich.model.models.User;
import oxxy.kero.roiaculte.team7.khbich.model.models.UserState;
import oxxy.kero.roiaculte.team7.khbich.ui.UserView;

public interface AuthentificationRepository {

     void SaveUserRemote(UserView userView, DisposableCompletableObserver observer);

     LiveData<UserState> checkUser(String mail);

     LiveData<Boolean> isUserLoggedIn();

//     LiveData<UserView> login(String mail, String password);
     void login(String mail , String password, DisposableObserver<UserView> observer);
     void AddUserLocal (UserView userView);
     LiveData<UserView> getUserLocal();
     void UpdateDataUser(UserView userView, DisposableCompletableObserver observer);
     void SignUserOut(DisposableCompletableObserver observer);
}
