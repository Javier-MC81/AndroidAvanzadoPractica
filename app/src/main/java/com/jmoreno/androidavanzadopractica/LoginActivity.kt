package com.jmoreno.androidavanzadopractica

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.jmoreno.androidavanzadopractica.databinding.ActivityLoginBinding
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import okhttp3.Credentials
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

@AndroidEntryPoint
class LoginActivity() : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    private val moshi = Moshi.Builder()
        .addLast(KotlinJsonAdapterFactory())
        .build()

    private val okHttpClient =
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor(HttpLoggingInterceptor.Logger.DEFAULT).apply {
                level = HttpLoggingInterceptor.Level.BODY
            }).build()

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://dragonball.keepcoding.education/")
        .client(okHttpClient)
        .addConverterFactory(MoshiConverterFactory.create(moshi).asLenient())
        .build()

    private val api: DragonBallLoginApi = retrofit.create(DragonBallLoginApi::class.java)
    private val remoteDataSource = RemoteDataSource(api)
    private val repository = Repository(remoteDataSource)
    //private val viewModel =  LoginViewModel(repository)
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