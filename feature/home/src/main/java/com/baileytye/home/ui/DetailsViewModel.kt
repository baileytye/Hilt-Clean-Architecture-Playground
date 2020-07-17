package com.baileytye.home.ui

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.baileytye.dataresource.model.Result
import com.baileytye.domain.interaction.GetStringUseCase

class DetailsViewModel @ViewModelInject constructor(
    @Assisted private val savedStateHandle: SavedStateHandle,
    private val getStringUseCase: GetStringUseCase
) : ViewModel() {

    val text = savedStateHandle.getLiveData<String>("string")

    val otherText = MutableLiveData<String>()

    val result: LiveData<Result<String>> = getStringUseCase().asLiveData()

    val isLoading = result.map { it is Result.Loading }
    val isError = result.map { it is Result.Error }
    val isSuccess = result.map { it is Result.Success }

    val string  = result.map {
        when {
            it is Result.Success -> {
                it.data
            }
            it is Result.Error && it.data != null -> {
                //There was an error, but data is present. Happens when showDataOnError = true
                it.data!!
            }
            else -> "Some default or null"
        }
    }

}