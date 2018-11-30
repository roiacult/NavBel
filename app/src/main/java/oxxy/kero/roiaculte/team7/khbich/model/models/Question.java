package oxxy.kero.roiaculte.team7.khbich.model.models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

@Entity
public class Question {
    @PrimaryKey(autoGenerate = true)
    private  long Id ;
    private String ImageUrl ;
    @TypeConverters(QuestionConverter.class)
    private QuestionType  questionType;
    private String Question ;
    private String Option ;
    private String response ;
    private int Points;
    private long testId ;

    public Question() {
    }

    public Question(long id, String imageUrl, QuestionType questionType, String question, String option, String response, int points, long testId) {
        Id = id;
        ImageUrl = imageUrl;
        this.questionType = questionType;
        Question = question;
        Option = option;
        this.response = response;
        Points = points;
        this.testId = testId;
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getImageUrl() {
        return ImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        ImageUrl = imageUrl;
    }

    public QuestionType getQuestionType() {
        return questionType;
    }

    public void setQuestionType(QuestionType questionType) {
        this.questionType = questionType;
    }

    public String getQuestion() {
        return Question;
    }

    public void setQuestion(String question) {
        Question = question;
    }

    public String getOption() {
        return Option;
    }

    public void setOption(String option) {
        Option = option;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public int getPoints() {
        return Points;
    }

    public void setPoints(int points) {
        Points = points;
    }

    public long getTestId() {
        return testId;
    }

    public void setTestId(long testId) {
        this.testId = testId;
    }
}
