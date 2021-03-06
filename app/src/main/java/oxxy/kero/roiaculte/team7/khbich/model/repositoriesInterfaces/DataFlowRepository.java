package oxxy.kero.roiaculte.team7.khbich.model.repositoriesInterfaces;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.observers.DisposableCompletableObserver;
import io.reactivex.observers.DisposableObserver;
import oxxy.kero.roiaculte.team7.khbich.model.models.Question;
import oxxy.kero.roiaculte.team7.khbich.model.models.Test;

public interface DataFlowRepository {

    void  updateLOcalDatabase(DisposableCompletableObserver observer);

    void getTestSolved(DisposableObserver<List<Test>> tests);
    void dropTable();
    void getAllTests(DisposableObserver<List<Test>> listDisposableObserver);
    void getQuestionFromTest(DisposableObserver<List<Question>> questionObserver, long id);
//    public void getQuestionFromTest(DisposableObserver<List<Question>> questionObserver, long id)
}
