package kr.ac.smu.cs.soptandroid.signin.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.observe
import kr.ac.smu.cs.soptandroid.R
import kr.ac.smu.cs.soptandroid.signup.view.SignUpActivity
import kr.ac.smu.cs.soptandroid.databinding.ActivitySignInBinding
import kr.ac.smu.cs.soptandroid.home.view.HomeActivity
import kr.ac.smu.cs.soptandroid.signin.viewmodel.SignInViewModel
import kr.ac.smu.cs.soptandroid.util.BindingActivity

class SignInActivity : BindingActivity<ActivitySignInBinding>(R.layout.activity_sign_in) {

    private val signInViewModel: SignInViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.signInViewModel = signInViewModel
        binding.lifecycleOwner = this

        clickListener()
    }

    private fun clickListener() {
        signInViewModel.isLoginClicked.observe(this) { loginClickListener() }
        signInViewModel.isSignUpClicked.observe(this) { signUpClickListener() }
    }

    private fun loginClickListener() {
        if (signInViewModel.idText.value == null || signInViewModel.pwdText.value == null) {
            Toast.makeText(this, "입력하지 않은 정보가 있습니다", Toast.LENGTH_SHORT).show()
        } else {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }
    }

    private fun signUpClickListener() {
        val intent = Intent(this, SignUpActivity::class.java)
        startActivity(intent)
    }
}