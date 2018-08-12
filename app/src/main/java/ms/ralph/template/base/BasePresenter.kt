package ms.ralph.template.base

import androidx.annotation.CallSuper
import androidx.annotation.CheckResult
import com.trello.rxlifecycle2.LifecycleProvider
import com.trello.rxlifecycle2.LifecycleTransformer
import com.trello.rxlifecycle2.RxLifecycle
import ms.ralph.template.util.rx.PresenterEvent
import ms.ralph.template.util.rx.PresenterRxLifecycle
import io.reactivex.Observable
import io.reactivex.subjects.BehaviorSubject

abstract class BasePresenter<V : BaseView> : LifecycleProvider<PresenterEvent> {

    private val lifecycleSubject = BehaviorSubject.create<PresenterEvent>()

    lateinit var view: V

    @CallSuper
    open fun onViewCreated(view: V) {
        this.view = view
        lifecycleSubject.onNext(PresenterEvent.VIEW_CREATED)
    }

    @CallSuper
    open fun onViewDestroyed() {
        lifecycleSubject.onNext(PresenterEvent.VIEW_DESTROYED)
    }

    @CheckResult
    override fun lifecycle(): Observable<PresenterEvent> {
        return lifecycleSubject.hide()
    }

    override fun <T> bindToLifecycle(): LifecycleTransformer<T> {
        return PresenterRxLifecycle.bindPresenter(lifecycleSubject)
    }

    override fun <T : Any?> bindUntilEvent(event: PresenterEvent): LifecycleTransformer<T> {
        return RxLifecycle.bindUntilEvent(lifecycleSubject, event)
    }
}
