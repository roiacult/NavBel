package oxxy.kero.roiaculte.team7.khbich.model.repositories.remote;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class QuestionsRemote {
    @SerializedName("records")
    @Expose
    private QuestionRemote[] questionRemotes;

    public QuestionsRemote(QuestionRemote[] questionRemotes) {
        this.questionRemotes = questionRemotes;
    }

    public QuestionRemote[] getQuestionRemotes() {
        return questionRemotes;
    }

    public void setQuestionRemotes(QuestionRemote[] questionRemotes) {
        this.questionRemotes = questionRemotes;
    }
}
