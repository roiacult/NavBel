package oxxy.kero.roiaculte.team7.khbich.ui.main.Home;

import java.util.ArrayList;

import oxxy.kero.roiaculte.team7.khbich.model.models.Question;

public  class QuestionsView {
    ArrayList<Question> questionsQcm;
    ArrayList<Question> questionsFillGaps;
    ArrayList<Question> questionsAnswer;

    public ArrayList<Question> getQuestionsQcm() {
        return questionsQcm;
    }

    public void setQuestionsQcm(ArrayList<Question> questionsQcm) {
        this.questionsQcm = questionsQcm;
    }

    public ArrayList<Question> getQuestionsFillGaps() {
        return questionsFillGaps;
    }

    public void setQuestionsFillGaps(ArrayList<Question> questionsFillGaps) {
        this.questionsFillGaps = questionsFillGaps;
    }

    public ArrayList<Question> getQuestionsAnswer() {
        return questionsAnswer;
    }

    public void setQuestionsAnswer(ArrayList<Question> questionsAnswer) {
        this.questionsAnswer = questionsAnswer;
    }
}