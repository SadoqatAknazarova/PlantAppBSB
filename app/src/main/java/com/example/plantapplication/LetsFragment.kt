package com.example.plantapplication

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.plantapplication.databinding.FragmentLetsBinding


class LetsFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
      val binding=FragmentLetsBinding.inflate(inflater,container,false)

        binding.buttonSignIn.setOnClickListener {
            findNavController().navigate(R.id.action_letsFragment_to_logInAccountFragment)
        }
        binding.signup.setOnClickListener {
            findNavController().navigate(R.id.action_letsFragment_to_createAccountFragment)
        }
        return binding.root
    }

}