package com.jmoreno.androidavanzadopractica.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.jmoreno.androidavanzadopractica.R
import com.jmoreno.androidavanzadopractica.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
@AndroidEntryPoint
class HeroesActivity : AppCompatActivity() {
    companion object {

        const val TAG_STRING = "TOKEN_STRING"
        const val TAG_NUM = "TAG_NUM"
        const val TAG_PERSONAJE = "TAG_PERSONAJE"

        fun launch(context: Context, text: String) {
            val intent = Intent(context, HeroesActivity::class.java)
            intent.putExtra(TAG_STRING, text)
            context.startActivity(intent)
        }
    }

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding
    private val viewModel: SuperheroViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        val token = intent.getStringExtra(TAG_STRING)

        /*lifecycleScope.launch {

        }*/
        lifecycleScope.launch {
            viewModel.getHeros(token)
            /*viewModel.token.collect(){
                when (it){
                    is LoginViewModel.UiState.OnTokenReceived ->
                        //binding.tvToken?.text = it.text
                        HeroesActivity.launch(this@LoginActivity,it.text)
                    // startActivity(HeroesActivity())
                    is LoginViewModel.UiState.Error -> binding.tvToken?.text = it.error
                    else -> Unit

                }
            }*/
        }

        val navController = findNavController(R.id.nav_host_fragment_content_main)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }
}