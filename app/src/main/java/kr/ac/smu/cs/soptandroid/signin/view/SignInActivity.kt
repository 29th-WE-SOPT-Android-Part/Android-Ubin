package kr.ac.smu.cs.soptandroid.signin.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
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
    private lateinit var activityResultLauncher:ActivityResultLauncher<Intent>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.signInViewModel = signInViewModel
        binding.lifecycleOwner = this
        activityResultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (it.resultCode == RESULT_OK) {
                val id=it.data?.getStringExtra("id")
                signInViewModel.idText.value=id
                signInViewModel.pwdText.value=it.data?.getStringExtra("pwd")
            }
        }

        clickListener()
    }

    private fun clickListener() {
        signInViewModel.isLoginClicked.observe(this) { moveHomeActivity() }
        signInViewModel.isSignUpClicked.observe(this) { moveSignUpActivity() }
    }

    private fun moveHomeActivity() {
        if (signInViewModel.idText.value == null || signInViewModel.pwdText.value == null) {
            Toast.makeText(this, "입력하지 않은 정보가 있습니다", Toast.LENGTH_SHORT).show()
        } else {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }
    }

    private fun moveSignUpActivity() {
        val intent = Intent(this, SignUpActivity::class.java)

        activityResultLauncher.launch(intent)

    }
}