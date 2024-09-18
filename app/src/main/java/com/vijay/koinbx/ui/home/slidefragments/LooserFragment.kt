package com.vijay.koinbx.ui.home.slidefragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.vijay.koinbx.R
import com.vijay.koinbx.adapter.CoinsAdapter
import com.vijay.koinbx.adapter.LosersAdapter
import com.vijay.koinbx.databinding.FragmentLooserBinding
import com.vijay.koinbx.databinding.FragmentNewCurrencyBinding
import com.vijay.koinbx.repository.FirebaseRepository

class LooserFragment : Fragment() {

    companion object {
        fun newInstance() = LooserFragment()
    }

    private var _binding: FragmentLooserBinding? = null

    lateinit var userViewModel: LooserViewModel
    lateinit var repository: FirebaseRepository
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private lateinit var adapter: LosersAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLooserBinding.inflate(inflater, container, false)
        repository = FirebaseRepository()
        userViewModel = LooserViewModel(repository)
        userViewModel.loadCoins()
        val root: View = binding.root
        binding.recyclerview.layoutManager = LinearLayoutManager(requireContext())
        adapter = context?.let { LosersAdapter(it) }!!
        binding.recyclerview.adapter = adapter
        userViewModel.coins.observe(requireActivity()) {
            Log.e("TAG", "vijay: ${it.size} ", )
            adapter.submitList(it)
        }
        return root
    }

}