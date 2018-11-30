package oxxy.kero.roiaculte.team7.khbich.model.repositories.remote;

public class QuestionRemote {

    private String id ;
    private String ImageUrl ;
    private String QuestionType  ;
    private String Question;
    private String OPtion ;
    private String REsponse ;
    private String Points  ;
    private String TestId ;

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
