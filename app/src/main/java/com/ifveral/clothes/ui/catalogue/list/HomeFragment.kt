package com.ifveral.clothes.ui.catalogue.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.ifveral.clothes.adapter.ProductListAdapter
import com.ifveral.clothes.databinding.FragmentDashboardBinding
import com.ifveral.clothes.databinding.FragmentHomeBinding
import com.ifveral.clothes.model.ProductListItem
import com.ifveral.clothes.ui.dashboard.DashboardViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root
        val productListAdapter = ProductListAdapter()
        binding.rvProductList.adapter = productListAdapter
        homeViewModel.result.observe(viewLifecycleOwner) {
            productListAdapter.submitList(it as List<ProductListItem>?)
        }

        val textView: TextView =  binding.textHome
        homeViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}