package oxxy.kero.roiaculte.team7.khbich.dagger.module;

import dagger.Module;
import oxxy.kero.roiaculte.team7.khbich.base.BaseActivity;

@Module
public class ActivityModule {
    private BaseActivity activity ;

    public ActivityModule(BaseActivity activity) {
        this.activity = activity;
    }

}
