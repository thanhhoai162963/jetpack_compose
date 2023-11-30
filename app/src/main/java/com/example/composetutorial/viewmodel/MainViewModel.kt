package com.example.composetutorial.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composetutorial.model.User
import com.example.composetutorial.repo.UserRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel : ViewModel() {
    private val mData = mutableListOf<String>()
    private val mMutableStateFlow = MutableStateFlow<List<String>>(mData)
    private val mStateFlow: StateFlow<List<String>> = mMutableStateFlow

    private val mMutableStateFlow1: MutableStateFlow<User> = MutableStateFlow(User())
    private val mStateFlow1: StateFlow<User> = mMutableStateFlow1

    init {
        setData()
    }

    fun getSingleUser(id: Int?) {
        viewModelScope.launch(Dispatchers.IO) {
            val res = UserRepository.singleUser(id)
            withContext(Dispatchers.Main) {
                if (res?.isSuccessful == true) {
                    async {

                    }
                    mMutableStateFlow1.value = res.body()!!

                } else {

                }
            }
        }
    }

    fun getData123() = mStateFlow1

    private fun setData() {
        viewModelScope.launch {
            CoroutineScope(Dispatchers.Default).launch {
                for (i in 1..40) {
                    mData.add("$i")
                }
                mMutableStateFlow.value = mData
                Log.d("bbb", Thread.currentThread().toString())
            }
        }
    }

    fun getData(): StateFlow<List<String>> {
        return mStateFlow
    }
}