package oxxy.kero.roiaculte.team7.khbich.model.repositoriesInterfaces;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.observers.DisposableObserver;
import oxxy.kero.roiaculte.team7.khbich.model.models.Test;

public interface DataFlowRepository {

Completable updateLOcalDatabase();
void getTestSolved(DisposableObserver<List<Test>> tests);
void dropTable();
void getAllTests(DisposableObserver<List<Test>> listDisposableObserver);
}
