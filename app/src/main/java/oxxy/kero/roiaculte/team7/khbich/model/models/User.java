package oxxy.kero.roiaculte.team7.khbich.model.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User {
    @SerializedName("name")
    @Expose
    private String name ;
    @SerializedName("email")
    @Expose
    private String email ;
    @SerializedName("picture")
    @Expose private String picture ;
    @SerializedName("password")
    @Expose
    private String password;
    @SerializedName("date")
    @Expose
    private String date ;
//    private Date date  ;  we will handle it later
    @SerializedName("year")
    @Expose
    private String year;
    @SerializedName("point")
    @Expose
    private String points ;
    @SerializedName("qsolved")
    @Expose
    private String qsolved;
    @SerializedName("level")
    @Expose
    private String level ;

    public User(String name, String email, String password,String picture ,  String date, String year, String points, String qsolved, String level) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.date = date;
        this.year = year;
        this.points = points;
        this.qsolved = qsolved;
        this.level = level;
        this.picture = picture;
    }

    public User(String name, String email, String password, String picture , String date, String year) {
        this(name, email, password,picture ,date, year , "0","", "0");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        year = year;
    }

    public String getPoints() {
        return points;
    }

    public void setPoints(String points) {
        this.points = points;
    }

    public String getQsolved() {
        return qsolved;
    }

    public void setQsolved(String qsolved) {
        this.qsolved = qsolved;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        level = level;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}
