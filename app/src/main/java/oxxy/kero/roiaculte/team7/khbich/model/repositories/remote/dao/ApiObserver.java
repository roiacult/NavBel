package oxxy.kero.roiaculte.team7.khbich.model.repositories.remote.dao;

import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import oxxy.kero.roiaculte.team7.khbich.model.models.DataWrapper;

public class ApiObserver<T> implements Observer<DataWrapper<T>> {
    private ChangeListener<T> changeListener;
    private static final int ERROR_CODE = 0;

    public ApiObserver(ChangeListener<T> changeListener) {
        this.changeListener = changeListener;
    }

    @Override
    public void onChanged(@Nullable DataWrapper<T> tDataWrapper) {
        if (tDataWrapper != null) {
            if (tDataWrapper.getApiException() != null) {
                changeListener.onException(tDataWrapper.getApiException());
            }else {
                changeListener.onSuccess(tDataWrapper.getData());
            }
            return;
        }
        //custom exceptionn to suite my use case
//        changeListener.onException(new ValidationAPIException(ERROR_CODE, null));
    }
    public interface ChangeListener<T> {
        void onSuccess(T dataWrapper);
        void onException(Exception exception);
    }
}
