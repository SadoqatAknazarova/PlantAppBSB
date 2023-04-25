package com.example.plantapplication

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.plantapplication.databinding.FragmentCreateAccountBinding
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class CreateAccountFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        // Inflate the layout for this fragment

        var sharedpreferences= this.activity?.getSharedPreferences("reg", Context.MODE_PRIVATE)
        var edit = sharedpreferences?.edit()
        var gson = Gson()
        var userList = mutableListOf<User>()
        var type = object : TypeToken<List<User>>() {}.type
        val binding=FragmentCreateAccountBinding.inflate(inflater,container,false)
        binding.signupp.setOnClickListener {
            var usersData=sharedpreferences?.getString("users","")
            var pos=false

            if(usersData==""){
                userList= mutableListOf()
                userList.add(User(binding.editTextTextEmailAddress.text.toString(),binding.editTextTextPassword.text.toString()))
                Toast.makeText(this.activity,"Succesfully registered", Toast.LENGTH_SHORT).show()
                val string=gson.toJson(userList)
                edit?.putString("users",string)?.commit()
            }else{
                userList = gson.fromJson(usersData,type)
                for( i in userList){
                    if(i.email!=binding.editTextTextEmailAddress.text.toString() && i.password!=binding.editTextTextPassword.text.toString()){
                        pos=true
                    }
                    else{
                        pos=false
                        break
                    }

                }
                if(pos==true){
                    userList.add(User(binding.editTextTextEmailAddress.text.toString(),binding.editTextTextPassword.text.toString()))
                    Toast.makeText(activity,"Succesfully registered", Toast.LENGTH_SHORT).show()
                    val str = gson.toJson(userList)
                    edit?.putString("users", str)?.commit()
                    findNavController().navigate(R.id.action_createAccountFragment_to_profileFragment)
                }
                else{
                    Toast.makeText(activity,"Change inputs!", Toast.LENGTH_SHORT).show()
                }
            }
        }
        binding.signinText.setOnClickListener {
            findNavController().navigate(R.id.action_createAccountFragment_to_logInAccountFragment)
        }
        binding.back1.setOnClickListener {
            findNavController().navigate(R.id.action_createAccountFragment_to_letsFragment)
        }
        return binding.root
    }


}