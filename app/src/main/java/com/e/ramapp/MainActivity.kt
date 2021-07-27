package com.e.ramapp

import android.os.ProxyFileDescriptorCallback
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.e.ramapp.data.dto.AllCharactersDto
import com.e.ramapp.data.repos.RaMRepo
import kotlinx.coroutines.launch
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.fragment.app.activityViewModels
import com.e.ramapp.helpers.recyclerview.RecyclerViewAdaptor
import com.e.ramapp.viewholders.DisplayTypeUnspecifiedModel
import kotlinx.android.synthetic.main.activity_main.*

class MyViewModel : ViewModel() {
    fun getData(callback: (AllCharactersDto)-> Unit) {
        viewModelScope.launch {
            kotlin.runCatching {
                RaMRepo().getAllCharacters()
            }.onSuccess {
                callback(it)
            }.onFailure {
            }
        }
    }
}

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adaptor = RecyclerViewAdaptor()
        recycler.adapter = adaptor

        val viewModel = ViewModelProvider(this).get(MyViewModel::class.java)
        viewModel.getData {
            adaptor.submitList(it.results.map {data->
                DisplayTypeUnspecifiedModel(
                    data
                )
            })
        }
    }

}