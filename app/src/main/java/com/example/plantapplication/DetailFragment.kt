package com.example.plantapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.plantapplication.databinding.FragmentDetailBinding

//private var plantPrice: MutableList<Int>()
class DetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding = FragmentDetailBinding.inflate(inflater, container, false)
        val plant = arguments?.getSerializable("plant") as Plant

        val sharedPreference=MySharedPreference.getInstance(requireContext())
        binding.img.setImageResource(plant.img)
        var position=false
        binding.nameDetail.text = plant.name
        binding.descriptionText.text = plant.description
        binding.rank.text = plant.rank.toString()
        var count=0
        binding.plusBut.setOnClickListener {
           count++
            binding.resultBut.text=count.toString()
            plant.qt=count
            binding.totalPriceCart.text= (count*plant.price).toString()
        }

        binding.minusBut.setOnClickListener {
            if (count>0){
            count--
            binding.resultBut.text=count.toString()
                plant.qt=count
            binding.totalPriceCart.text= (count*plant.price).toString()
        }}

binding.favdetail.setOnClickListener {
    if (!position) {
        binding.favdetail.setImageResource(R.drawable.green_favorite_24)
        position = true
    } else {
        binding.favdetail.setImageResource(R.drawable.baseline_favorite_border_24)
        position = false
    }

}
        binding.backdetail.setOnClickListener {
            findNavController().navigate(R.id.action_detailFragment_to_homeFragment)
        }
        binding.addToCart.setOnClickListener {
            if (count>0){
                sharedPreference.addPlant(plant)
            Toast.makeText(this.activity, "Added to cart", Toast.LENGTH_SHORT).show()
            binding.resultBut.text=0.toString()
            binding.totalPriceCart.text= 0.toString()
        }
        else{
                Toast.makeText(this.activity, "Error", Toast.LENGTH_SHORT).show()
        }}
        return binding.root
    }
}