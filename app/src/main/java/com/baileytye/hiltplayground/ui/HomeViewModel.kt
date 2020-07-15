package com.baileytye.hiltplayground.ui

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.baileytye.hiltplayground.model.Event

class HomeViewModel @ViewModelInject constructor(
    @Assisted private val savedStateHandle: SavedStateHandle
): ViewModel() {
    
    private val _buttonClicked = MutableLiveData<Event<Boolean>>()
    val buttonClicked : LiveData<Event<Boolean>> get() = _buttonClicked
    
    fun onButtonClicked(){
        _buttonClicked.value = Event(true)
    }
}