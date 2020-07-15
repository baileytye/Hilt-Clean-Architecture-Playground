package com.baileytye.hiltplayground.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.baileytye.hiltplayground.databinding.FragmentHomeBinding
import com.baileytye.hiltplayground.model.EventObserver
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private val viewModel: HomeViewModel by viewModels()
    private lateinit var binding : FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        subscribeObservers()
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        binding.viewModel = viewModel
        binding.lifecycleOwner =  viewLifecycleOwner

        return binding.root
    }

    private fun subscribeObservers() {
        viewModel.buttonClicked.observe(viewLifecycleOwner, EventObserver {
            var someValue = "A string that was sent between"
            findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToDetailsFragment(someValue))
            someValue = "changed"
        })
    }

}