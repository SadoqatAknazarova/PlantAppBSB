package com.example.plantapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.example.plantapplication.databinding.FragmentCheckoutBinding


class CheckoutFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding=FragmentCheckoutBinding.inflate(inflater,container,false)
        binding.continuePay.setOnClickListener {
            findNavController().navigate(R.id.action_checkoutFragment_to_payMethodFragment)
        }
        val sharedpreferenc = MySharedPreference.getInstance(requireContext())

        val list = sharedpreferenc.getPlant()
        binding.rvCheck.setHasFixedSize(true)
        var adapter = AdapterCheck(requireContext(),
            list, object : AdapterCheck.CartClick {
                override fun itemclick(plant: Plant, img: ImageView) {
                    val bundle = bundleOf("plant" to plant)
//                val extras = FragmentNavigatorExtras(img to "img_big")
//                    findNavController().navigate(
//                        R.id.action_homeFragment_to_detailFragment,
//                        bundle
//                    )
                }
            })

        binding.rvCheck.adapter = adapter


        return binding.root
    }


}