package oxxy.kero.roiaculte.team7.khbich.ui.main;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import oxxy.kero.roiaculte.team7.khbich.model.models.Test;
import oxxy.kero.roiaculte.team7.khbich.ui.UserView;

public class MainViewModel extends ViewModel {

    private LiveData<UserView> user;
    private List<Test> tests;

    public LiveData<UserView> getUser() {
        return user;
    }

    public void setUser(LiveData<UserView> user) {
        this.user = user;
    }

    public List<Test> getTests() {
        return tests;
    }

    public void setTests(List<Test> tests) {
        this.tests = tests;
    }
}
