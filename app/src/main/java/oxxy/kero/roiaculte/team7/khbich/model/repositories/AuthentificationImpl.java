package oxxy.kero.roiaculte.team7.khbich.model.repositories;

import javax.inject.Inject;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.LiveDataReactiveStreams;
import androidx.lifecycle.MutableLiveData;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Completable;
import io.reactivex.functions.Action;
import io.reactivex.observers.DisposableCompletableObserver;
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
    MainSharedReference preference ;


    public AuthentificationImpl(Authentification auth, JobExecutor executor, MainSharedReference preference) {
        super(executor);
        this.auth = auth;
        this.preference = preference;
    }

    @Override
    public void SaveUserRemote(final UserView user, DisposableCompletableObserver observer) {
        //todo dont forget to add a sign out
        executeCompletable(auth.SignUpUser(user).andThen(Completable.fromAction(new Action() {
                    @Override
                    public void run() throws Exception {
                        preference.LogUserIn(user);
                    }
                }))
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
}
