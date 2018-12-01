package oxxy.kero.roiaculte.team7.khbich.model.repositories.local.database;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import oxxy.kero.roiaculte.team7.khbich.Utils.JobExecutor;
import oxxy.kero.roiaculte.team7.khbich.Utils.TextUtils;
import oxxy.kero.roiaculte.team7.khbich.model.models.Question;
import oxxy.kero.roiaculte.team7.khbich.model.models.Test;
import oxxy.kero.roiaculte.team7.khbich.model.repositories.local.database.daos.QuestionDao;
import oxxy.kero.roiaculte.team7.khbich.model.repositories.local.database.daos.TestDao;

import static oxxy.kero.roiaculte.team7.khbich.MainActivity.TAG;

public class LocalData {
    private TestDao dao;
    private QuestionDao questionDao;
    @Inject
    public LocalData(LocalDatabase database) {
        this.dao = database.testDao();
        this.questionDao = database.questionDao();
    }

    public Completable saveTests(List<Test> tests, List<Long> longs){
        Log.d(TAG, "saveTests:  "+String.valueOf(tests.size()));
        for (Test test:tests
             ) {
            if(TextUtils.IsSolved(test.getId(), longs)){
                test.setResolved(true);
            }
        }
        return dao.InsertFromRempte(tests);
    }

public void getUresolvedTests(DisposableObserver<List<Test>> observer){
      dao.getTestResolved(false).
              observeOn(AndroidSchedulers
              .mainThread())
              .subscribeOn(Schedulers.from(new JobExecutor()))
              .subscribeWith(observer);
}
public void deletDatabase()
{
    questionDao.dropTable();
        dao.deleteTable();
}
   public Completable saveQuestions(List<Question>questions){
        return questionDao.insertQuestionRemote(questions);
   }

public Observable<List<Test>> getTestSolved(){
        return dao.getTestResolved(true);
}

    public void getQuestioTest(long testId, DisposableObserver<List<Question>> questions){
        questionDao.getQuestionById(testId).subscribeOn(Schedulers.from(new JobExecutor())).observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(questions);

    }



}
