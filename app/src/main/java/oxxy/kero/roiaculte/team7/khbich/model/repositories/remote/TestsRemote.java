package oxxy.kero.roiaculte.team7.khbich.model.repositories.remote;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import oxxy.kero.roiaculte.team7.khbich.model.repositories.remote.TestRemote;

public class TestsRemote {
    @Expose
    @SerializedName("records")
    private TestRemote[] tests ;

    public TestsRemote(TestRemote[] tests) {
        this.tests = tests;
    }

    public TestRemote[] getTests() {
        return tests;
    }

    public void setTests(TestRemote[] tests) {
        this.tests = tests;
    }
}
