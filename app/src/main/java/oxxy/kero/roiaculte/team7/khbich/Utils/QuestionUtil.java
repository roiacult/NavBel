package oxxy.kero.roiaculte.team7.khbich.Utils;

import java.util.ArrayList;
import java.util.List;

import oxxy.kero.roiaculte.team7.khbich.model.models.Question;
import oxxy.kero.roiaculte.team7.khbich.ui.main.Home.QuestionsView;

public class QuestionUtil {

    public static QuestionsView convert(List<Question> allQuestions){

        ArrayList<Question> questionsQcm = new ArrayList<>();
        ArrayList<Question> questionsFillGaps = new ArrayList<>();
        ArrayList<Question> questionsAnswer = new ArrayList<>();

        for (Question question : allQuestions){

            switch (question.getQuestionType()){
                case QCM: questionsQcm.add(question);
                break;
                case INPUT: questionsFillGaps.add(question);
                break;
                case EDITTEXT: questionsAnswer.add(question);
                break;
            }

        }

        QuestionsView seprate= new QuestionsView();
        seprate.setQuestionsAnswer(questionsAnswer);
        seprate.setQuestionsFillGaps(questionsFillGaps);
        seprate.setQuestionsQcm(questionsQcm);

        return seprate;
    }
}


