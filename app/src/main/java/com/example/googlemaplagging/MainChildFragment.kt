package com.example.googlemaplagging

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.googlemaplagging.adapter.TestAdapter
import com.example.googlemaplagging.base.BaseFragment
import com.example.googlemaplagging.databinding.FragmentChildBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainChildFragment : BaseFragment<FragmentChildBinding>(R.layout.fragment_child) {

    @Inject
    lateinit var adapter: TestAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bindRecyclerView()
        setData()
    }

    private fun bindRecyclerView() {
        with(binding) {
            recyclerView.adapter = adapter
            recyclerView.layoutManager = LinearLayoutManager(requireContext())
        }
    }

    private fun setData() {
        adapter.submitList(buildList {
            repeat(100) {
                add("${it + 1}")
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.e(TAG, "[Child] onDestroyView: ")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e(TAG, "[Child] onDestroy: ")
    }
}