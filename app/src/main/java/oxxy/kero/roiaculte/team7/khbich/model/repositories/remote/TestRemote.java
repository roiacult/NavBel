package oxxy.kero.roiaculte.team7.khbich.model.repositories.remote;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TestRemote {
    @Expose
    @SerializedName("id")
    private String id;
    @Expose
    @SerializedName("name")
   private String Name ;
    @Expose
    @SerializedName("description")
   private String  DEsc ;
    @Expose
    @SerializedName("image")
   private String ImageUrl;
    @Expose
    @SerializedName("questions")
   private String Question ;
    @Expose
    @SerializedName("point")
   private String Points ;
    @Expose
    @SerializedName("year")
    private String year ;

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public TestRemote(String id, String name, String DEsc, String imageUrl, String question, String points, String year) {
        this.id = id;
        Name = name;
        this.DEsc = DEsc;
        ImageUrl = imageUrl;
        Question = question;
        Points = points;
        this.year = year;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDEsc() {
        return DEsc;
    }

    public void setDEsc(String DEsc) {
        this.DEsc = DEsc;
    }

    public String getImageUrl() {
        return ImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        ImageUrl = imageUrl;
    }

    public String getQuestion() {
        return Question;
    }

    public void setQuestion(String question) {
        Question = question;
    }

    public String getPoints() {
        return Points;
    }

    public void setPoints(String points) {
        Points = points;
    }
}
