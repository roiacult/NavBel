package oxxy.kero.roiaculte.team7.khbich.model.repositories.remote.dao;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import oxxy.kero.roiaculte.team7.khbich.model.models.DataWrapper;
import retrofit2.Call;
import retrofit2.Response;

public abstract  class RequestHandler<R> {
    abstract protected Call<Response<R>> makeRequest();
    public final LiveData<DataWrapper<R>> doRequest() {
        final MutableLiveData<DataWrapper<R>> liveData = new MutableLiveData<>();
        final DataWrapper<R> dataWrapper = new DataWrapper<R>();
        makeRequest().enqueue(new ApiCallbackImpl<R>() {
            @Override
            protected void handleResponseData(R data) {
                dataWrapper.setData(data);
                liveData.setValue(dataWrapper);
            }

            @Override
            protected void handleError(retrofit2.Response<Response<R>> response) {
//                dataWrapper.setApiException(ApiErrorHandler.getErrorData(response)); set exception for the right one
                liveData.setValue(dataWrapper);
            }

            @Override
            protected void handleException(Exception t) {
                dataWrapper.setApiException(t);
                liveData.setValue(dataWrapper);
            }
        });
        return liveData;
    }
}
