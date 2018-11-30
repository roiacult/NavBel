package oxxy.kero.roiaculte.team7.khbich.model.repositories.remote;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class QuestionRemote {
    @SerializedName("id")
    @Expose
    private String id ;
    @SerializedName("image")
    @Expose
    private String ImageUrl ;
  @SerializedName("type")
  @Expose
    private String QuestionType  ;
    @SerializedName("question")
    @Expose
    private String Question;
    @SerializedName("option")
    @Expose
    private String OPtion ;
    @SerializedName("reponse")
    @Expose
    private String REsponse ;
    @SerializedName("point")
    @Expose
    private String Points  ;
    @SerializedName("testid")
    @Expose
    private String TestId ;
    @SerializedName("year")
    @Expose
    private String year;

    public QuestionRemote(String id, String imageUrl, String questionType, String question, String OPtion, String REsponse, String points, String testId, String year) {
        this.id = id;
        ImageUrl = imageUrl;
        QuestionType = questionType;
        Question = question;
        this.OPtion = OPtion;
        this.REsponse = REsponse;
        Points = points;
        TestId = testId;
        this.year = year;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public QuestionRemote(String id, String imageUrl, String questionType, String question, String OPtion, String REsponse, String points, String testId) {
        this.id = id;
        ImageUrl = imageUrl;
        QuestionType = questionType;
        Question = question;
        this.OPtion = OPtion;
        this.REsponse = REsponse;
        Points = points;
        TestId = testId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImageUrl() {
        return ImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        ImageUrl = imageUrl;
    }

    public String getQuestionType() {
        return QuestionType;
    }

    public void setQuestionType(String questionType) {
        QuestionType = questionType;
    }

    public String getQuestion() {
        return Question;
    }

    public void setQuestion(String question) {
        Question = question;
    }

    public String getOPtion() {
        return OPtion;
    }

    public void setOPtion(String OPtion) {
        this.OPtion = OPtion;
    }

    public String getREsponse() {
        return REsponse;
    }

    public void setREsponse(String REsponse) {
        this.REsponse = REsponse;
    }

    public String getPoints() {
        return Points;
    }

    public void setPoints(String points) {
        Points = points;
    }

    public String getTestId() {
        return TestId;
    }

    public void setTestId(String testId) {
        TestId = testId;
    }

}
