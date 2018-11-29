package oxxy.kero.roiaculte.team7.khbich.model.models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;
import oxxy.kero.roiaculte.team7.khbich.Utils.UserConverter;

@Entity
public class Test {
    @PrimaryKey(autoGenerate = true)
    public long Id ;
    private String Name ;
    private String Description ;
    private String ImageUrl ;
    private int Points ;
    @TypeConverters(UserConverter.class)
    private UserState year;
    private int NumberQuestion;

    public Test(long id, String name, String description, String imageUrl, int points, UserState year, int numberQuestion) {
        Id = id;
        Name = name;
        Description = description;
        ImageUrl = imageUrl;
        Points = points;
        this.year = year;
        NumberQuestion = numberQuestion;
    }

    public int getNumberQuestion() {
        return NumberQuestion;
    }

    public void setNumberQuestion(int numberQuestion) {
        NumberQuestion = numberQuestion;
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getImageUrl() {
        return ImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        ImageUrl = imageUrl;
    }

    public int getPoints() {
        return Points;
    }

    public void setPoints(int points) {
        Points = points;
    }

    public UserState getYear() {
        return year;
    }

    public void setYear(UserState year) {
        this.year = year;
    }

    public Test() {
    }
}
