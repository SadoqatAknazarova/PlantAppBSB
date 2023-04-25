package com.example.plantapplication

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController

import com.example.plantapplication.databinding.FragmentSplash2Binding


class Splash2Fragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentSplash2Binding.inflate(inflater,container,false)

        val handler= Handler(Looper.getMainLooper())
        handler.postDelayed({
            findNavController().navigate(R.id.action_splash2Fragment_to_splash3Fragment)
        },2000)
        return binding.root
    }
}


