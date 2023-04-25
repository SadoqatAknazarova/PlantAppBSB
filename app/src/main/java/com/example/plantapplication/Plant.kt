package com.example.plantapplication

import java.io.FileDescriptor

class Plant(var name:String, var img:Int, var price:Int, var rank:Double,var description:String, var fav:Boolean=false,var qt:Int=0) :java.io.Serializable{
}