package kr.ac.smu.cs.soptandroid.util

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter

object BindingAdapters {
    @BindingAdapter("setHomeImage")
    @JvmStatic
    fun setHomeImage(imageView: ImageView,resource:Int){
        imageView.setImageResource(resource)
    }

}