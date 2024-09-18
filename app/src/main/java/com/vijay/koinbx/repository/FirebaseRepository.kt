package com.vijay.koinbx.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.vijay.koinbx.pojo.Coin
import javax.inject.Inject

class FirebaseRepository @Inject constructor() {

    private val database = FirebaseDatabase.getInstance().getReference("coins")

    // Function to fetch list of users from Firebase
    fun fetchCoins(onDataChanged: (List<Coin>) -> Unit, onError: (Exception) -> Unit) {
        database.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val pairList = mutableListOf<Coin>()
                for (dataSnapshot in snapshot.children) {
                    val user = dataSnapshot.getValue(Coin::class.java)
                    user?.let { pairList.add(it) }
                }
                onDataChanged(pairList)
            }

            override fun onCancelled(error: DatabaseError) {
                onError(error.toException())
            }
        })
    }
}