package com.jmoreno.androidavanzadopractica.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.jmoreno.androidavanzadopractica.ui.LoginViewModel
import com.jmoreno.androidavanzadopractica.R
import com.jmoreno.androidavanzadopractica.databinding.ActivityLoginBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import okhttp3.Credentials

@AndroidEntryPoint
class LoginActivity() : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    private val viewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bLogin?.setOnClickListener {
            val user = binding.etUser?.text.toString()
            val password = binding.etPassword?.text.toString()
            val credential = Credentials.basic("jmorenocarrero@hotmail.com", "Realmadrid14")

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