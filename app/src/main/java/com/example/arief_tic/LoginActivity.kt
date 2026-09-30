package com.example.arief_tic

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.arief_tic.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

//        val btnLogin: Button =findViewById(R.id.btn_login);
//        val username: TextInputLayout =findViewById(R.id.edtUsername);
//        val password: TextInputLayout =findViewById(R.id.edtPassword);

        binding.btnLogin.setOnClickListener {
            val tampungUser = binding.edtUsername.editText?.text.toString()
            val tampungPassword = binding.edtPassword.editText?.text.toString()

            val intent = Intent(this@LoginActivity, MainActivity::class.java)
            intent.putExtra("nama", "Arief")
            intent.putExtra("umur", 20)

            startActivity(intent)

            Log.d("Username", tampungUser)
            Log.d("Password", tampungPassword)

            Toast.makeText(this, "Username: $tampungUser Password: $tampungPassword", Toast.LENGTH_LONG).show()
        }
    }
}