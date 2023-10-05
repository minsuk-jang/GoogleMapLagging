package com.example.googlemaplagging

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import com.example.googlemaplagging.base.BaseActivity
import com.example.googlemaplagging.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        bindMainFragment()
        //timer()
    }

    private fun bindMainFragment() {
        supportFragmentManager.beginTransaction().apply {
            add(binding.frameLayout.id, MainFragment.newInstance())
        }.commit()
    }

    private fun timer() {
        lifecycleScope.launch {
            while (true) {
                delay(1000L)
                Log.e(TAG, "Attach: ${supportFragmentManager.fragments}")
            }
        }
    }
}