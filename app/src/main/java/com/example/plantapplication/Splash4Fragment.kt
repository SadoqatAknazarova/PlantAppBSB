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
import com.example.plantapplication.databinding.FragmentSplash4Binding


class Splash4Fragment : Fragment() {




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentSplash4Binding.inflate(inflater,container,false)
        binding.button2.setOnClickListener {

                findNavController().navigate(R.id.action_splash4Fragment_to_splashStartFragment)
            }
        return binding.root


    }


}
