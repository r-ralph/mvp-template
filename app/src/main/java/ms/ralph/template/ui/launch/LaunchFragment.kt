package ms.ralph.template.ui.launch

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dagger.android.support.DaggerFragment
import ms.ralph.template.R
import ms.ralph.template.di.scope.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class LaunchFragment @Inject constructor() : DaggerFragment(), LaunchView {

    @Inject
    lateinit var presenter: LaunchPresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.fragment_launch, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.onViewCreated(this)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        presenter.onViewDestroyed()
    }

    override fun moveToMain() {
        //startActivity(Intent(activity, MainActivity::class.java).apply {
        //    flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
        //})
    }
}
