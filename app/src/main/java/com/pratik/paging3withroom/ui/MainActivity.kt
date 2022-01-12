package com.pratik.paging3withroom.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.pratik.paging3withroom.R
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.flow.collectLatest

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    lateinit var mainAdapter: MainAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initRecyclerView()
        initViewModel()
    }


    private fun initRecyclerView() {
        rvDataList.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            val decoration =
                DividerItemDecoration(applicationContext, DividerItemDecoration.VERTICAL)
            addItemDecoration(decoration)

            mainAdapter = MainAdapter()
            adapter = mainAdapter
        }
    }

    private fun initViewModel() {
        val viewModel = ViewModelProvider(this)[MainViewModel::class.java]


        lifecycleScope.launchWhenCreated {
            viewModel.getAllRecords().collectLatest {
                mainAdapter.submitData(it)
            }

        }

        viewModel.insertDummyData()
    }
}