package com.example.googlemaplagging.extensions

import android.util.Log
import androidx.fragment.app.Fragment
import com.example.googlemaplagging.TAG

fun Fragment.logging(name: String) {
    Log.e(
        TAG,
        "Name: $name\n" +
                "Activity: ${requireActivity().supportFragmentManager.fragments}\n" +
                "parent: ${parentFragmentManager.fragments}\n" +
                "child: ${childFragmentManager.fragments}",
    )
}