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
    private val homeViewModel: HomeViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.homeViewModel = homeViewModel
        binding.lifecycleOwner = this
        clickListener()
        initTransactionEvent()
    }

    private fun clickListener() {
        homeViewModel.isLinkClicked.observe(this) { clickGithubLinkListener() }
        homeViewModel.isFollowerClicked.observe(this) { showFollower() }
        homeViewModel.isRepoClicked.observe(this) { showRepository() }
    }

    private fun clickGithubLinkListener() {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/ub1n/"))
        startActivity(intent)
    }

    private fun showRepository() {
        supportFragmentManager.beginTransaction().replace(R.id.container_main, RepositoryFragment())
            .commit()
    }

    private fun showFollower() {
        supportFragmentManager.beginTransaction().replace(R.id.container_main, FollowerFragment())
            .commit()
    }

    private fun initTransactionEvent() {
        val fragment1 = FollowerFragment()
        val fragment2 = RepositoryFragment()

        supportFragmentManager.beginTransaction().add(R.id.container_main, fragment1).commit()
    }
}