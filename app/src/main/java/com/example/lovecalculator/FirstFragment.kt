package com.example.lovecalculator

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.lovecalculator.databinding.FragmentFirstBinding
import com.example.lovecalculator.model.App
import com.example.lovecalculator.model.LoveModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FirstFragment : Fragment() {

    lateinit var binding: FragmentFirstBinding
    private val viewModel: LoveViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initClicker()
    }

    private fun initClicker() {
        binding.btn.setOnClickListener {
            viewModel.getLoveModel(
                binding.firstEt.text.toString(),
                binding.secondEt.text.toString()
            ).observe(viewLifecycleOwner,
                Observer {
                    binding.btn.text = it.percentage
                })
            /*App.api.calculateLove(
                binding.firstEt.text.toString(),
                binding.secondEt.text.toString()
            ).enqueue(object : Callback<LoveModel> {
                override fun onResponse(call: Call<LoveModel>, response: Response<LoveModel>) {
                    if (response.isSuccessful && binding.firstEt.text.toString().isNotEmpty() && binding.secondEt.text.toString().isNotEmpty()) {
                        val log = response.body()?.percentage
                        val bundle = Bundle()
                        bundle.putString("My", binding.firstEt.text.toString())// PutName1
                        bundle.putString("My2", binding.secondEt.text.toString())// PutName2
                        bundle.putString("key",log)

                        findNavController().navigate(R.id.action_homeFragment_to_secondFragment , bundle)
                    }
        }


                override fun onFailure(call: Call<LoveModel>, t: Throwable) {

                    Log.e("lol", "onFailure: ${t.message}" )
                }

            })*/
        }
    }

}