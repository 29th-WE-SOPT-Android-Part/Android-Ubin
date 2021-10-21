package kr.ac.smu.cs.soptandroid.signup.view

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kr.ac.smu.cs.soptandroid.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {

    lateinit var binding: ActivitySignUpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)

        binding.buttonSiginIn.setOnClickListener {
            if (binding.upEditId.text == null || binding.upEditName.text == null || binding.upEditPwd == null) {
                Toast.makeText(this, "입력하지 않은 정보가 있습니다", Toast.LENGTH_SHORT).show()
            } else {
                finish()
            }
        }
        setContentView(binding.root)
    }
}