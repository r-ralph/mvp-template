package ms.ralph.template.di.module

import dagger.Module
import dagger.android.ContributesAndroidInjector
import ms.ralph.template.di.scope.ActivityScoped
import ms.ralph.template.ui.launch.LaunchActivity
import ms.ralph.template.ui.launch.LaunchModule

@Module
abstract class ActivityBindingModule {

    @ActivityScoped
    @ContributesAndroidInjector(modules = [LaunchModule::class])
    abstract fun launch(): LaunchActivity

}
