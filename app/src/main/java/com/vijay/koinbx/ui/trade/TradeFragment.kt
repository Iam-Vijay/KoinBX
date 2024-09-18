package com.vijay.koinbx.ui.trade

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.vijay.koinbx.R

class TradeFragment : Fragment() {

    companion object {
        fun newInstance() = TradeFragment()
    }

    private lateinit var viewModel: TradeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_trade, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(TradeViewModel::class.java)
        // TODO: Use the ViewModel
    }

}