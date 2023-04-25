package com.example.plantapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.example.plantapplication.databinding.FragmentTrackBinding

class TrackFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding=FragmentTrackBinding.inflate(inflater,container,false)

binding.backTrack.setOnClickListener {

    findNavController().navigate(R.id.action_trackFragment_to_homeFragment)
//    loadfragment(OrderActiveFragment)
//    parentFragmentManager.beginTransaction()
//        .replace(R.id.main,OrderActiveFragment)
//        .commit()
}
        return binding.root
    }

}