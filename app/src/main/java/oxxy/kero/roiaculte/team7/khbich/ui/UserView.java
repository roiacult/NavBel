package oxxy.kero.roiaculte.team7.khbich.ui;

import android.net.Uri;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Date;

import oxxy.kero.roiaculte.team7.khbich.model.models.UserState;

public class UserView {
    private String name ;
    private String prename;
    private String email ;
    private String picture ;
    private Uri pictureUri;
    private String password;
    private UserState year;
    private int points ;
    private Date date  ;
    //todo configure this to a liste of questions
    private String qsolved;
    private int level ;

    public UserView(String name, String email, String picture, String password, UserState year, int points, Date date, String qsolved, int level) {
        this.name = name;
        this.email = email;
        this.picture = picture;
        this.password = password;
        this.year = year;
        this.points = points;
        this.date = date;
        this.qsolved = qsolved;
        this.level = level;
    }

    public UserView() {
    }


    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserState getYear() {
        return year;
    }

    public void setYear(UserState year) {
        this.year = year;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public String getQsolved() {
        return qsolved;
    }

    public void setQsolved(String qsolved) {
        this.qsolved = qsolved;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setPrename(String prename) {
        this.prename = prename;
    }

    public String getPrename() {
        return prename;
    }

    public Uri getPictureUri() {
        return pictureUri;
    }

    public void setPictureUri(Uri pictureUri) {
        this.pictureUri = pictureUri;
    }
}
