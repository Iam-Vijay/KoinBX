package com.vijay.koinbx.ui.home.slidefragments

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.vijay.koinbx.pojo.Coin
import com.vijay.koinbx.repository.FirebaseRepository
import javax.inject.Inject

class NewCurrencyViewModel @Inject constructor(private val repository: FirebaseRepository) : ViewModel() {
    private val _coins = MutableLiveData<List<Coin>>()
    val coins: LiveData<List<Coin>> get() = _coins

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> get() = _error

    // Function to load users from repository
    fun loadCoins() {
        repository.fetchCoins(
            onDataChanged = { pairList ->
                _coins.value = pairList
            },
            onError = { exception ->
                _error.value = exception.message
            }
        )
    }

}