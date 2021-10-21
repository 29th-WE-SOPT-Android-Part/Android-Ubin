package kr.ac.smu.cs.soptandroid.home.view

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.observe
import kr.ac.smu.cs.soptandroid.R
import kr.ac.smu.cs.soptandroid.databinding.ActivityHomeBinding
import kr.ac.smu.cs.soptandroid.home.viewmodel.HomeViewModel
import kr.ac.smu.cs.soptandroid.util.BindingActivity


class HomeActivity : BindingActivity<ActivityHomeBinding>(R.layout.activity_home) {
    private val homeViewModel:HomeViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.homeViewModel=homeViewModel
        binding.lifecycleOwner=this
        clickListener()
    }

    private fun clickListener(){
        homeViewModel.isLinkClicked.observe(this){clickGithubLinkListener()}
    }

    private fun clickGithubLinkListener(){
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/ub1n/"))
        startActivity(intent)
    }
}