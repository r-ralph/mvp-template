package ms.ralph.template.ui.launch

import ms.ralph.template.base.BasePresenter
import ms.ralph.template.di.scope.ActivityScoped
import ms.ralph.template.di.scope.FragmentScoped
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class LaunchModule {

    @FragmentScoped
    @ContributesAndroidInjector
    internal abstract fun launchFragment(): LaunchFragment

    @ActivityScoped
    @Binds
    internal abstract fun launchPresenter(presenter: LaunchPresenter): BasePresenter<LaunchView>
}
