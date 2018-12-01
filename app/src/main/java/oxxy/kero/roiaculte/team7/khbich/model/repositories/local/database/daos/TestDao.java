package oxxy.kero.roiaculte.team7.khbich.model.repositories.local.database.daos;

import java.util.List;
import java.util.ListIterator;

import javax.inject.Inject;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import io.reactivex.Completable;
import io.reactivex.Observable;
import oxxy.kero.roiaculte.team7.khbich.model.models.Test;

@Dao
public interface TestDao {
    @Insert
    void InsertFromRempte( final List<Test> tests);
     @Query("delete from Test")
    void deleteTable();
     @Query("SELECT * FROM Test WHERE isResolved = :bool")
     Observable<List<Test>> getTestResolved(boolean bool);

     @Query("SELECT * FROM Test ")
    Observable<List<Test>> getTests();



}
