package kr.ac.smu.cs.soptandroid.home.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import kr.ac.smu.cs.soptandroid.R
import kr.ac.smu.cs.soptandroid.databinding.ItemFollowerBinding
import kr.ac.smu.cs.soptandroid.home.model.FollowerData
import kr.ac.smu.cs.soptandroid.home.viewmodel.HomeViewModel

class FollowerAdapter() :
    ListAdapter<FollowerData, FollowerAdapter.FollowerViewHolder>(FollowerDiffUtil()) {

    class FollowerViewHolder(private val binding: ItemFollowerBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(follower: FollowerData) {
            binding.follower = follower
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FollowerViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ItemFollowerBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.item_follower, parent, false)
        return FollowerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FollowerViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    private class FollowerDiffUtil : DiffUtil.ItemCallback<FollowerData>() {
        override fun areItemsTheSame(
            oldItem: FollowerData,
            newItem: FollowerData
        ) =
            (oldItem.information == newItem.information)

        override fun areContentsTheSame(
            oldItem: FollowerData,
            newItem: FollowerData
        ) =
            (oldItem == newItem)
    }

}