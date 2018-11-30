package oxxy.kero.roiaculte.team7.khbich.Utils;

import oxxy.kero.roiaculte.team7.khbich.model.models.Question;
import oxxy.kero.roiaculte.team7.khbich.model.models.QuestionConverter;
import oxxy.kero.roiaculte.team7.khbich.model.repositories.remote.QuestionRemote;

public class QuestionConvertere {
    public static Question fromREmote(QuestionRemote remote){
        return new Question(Long.parseLong(remote.getId())
                , remote.getImageUrl(), QuestionConverter.fromString(remote.getQuestionType()),
                remote.getQuestion() , remote.getOPtion(), remote.getREsponse(), Integer.parseInt(remote.getPoints()),
                Long.parseLong(remote.getTestId()))  ;
    }
}
