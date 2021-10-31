package kr.ac.smu.cs.soptandroid.home.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import kr.ac.smu.cs.soptandroid.R
import kr.ac.smu.cs.soptandroid.databinding.FragmentFollowerBinding
import kr.ac.smu.cs.soptandroid.databinding.FragmentRepositoryBinding
import kr.ac.smu.cs.soptandroid.home.adapter.FollowerAdapter
import kr.ac.smu.cs.soptandroid.home.model.FollowerData
import kr.ac.smu.cs.soptandroid.home.viewmodel.HomeViewModel
import kr.ac.smu.cs.soptandroid.util.BindingFragment

class FollowerFragment : BindingFragment<FragmentFollowerBinding>() {

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentFollowerBinding {
        return FragmentFollowerBinding.inflate(inflater, container, false)
    }

    private val homeViewModel:HomeViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.homeViewModel=homeViewModel
        binding.lifecycleOwner=this
        val followerAdapter=FollowerAdapter()
        setAdapter(followerAdapter)
    }

    private fun setAdapter(followerAdapter: FollowerAdapter) {
        val test=listOf(FollowerData("야옹","난 야옹이다옹")
            ,FollowerData("냐옹","난 냐옹이다옹")
            ,FollowerData("다옹","난 다옹이다옹")
            ,FollowerData("캬옹","난 캬옹이다옹")
        )
        binding.rcvFollower.apply {
            layoutManager = GridLayoutManager(requireContext(),2)
            adapter = followerAdapter
        }
        followerAdapter.submitList(test)

        followerAdapter.notifyDataSetChanged()
    }


}