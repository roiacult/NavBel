package oxxy.kero.roiaculte.team7.khbich.model.repositories.local.database;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Completable;
import oxxy.kero.roiaculte.team7.khbich.model.models.Test;
import oxxy.kero.roiaculte.team7.khbich.model.repositories.local.database.daos.TestDao;

public class LocalData {
    private TestDao dao;
    @Inject
    public LocalData(LocalDatabase database) {
        this.dao = database.testDao();
    }

    public Completable saveTests(List<Test> tests){
        return dao.InsertFromRempte(tests);
    }

public void deletDatabase(){
        dao.deleteTable();
}




}
