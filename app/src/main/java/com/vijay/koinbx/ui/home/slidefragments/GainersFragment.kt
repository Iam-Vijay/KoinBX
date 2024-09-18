package com.vijay.koinbx.ui.home.slidefragments

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage
import com.vijay.koinbx.R
import com.vijay.koinbx.adapter.GainersAdapter
import com.vijay.koinbx.adapter.LosersAdapter
import com.vijay.koinbx.databinding.FragmentGainersBinding
import com.vijay.koinbx.databinding.FragmentHomeBinding
import com.vijay.koinbx.pojo.Coin
import com.vijay.koinbx.repository.FirebaseRepository

class GainersFragment : Fragment() {

    companion object {
        fun newInstance() = GainersFragment()
    }

    private var _binding: FragmentGainersBinding? = null

    lateinit var userViewModel: LooserViewModel
    lateinit var repository: FirebaseRepository
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private lateinit var adapter: GainersAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGainersBinding.inflate(inflater, container, false)
        repository = FirebaseRepository()
        userViewModel = LooserViewModel(repository)
        userViewModel.loadCoins()
        val root: View = binding.root
        binding.recyclerview.layoutManager = LinearLayoutManager(requireContext())
        adapter = context?.let { GainersAdapter(it) }!!
        binding.recyclerview.adapter = adapter
        userViewModel.coins.observe(requireActivity()) {
            Log.e("TAG", "vijay: ${it.size} ", )
            adapter.submitList(it)
        }
        return root

    }



}