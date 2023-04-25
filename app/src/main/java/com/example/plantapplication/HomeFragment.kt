package com.example.plantapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.plantapplication.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding=FragmentHomeBinding.inflate(inflater,container,false)

loadfragment(ActionFragment())
        binding.navBottom.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.home -> {
                    loadfragment(ActionFragment())
                    true
                }
                R.id.cart -> {
                    loadfragment(MyCartFragment())
                    true
                }
                R.id.order -> {
                    loadfragment(OrderFragment())
                    true
                }
                R.id.profile -> {
                    loadfragment(EditProfileFragment())
                    true
                }
                else -> {
                    false
                }
            }

        }

        return binding.root
    }
    private  fun loadfragment(fragment: Fragment){
        parentFragmentManager.beginTransaction()
            .replace(R.id.main,fragment)
            .commit()
    }

}