package ms.ralph.template.ui.launch

import android.os.Bundle
import ms.ralph.template.R
import dagger.Lazy
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class LaunchActivity @Inject constructor() : DaggerAppCompatActivity() {

    @Inject
    lateinit var fragmentProvider: Lazy<LaunchFragment>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launch)

        var fragment = supportFragmentManager.findFragmentById(R.id.content) as? LaunchFragment
        if (fragment == null) {
            fragment = fragmentProvider.get()
            supportFragmentManager.beginTransaction()
                    .add(R.id.content, fragment)
                    .commit()
        }
    }
}
