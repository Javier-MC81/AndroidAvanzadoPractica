package com.jmoreno.androidavanzadopractica

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.jmoreno.androidavanzadopractica.databinding.ActivityLoginBinding
import kotlinx.coroutines.launch
import okhttp3.Credentials



class LoginActivity : AppCompatActivity() {
    private val viewModel: LoginViewModel by viewModels()
    private lateinit var binding: ActivityLoginBinding
    private var token: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var token: String = ""
        binding.bLogin?.setOnClickListener {
            val user = binding.etUser?.text.toString()
            val password = binding.etPassword?.text.toString()
            val credential = Credentials.basic("jmorenocarrero@hotmail.com", "Realmadrid14")
            getPreferences((Context.MODE_PRIVATE)).edit().apply {
                putString("MiCredential", credential)
                apply()
            }
            lifecycleScope.launch {
                viewModel.getLogin(credential)
                viewModel.token.collect(){
                    when (it){
                        is LoginViewModel.UiState.OnTokenReceived ->
                            binding.tvToken?.text = it.text
                           // startActivity(HeroesActivity())
                        is LoginViewModel.UiState.Error -> binding.tvToken?.text = it.error
                        else -> Unit

                    }
                }
            }

        }
    }
}