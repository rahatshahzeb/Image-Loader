package com.android.assignment.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.android.assignment.R
import com.android.assignment.databinding.ActivityMainBinding
import com.android.assignment.model.Image
import com.android.assignment.ui.fragment.BoardFragment
import com.android.assignment.util.AssignmentConstants.TAG_FRAGMENT_BOARD
import com.android.assignment.util.replaceFragment
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

class MainActivity : AppCompatActivity(), HasSupportFragmentInjector, BoardFragment.BoardCallback {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>

    override fun supportFragmentInjector() = dispatchingAndroidInjector

    private lateinit var binding: ActivityMainBinding

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val vm: MainViewModel by lazy {
        ViewModelProviders.of(this, viewModelFactory).get(MainViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        vm.getImages()

        vm.imagesMLD.observe(this, Observer {
            if (!it.isNullOrEmpty()) {
                replaceFragment(
                    BoardFragment.newInstance(it as ArrayList<out Image>),
                    R.id.fragmentHost,
                    TAG_FRAGMENT_BOARD,
                    false)
            }

        })
    }

    override fun showImage(view: View, image: Image) {
        // Handle event
    }
}
