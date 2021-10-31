package kr.ac.smu.cs.soptandroid.home.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kr.ac.smu.cs.soptandroid.R

class HomeViewModel : ViewModel() {
    private val _isLinkClicked = MutableLiveData<Boolean>()
    val isLinkClicked: LiveData<Boolean>
        get() = _isLinkClicked

    fun LinkClicked() {
        _isLinkClicked.value = false
    }

    private val _isRepoClicked = MutableLiveData<Boolean>()
    val isRepoClicked: LiveData<Boolean>
        get() = _isRepoClicked

    fun RepoClicked() {
        _isRepoClicked.value = false
    }

    private val _isFollowerClicked = MutableLiveData<Boolean>()
    val isFollowerClicked: LiveData<Boolean>
        get() = _isFollowerClicked

    fun FollowerClicked() {
        _isFollowerClicked.value = false
    }

    val homeImage = R.drawable.polaface2
    val homeText = "이름 : 김우빈 \n 나이 : 27 \n MBTI : ESTP"
}