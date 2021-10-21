package kr.ac.smu.cs.soptandroid.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import kr.ac.smu.cs.soptandroid.R
import kr.ac.smu.cs.soptandroid.databinding.ItemFollowerBinding
import kr.ac.smu.cs.soptandroid.databinding.ItemRepositoryBinding
import kr.ac.smu.cs.soptandroid.home.model.FollowerData
import kr.ac.smu.cs.soptandroid.home.model.RepositoryData

class RepositoryAdapter() :
    ListAdapter<RepositoryData, RepositoryAdapter.RepositoryViewHolder>(RepositoryDiffUtil()) {

    class RepositoryViewHolder(private val binding: ItemRepositoryBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(repository: RepositoryData) {
            binding.repository = repository
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepositoryViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ItemRepositoryBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.item_repository, parent, false)
        return RepositoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RepositoryViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    private class RepositoryDiffUtil : DiffUtil.ItemCallback<RepositoryData>() {
        override fun areItemsTheSame(
            oldItem: RepositoryData,
            newItem: RepositoryData
        ) =
            (oldItem.information == newItem.information)

        override fun areContentsTheSame(
            oldItem: RepositoryData,
            newItem: RepositoryData
        ) =
            (oldItem == newItem)
    }

}