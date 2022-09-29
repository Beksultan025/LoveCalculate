package com.example.lovecalculator

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.lovecalculator.databinding.FragmentFirstBinding
import com.example.lovecalculator.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {

    private lateinit var binding: FragmentSecondBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        logic()
    }

    private fun logic() {
        val firstName = arguments?.getString("My")
        val secondName = arguments?.getString("My2")
        binding.firstTv.text = firstName.toString()
        binding.secondTv.text = secondName.toString()

        val result = arguments?.getString("key")
        binding.result.text = result.toString()
    }

}