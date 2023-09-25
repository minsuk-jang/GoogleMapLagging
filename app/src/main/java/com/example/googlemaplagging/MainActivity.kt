package com.example.googlemaplagging

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.googlemaplagging.base.BaseActivity
import com.example.googlemaplagging.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setMainFragment()

    }

    private fun setMainFragment() {
        supportFragmentManager.beginTransaction().apply {
            add(binding.frameLayout.id, MainFragment.newInstance())
        }.commit()
    }
}