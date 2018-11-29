package oxxy.kero.roiaculte.team7.khbich.model.repositories;

import javax.inject.Inject;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.LiveDataReactiveStreams;
import androidx.lifecycle.MutableLiveData;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Completable;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Action;
import io.reactivex.observers.DisposableCompletableObserver;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import oxxy.kero.roiaculte.team7.khbich.Utils.JobExecutor;
import oxxy.kero.roiaculte.team7.khbich.base.BasRepository;
import oxxy.kero.roiaculte.team7.khbich.model.models.User;
import oxxy.kero.roiaculte.team7.khbich.model.models.UserState;
import oxxy.kero.roiaculte.team7.khbich.model.repositories.local.sharedReference.MainSharedReference;
import oxxy.kero.roiaculte.team7.khbich.model.repositories.remote.dataSources.Authentification;
import oxxy.kero.roiaculte.team7.khbich.model.repositoriesInterfaces.AuthentificationRepository;
import oxxy.kero.roiaculte.team7.khbich.ui.UserView;

public class AuthentificationImpl extends BasRepository implements AuthentificationRepository {
    private Authentification auth ;
    private MainSharedReference preference ;


    public AuthentificationImpl(Authentification auth, JobExecutor executor, MainSharedReference preference) {
        super(executor);
        this.auth = auth;
        this.preference = preference;
    }

    @Override
    public void SaveUserRemote(final UserView user, DisposableCompletableObserver observer) {
        //todo dont forget to add a sign out
        executeCompletable(auth.SignUpUser(user)
                , observer);
    }
    @Override
    public LiveData<UserState> checkUser(String mail) {
        return convertToLiveData(auth.CheckUser(mail));
    }

    @Override
    public LiveData<Boolean> isUserLoggedIn() {
        MutableLiveData<Boolean> mutableLiveData = new MutableLiveData();
        mutableLiveData.setValue(preference.IsUserLOgged());
        return mutableLiveData;
    }

//    @Override
//    public void LogUserIn(String mail, String password, DisposableObserver<UserView> observer) {
//        auth.loginUser(mail, password).observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.from(new JobExecutor()))
//                .subscribeWith(observer);
//    }

    @Override
    public LiveData<UserView> login(String mail, String password) {
        return convertToLiveData(auth.loginUser(mail, password));
    }

    @Override
    public void AddUserLocal(UserView userView) {
        preference.LogUserIn(userView);
    }

    @Override
    public LiveData<UserView> getUserLocal() {
        return preference.getUserViewLocal();
    }

    @Override
    public void UpdateDataUser(UserView userView, DisposableCompletableObserver observer) {
        executeCompletable(auth.updateUserData(userView), observer);
    }
}