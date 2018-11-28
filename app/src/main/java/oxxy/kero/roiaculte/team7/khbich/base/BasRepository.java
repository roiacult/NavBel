package oxxy.kero.roiaculte.team7.khbich.base;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.LiveDataReactiveStreams;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Completable;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableCompletableObserver;
import io.reactivex.schedulers.Schedulers;
import oxxy.kero.roiaculte.team7.khbich.Utils.JobExecutor;

public class BasRepository {
    private JobExecutor jobExecutor ;
    private CompositeDisposable disposable;

    public BasRepository(JobExecutor jobExecutor) {
        this.disposable = new CompositeDisposable();
        this.jobExecutor = jobExecutor;
    }
    protected <T extends Completable, O extends DisposableCompletableObserver> void  executeCompletable(T observable, O observer){
       disposable.add(   observable
               .subscribeOn(Schedulers.from(jobExecutor))
               .observeOn(AndroidSchedulers.mainThread())
               .subscribeWith(observer));
    }
    protected <T> LiveData<T> convertToLiveData(Observable<T> observable){
    return     LiveDataReactiveStreams.fromPublisher(observable.toFlowable(BackpressureStrategy.DROP));
    }
    protected void dispose (){
        if(!disposable.isDisposed()){
            disposable.dispose();
        }
    }

}
