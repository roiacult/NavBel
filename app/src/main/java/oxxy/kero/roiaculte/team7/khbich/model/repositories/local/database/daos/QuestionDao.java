package oxxy.kero.roiaculte.team7.khbich.model.repositories.local.database.daos;

import java.util.List;


import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import io.reactivex.Completable;
import io.reactivex.Observable;
import oxxy.kero.roiaculte.team7.khbich.model.models.Question;

@Dao
public interface QuestionDao {
    @Insert
    Completable insertQuestionRemote(final List<Question> questionLIst);

    @Query("SELECT *FROM Question WHERE testId =:testId")
    Observable<List<Question>> getQuestionById(long testId);

    @Query("delete from Question")
    void dropTable() ;
}
