package oxxy.kero.roiaculte.team7.khbich.model.repositories.local.database;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import oxxy.kero.roiaculte.team7.khbich.Utils.TextUtils;
import oxxy.kero.roiaculte.team7.khbich.model.models.Question;
import oxxy.kero.roiaculte.team7.khbich.model.models.Test;
import oxxy.kero.roiaculte.team7.khbich.model.repositories.local.database.daos.QuestionDao;
import oxxy.kero.roiaculte.team7.khbich.model.repositories.local.database.daos.TestDao;

public class LocalData {
    private TestDao dao;
    private QuestionDao questionDao;
    @Inject
    public LocalData(LocalDatabase database) {
        this.dao = database.testDao();
        this.questionDao = database.questionDao();
    }

    public Completable saveTests(List<Test> tests){
        return dao.InsertFromRempte(tests);
    }

public void deletDatabase(){
        dao.deleteTable();
}
   public Completable saveQuestions(List<Question>questions){
        return questionDao.insertQuestionRemote(questions);
   }

public Observable<List<Test>> getTestSolved(final String qsolved){
        return Observable.create(new ObservableOnSubscribe<List<Test>>() {
            @Override
            public void subscribe(ObservableEmitter<List<Test>> emitter) throws Exception {
                List<Test> tests = new ArrayList<>();
                List<Long> longs = TextUtils.getLOng(qsolved);
                for (Long l:
                     longs) {
                    tests.add(dao.getTest(l.longValue()));
                }
                if(!tests.isEmpty()){
                    emitter.onNext(tests);
                }else{
                    emitter.onError(new Exception());
                }
            }
        });
}

}
