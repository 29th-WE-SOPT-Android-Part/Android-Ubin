package kr.ac.smu.cs.soptandroid.home.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel(){
    private val _isLinkClicked= MutableLiveData<Boolean>()
    val isLinkClicked: LiveData<Boolean>
        get() = _isLinkClicked

    fun LinkClicked(){
        _isLinkClicked.value=false
    }
}