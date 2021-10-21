package kr.ac.smu.cs.soptandroid.signin.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SignInViewModel() : ViewModel() {
    var idText = MutableLiveData<String>()
    var pwdText = MutableLiveData<String>()

    private val _isLoginClicked = MutableLiveData<Boolean>()
    val isLoginClicked: LiveData<Boolean>
        get() = _isLoginClicked

    fun LoginClicked() {
        _isLoginClicked.value = false
    }

    private val _isSignUpClicked = MutableLiveData<Boolean>()
    val isSignUpClicked: LiveData<Boolean>
        get() = _isSignUpClicked

    fun SignUpClicked() {
        _isSignUpClicked.value = false
    }

}