package com.e.ramapp.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.e.ramapp.R
import com.e.ramapp.data.dto.AllCharactersDto
import com.e.ramapp.data.repos.RaMRepo
import com.e.ramapp.helpers.recyclerview.RecyclerViewAdaptor
import com.e.ramapp.viewholders.DisplayTypeUnspecifiedModel
import kotlinx.android.synthetic.main.fr_characters.*
import kotlinx.coroutines.launch

class CharactersScreenViewModel : ViewModel() {
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


class CharactersScreen : Fragment() {

    private val viewModel: CharactersScreenViewModel by activityViewModels()

    val adaptor = RecyclerViewAdaptor()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fr_characters, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        recycler.adapter = adaptor
        viewModel.getData { data->
            adaptor.submitList(data.results.map { DisplayTypeUnspecifiedModel(it) })
        }
    }
}