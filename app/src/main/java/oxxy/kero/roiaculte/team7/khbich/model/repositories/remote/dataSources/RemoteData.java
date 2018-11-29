package oxxy.kero.roiaculte.team7.khbich.model.repositories.remote.dataSources;

import android.util.Log;

import java.util.List;

import javax.inject.Inject;

import oxxy.kero.roiaculte.team7.khbich.Utils.KeyCrypting;
import oxxy.kero.roiaculte.team7.khbich.model.repositories.remote.TestRemote;
import oxxy.kero.roiaculte.team7.khbich.model.repositories.remote.TestsRemote;
import oxxy.kero.roiaculte.team7.khbich.model.repositories.remote.dao.RemoteDao;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

import static oxxy.kero.roiaculte.team7.khbich.model.repositories.remote.dataSources.Authentification.TAG;

public class RemoteData {
    private RemoteDao dao ;
    @Inject
    public RemoteData(Retrofit retrofit){
        dao = retrofit.create(RemoteDao.class);
    }

    public Call<TestsRemote> getTests(String year){
        String Key = KeyCrypting.CrypteIt();
       return dao.getTests(year, Key);
    }






}
