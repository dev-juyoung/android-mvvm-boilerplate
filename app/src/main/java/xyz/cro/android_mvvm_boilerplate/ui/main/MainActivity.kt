package xyz.cro.android_mvvm_boilerplate.ui.main

import android.arch.lifecycle.Observer
import android.os.Bundle
import org.koin.android.architecture.ext.viewModel
import timber.log.Timber
import xyz.cro.android_mvvm_boilerplate.R
import xyz.cro.android_mvvm_boilerplate.databinding.MainActivityBinding
import xyz.cro.android_mvvm_boilerplate.ui.base.ArchitectureActivity

class MainActivity : ArchitectureActivity<MainActivityBinding, MainViewModel>() {
    override val viewModel: MainViewModel by viewModel()
    override fun getLayoutResId(): Int = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewDataBinding.let {
            it.setLifecycleOwner(this)
            it.viewModel = viewModel
        }

        observeSearchResult()
        viewModel.getUserRepositories("dev-juyoung")
    }

    private fun observeSearchResult() {
        viewModel.repoList.observe(this, Observer { Timber.i("user repositories count: ${it?.size}") })
    }
}