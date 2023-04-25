package com.example.plantapplication

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.example.plantapplication.databinding.FragmentEditProfileBinding
import com.example.plantapplication.databinding.FragmentLogInAccountBinding
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


class EditProfileFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var sharedpreferences = this.activity?.getSharedPreferences("reg", Context.MODE_PRIVATE)
        var edit = sharedpreferences?.edit()
        var gson = Gson()
        var userList = mutableListOf<User>()
        var type = object : TypeToken<List<User>>() {}.type

        val binding = FragmentEditProfileBinding.inflate(inflater, container, false)
//        var userr = arguments?.getSerializable("user") as User
//        binding.emailEdp.text = userr.email
//        binding.passwordEdp.text= userr.password

        var shared = requireContext().getSharedPreferences("reg", Context.MODE_PRIVATE)
        var userJson = shared.getString("active_user", "")
        var person = gson.fromJson(userJson, User::class.java)


        binding.emailEdp.text = person.email
        binding.passwordEdp.text = person.password
//        binding.emailEdp.text=person.email
//        binding.passwordEdp.text=person.password
        binding.logoutt.setOnClickListener {
            var usersData = sharedpreferences?.getString("users", "")
            var pos = false

            if (usersData == "") {
                userList = gson.fromJson(usersData, type)
                for (i in userList) {
                    if (i.email == binding.emailEdp.text.toString() && i.password == binding.passwordEdp.text.toString()) {
                        pos = true

                        userList.remove(i)
                        val str = gson.toJson(userList)
                        edit?.putString("users", str)?.apply()

                        findNavController().navigate(R.id.action_editProfileFragment_to_createAccountFragment)
                    }
                }

            }

        }




        binding.editprofileNext.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_editProfButFragment)
        }




        return binding.root
    }


}