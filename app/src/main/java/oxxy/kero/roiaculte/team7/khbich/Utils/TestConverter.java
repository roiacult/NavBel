package oxxy.kero.roiaculte.team7.khbich.Utils;

import java.util.ArrayList;
import java.util.List;

import oxxy.kero.roiaculte.team7.khbich.model.models.Test;
import oxxy.kero.roiaculte.team7.khbich.model.repositories.remote.TestRemote;
import oxxy.kero.roiaculte.team7.khbich.model.repositories.remote.TestsRemote;

public class TestConverter {
   public static List<Test> fromTestRemote(TestsRemote remote){
        List<Test> tests = new ArrayList<>();
        for (TestRemote rmote:
             remote.getTests()) {
            tests.add(new Test(Long.parseLong(rmote.getId()), rmote.getName(), rmote.getDEsc()
                    , rmote.getImageUrl() , Integer.parseInt(rmote.getPoints()), UserConverter
                    .fromInt(Integer.parseInt(rmote.getYear())), Integer.parseInt(rmote.getQuestion())));
        }
        return  tests;
    }
}
