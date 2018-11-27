package oxxy.kero.roiaculte.team7.khbich.base;

public interface MvpBasePresenter<V extends MvpView> {

    void start();

    void onAttach(V mvpView);

    void onDetach();
}
