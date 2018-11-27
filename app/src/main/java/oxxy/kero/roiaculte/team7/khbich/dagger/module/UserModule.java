package oxxy.kero.roiaculte.team7.khbich.dagger.module;

import dagger.Module;
import oxxy.kero.roiaculte.team7.khbich.base.BaseFragment;

@Module
public class UserModule {
    BaseFragment fragment;

    public UserModule(BaseFragment fragment) {
        this.fragment = fragment;
    }
}
