package oxxy.kero.roiaculte.team7.khbich.model.repositories.local.database;

import android.content.Context;

import javax.inject.Inject;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import oxxy.kero.roiaculte.team7.khbich.model.models.Question;
import oxxy.kero.roiaculte.team7.khbich.model.models.Test;
import oxxy.kero.roiaculte.team7.khbich.model.repositories.local.database.daos.QuestionDao;
import oxxy.kero.roiaculte.team7.khbich.model.repositories.local.database.daos.TestDao;

@Database(entities = {Test.class, QuestionDao.class}, version = 1, exportSchema = false )
public abstract class LocalDatabase extends RoomDatabase {
      private static volatile LocalDatabase database ;

      public abstract TestDao testDao();
      public abstract QuestionDao questionDao();

    public LocalDatabase() {
    }

    public  static LocalDatabase  getDatabase(Context context) {
        if(database ==null){
            synchronized (LocalDatabase.class){
                if(database==null){
                    database= Room.databaseBuilder(context, LocalDatabase.class, "LocalDatabase")
                            .allowMainThreadQueries().build();
                }
            }
        }
        return database;
    }


}
