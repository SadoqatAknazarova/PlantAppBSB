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
import com.example.plantapplication.databinding.FragmentSplash3Binding


class Splash3Fragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = FragmentSplash3Binding.inflate(inflater,container,false)

        binding.button1.setOnClickListener {

        findNavController().navigate(R.id.action_splash3Fragment_to_splash4Fragment)
    }


        return binding.root
}


}