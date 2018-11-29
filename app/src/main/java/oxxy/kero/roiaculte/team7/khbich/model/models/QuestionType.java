package oxxy.kero.roiaculte.team7.khbich.model.models;

import androidx.room.TypeConverter;
import androidx.room.TypeConverters;

public enum QuestionType {
    QCM , INPUT, EDITTEXT
}
class QuestionConverter{
    @TypeConverter
    public QuestionType fromString(String string ){
        switch(Integer.parseInt(string)){
            case 0: return QuestionType.QCM;
            case 1 : return QuestionType.INPUT;
            case 2: return QuestionType.EDITTEXT;
            default:return QuestionType.QCM;
        }
    }
    @TypeConverter
    public String fromQuestionType(QuestionType questionType){
        switch (questionType){
            case QCM: return "0";
            case EDITTEXT:return "2";
            case INPUT:return "1";
            default:return "0";
        }
    }
}
