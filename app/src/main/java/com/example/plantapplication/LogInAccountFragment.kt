package com.example.plantapplication

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.example.plantapplication.databinding.FragmentLogInAccountBinding
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.net.UnknownServiceException


class LogInAccountFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val share = MySharedPreference.getInstance(requireContext())

//        share.setStatus(true)
        var sharedpreferences = this.activity?.getSharedPreferences("reg", Context.MODE_PRIVATE)
        var edit = sharedpreferences?.edit()
        var gson = Gson()
        var userList = mutableListOf<User>()
        var type = object : TypeToken<List<User>>() {}.type
        var binding = FragmentLogInAccountBinding.inflate(inflater, container, false)
        binding.signinnp.setOnClickListener {
            var usersData = sharedpreferences?.getString("users", "")
            var pos = false

            if (usersData == "") {
                Toast.makeText(this.activity, "Enter empty blanks!", Toast.LENGTH_SHORT).show()
            } else {
                userList = gson.fromJson(usersData, type)
                for (i in userList) {
                    if (i.email == binding.emailLoginn.text.toString() && i.password == binding.passwordLogin.text.toString()) {
                        pos = true

//                        var emaill=binding.emailLoginn.text.toString()
//                        var ph=binding.passwordLogin.text.toString()
                        val obj: User = i as User
                        break
                    } else {
                        pos = false
                    }
                }
                if (pos) {
                    var emaill = binding.emailLoginn.text.toString()
                    var ph = binding.passwordLogin.text.toString()

                    var user = User(emaill, ph)
                    var userJson = Gson().toJson(user)

                    var shared = requireContext().getSharedPreferences("reg", Context.MODE_PRIVATE)
                    shared.edit().putString("active_user", userJson).apply()

                    findNavController().navigate(R.id.action_logInAccountFragment_to_homeFragment,)
                } else {
                    Toast.makeText(this.activity, "You did not registered yet!", Toast.LENGTH_SHORT)
                        .show()
                }
            }
        }
        binding.signupText.setOnClickListener {

//                val extras = FragmentNavigatorExtras(img to "img_big")
            findNavController().navigate(R.id.action_logInAccountFragment_to_createAccountFragment)
        }
        binding.back.setOnClickListener {

            findNavController().navigate(R.id.action_logInAccountFragment_to_createAccountFragment)
        }
        return binding.root
    }

}