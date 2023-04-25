package com.example.plantapplication

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.plantapplication.databinding.FragmentPayMethodBinding


class PayMethodFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = FragmentPayMethodBinding.inflate(inflater, container, false)
        val sharedpreferenc = MySharedPreference.getInstance(requireContext())
        val shared = MyShared.getInstance(requireContext())
//        val sharedPrefs =
//            context?.getSharedPreferences(sharedpreferenc.toString(), Context.MODE_PRIVATE) //
//        val editor = sharedPrefs?.edit()


        binding.confirmpay.setOnClickListener {
            if (binding.radio1.isChecked || binding.radio2.isChecked || binding.radio3.isChecked || binding.radio4.isChecked || binding.radio5.isChecked) {
                val binding1 = layoutInflater.inflate(R.layout.dialog_pay, container, false)
                val myDialog = Dialog(requireContext())
                myDialog.setContentView(binding1)
                myDialog.setCancelable(true)
                myDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
                var list = sharedpreferenc.getPlant()

                sharedpreferenc.clearLIst()
                myDialog.show()


                val handler = Handler(Looper.getMainLooper())
                handler.postDelayed({
                    myDialog.cancel()
               sharedpreferenc.addOrder(list)
//                    var  list=shared.getOrder()
//                   list=sharedpreferenc.getPlant()
//                    list.clear()
//                    sharedpreferenc.getPlant()=list
                    findNavController().navigate(R.id.action_payMethodFragment_to_homeFragment)

                }, 2000)
            }
        }


        return binding.root
    }


}