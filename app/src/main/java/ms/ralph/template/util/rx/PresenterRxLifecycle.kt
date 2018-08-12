package ms.ralph.template.util.rx

import androidx.annotation.CheckResult
import com.trello.rxlifecycle2.LifecycleTransformer
import com.trello.rxlifecycle2.OutsideLifecycleException
import com.trello.rxlifecycle2.RxLifecycle.bind
import io.reactivex.Observable
import io.reactivex.functions.Function

object PresenterRxLifecycle {

    @CheckResult
    fun <T> bindPresenter(lifecycle: Observable<PresenterEvent>): LifecycleTransformer<T> =
        bind(lifecycle, PRESENTER_LIFECYCLE)

    private val PRESENTER_LIFECYCLE = Function<PresenterEvent, PresenterEvent> {
        when (it) {
            PresenterEvent.VIEW_CREATED -> PresenterEvent.VIEW_DESTROYED
            PresenterEvent.VIEW_DESTROYED ->
                throw OutsideLifecycleException("Cannot bind to Presenter lifecycle when outside of it.")
        }
    }
}
