package oxxy.kero.roiaculte.team7.khbich.model.remote;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Date;
public class User {
    @SerializedName("name")
    @Expose
    private String Name ;
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
    private String Year;
    @SerializedName("point")
    @Expose
    private String points ;
    @SerializedName("Qsolved")
    @Expose private String Qsolved ;
    @SerializedName("level")
    @Expose
    private String Level ;

    public User(String name, String email, String password, String date, String year, String points, String qsolved, String level) {
        Name = name;
        this.email = email;
        this.password = password;
        this.date = date;
        Year = year;
        this.points = points;
        Qsolved = qsolved;
        Level = level;
    }

    public User(String name, String email, String password, String date, String year) {
        this(name, email, password, date, year , "0","", "0");
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
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
        return Year;
    }

    public void setYear(String year) {
        Year = year;
    }

    public String getPoints() {
        return points;
    }

    public void setPoints(String points) {
        this.points = points;
    }

    public String getQsolved() {
        return Qsolved;
    }

    public void setQsolved(String qsolved) {
        Qsolved = qsolved;
    }

    public String getLevel() {
        return Level;
    }

    public void setLevel(String level) {
        Level = level;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}
