package kr.ac.smu.cs.soptandroid.home.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import kr.ac.smu.cs.soptandroid.R
import kr.ac.smu.cs.soptandroid.databinding.FragmentRepositoryBinding
import kr.ac.smu.cs.soptandroid.home.adapter.FollowerAdapter
import kr.ac.smu.cs.soptandroid.home.adapter.RepositoryAdapter
import kr.ac.smu.cs.soptandroid.home.model.FollowerData
import kr.ac.smu.cs.soptandroid.home.model.RepositoryData
import kr.ac.smu.cs.soptandroid.home.viewmodel.HomeViewModel
import kr.ac.smu.cs.soptandroid.util.BindingFragment


class RepositoryFragment : BindingFragment<FragmentRepositoryBinding>() {

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentRepositoryBinding {
        return FragmentRepositoryBinding.inflate(inflater, container, false)
    }

    private val homeViewModel:HomeViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.homeViewModel=homeViewModel
        binding.lifecycleOwner=this
        val repositoryAdapter=RepositoryAdapter()
        setAdapter(repositoryAdapter)
    }

    private fun setAdapter(repositoryAdapter: RepositoryAdapter) {
        val test = listOf(
            RepositoryData("야옹이들 레포지토리", "난 야옹이 레포지토리다옹")
            , RepositoryData("냐옹냥 레포지토리", "난 냐옹이 레포지토리다옹")
            , RepositoryData("다옹쿤 레포지토리", "난 다옹이 레포지토리다옹")
            , RepositoryData("캬옹쓰 레포지토리", "난 캬옹이 레포지토리다옹")
        )
        binding.rcvRepository.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = repositoryAdapter
        }
        repositoryAdapter.submitList(test)

    }


}

