package oxxy.kero.roiaculte.team7.khbich.base;

import io.reactivex.disposables.CompositeDisposable;

public class BasePresenter<V extends MvpView> implements MvpBasePresenter<V> {

    private V view;

    @Override
    public void start() {

    }

    @Override
    public void onAttach(V mvpView) {
        view = mvpView;
    }

    @Override
    public void onDetach() {
        view = null ;
    }

    public V getView() {
        return view;
    }

    public boolean isViewAttached(){
        return view != null ;
    }
}
