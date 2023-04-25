package com.example.plantapplication

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.plantapplication.databinding.FragmentSplash1Binding


class Splash1Fragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding =FragmentSplash1Binding.inflate(inflater,container,false)
        val mySharedPreference=MySharedPreference.getInstance(requireContext())
      //  val handler= Handler(Looper.getMainLooper())
        Handler(Looper.getMainLooper()).postDelayed({
//            if (mySharedPreference.getStatus()){
//            findNavController().navigate(R.id.action_splash1Fragment_to_homeFragment)
//        }
//        else{

            findNavController().navigate(R.id.action_splash1Fragment_to_splash2Fragment)
//     }
             },2000)
        return binding.root
    }
    }

