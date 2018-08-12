package ms.ralph.template.ui.launch

import ms.ralph.template.base.BasePresenter
import ms.ralph.template.di.scope.ActivityScoped
import io.reactivex.Completable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit
import javax.inject.Inject

@ActivityScoped
class LaunchPresenter @Inject constructor() : BasePresenter<LaunchView>() {

    override fun onViewCreated(view: LaunchView) {
        super.onViewCreated(view)
        Completable.complete()
            .delay(1000, TimeUnit.MILLISECONDS)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { view.moveToMain() }
    }
}
