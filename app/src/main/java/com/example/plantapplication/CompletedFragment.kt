package com.example.plantapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.example.plantapplication.databinding.FragmentCompletedBinding


class CompletedFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding=FragmentCompletedBinding.inflate(inflater,container,false)


        val sharedpreferenc = MyShared.getInstance(requireContext())

        val list = sharedpreferenc.getPlant()

        binding.completeRv.setHasFixedSize(true)

        var adapter = AdapterComplete(requireContext(),
            list, object :AdapterComplete.ActiveClickAc   {
                override fun itemclick(plant: Plant, img: ImageView) {
                    val bundle = bundleOf("plant" to plant)
//                val extras = FragmentNavigatorExtras(img to "img_big")
                    findNavController().navigate(
                        R.id.action_homeFragment_to_detailFragment,
                        bundle
                    )
                }
            })

        binding.completeRv.adapter = adapter
        return binding.root
    }


}