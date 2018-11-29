package oxxy.kero.roiaculte.team7.khbich.model.repositories.remote.dao;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public abstract class ApiCallbackImpl<T> implements Callback<Response<T>> {
    @Override
    public void onResponse(Call<Response<T>> call, retrofit2.Response<Response<T>> response) {
        if (response.body() != null) {
            handleResponseData(response.body().body());
        } else {
            handleError(response);
        }
    }

    abstract protected void handleResponseData(T data);

    abstract protected void handleError(retrofit2.Response<Response<T>> response);

    abstract protected void handleException(Exception t);

    @Override
    public void onFailure(Call<Response<T>> call, Throwable t) {
        if (t instanceof Exception) {
            handleException((Exception) t);
        } else {
            //do something else
        }
    }
}
