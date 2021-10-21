package kr.ac.smu.cs.soptandroid.signup.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SignUpViewModel: ViewModel() {
    var nameText = MutableLiveData<String>()
    var idText = MutableLiveData<String>()
    var pwdText = MutableLiveData<String>()

    private val _isCompleteClicked = MutableLiveData<Boolean>()
    val isCompleteClicked: LiveData<Boolean>
        get() = _isCompleteClicked

    fun SignUpCompleteClicked() {
        _isCompleteClicked.value = false
    }
}