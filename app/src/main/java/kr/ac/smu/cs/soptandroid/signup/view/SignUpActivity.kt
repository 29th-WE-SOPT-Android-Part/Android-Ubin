package kr.ac.smu.cs.soptandroid.signup.view

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.observe
import kr.ac.smu.cs.soptandroid.R
import kr.ac.smu.cs.soptandroid.databinding.ActivitySignUpBinding
import kr.ac.smu.cs.soptandroid.signup.viewmodel.SignUpViewModel
import kr.ac.smu.cs.soptandroid.util.BindingActivity

class SignUpActivity : BindingActivity<ActivitySignUpBinding>(R.layout.activity_sign_up) {

    private val signUpViewModel: SignUpViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.signUpViewModel = signUpViewModel
        binding.lifecycleOwner = this
        clickListener()
    }

    private fun clickListener() {
        signUpViewModel.isCompleteClicked.observe(this) { SignUpComplete() }
    }

    private fun SignUpComplete() {
        if (signUpViewModel.idText.toString() == null || signUpViewModel.pwdText.value == null || signUpViewModel.nameText.value == null) {
            Toast.makeText(this, "입력하지 않은 정보가 있습니다", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, signUpViewModel.nameText.value!!, Toast.LENGTH_SHORT).show()
            finish()
        }
    }
}