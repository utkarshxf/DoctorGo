package com.example.orion.doctorgo.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.orion.doctorgo.model.listview
import com.example.orion.doctorgo.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class DoctorListViewModel : ViewModel() {

    private val myRepository = Repository()

    private val _myResponse : MutableLiveData<Response<listview>> = MutableLiveData()
    val myResponse : LiveData<Response<listview>>
        get() = _myResponse

    fun getCall(){
        viewModelScope.launch {
            val response = myRepository.getCall()
            _myResponse.value = response
        }
    }

}