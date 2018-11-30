package oxxy.kero.roiaculte.team7.khbich.model.repositories.local.database.daos;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import io.reactivex.Completable;
import oxxy.kero.roiaculte.team7.khbich.model.models.Question;

@Dao
public interface QuestionDao {
    @Insert
    Completable insertQuestionRemote(final List<Question> questionLIst);

}
