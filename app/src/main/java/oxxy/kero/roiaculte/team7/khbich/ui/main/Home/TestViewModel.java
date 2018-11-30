package oxxy.kero.roiaculte.team7.khbich.ui.main.Home;

import java.util.ArrayList;

import androidx.lifecycle.ViewModel;
import oxxy.kero.roiaculte.team7.khbich.model.models.Question;

public class TestViewModel extends ViewModel {
    private Long TestId ;

    private QuestionsView questionsView;


    public Long getTestId() {
        return TestId;
    }

    public void setTestId(Long testId) {
        TestId = testId;
    }

    public QuestionsView getQuestionsView() {
        return questionsView;
    }

    public void setQuestionsView(QuestionsView questionsView) {
        this.questionsView = questionsView;
    }
}
