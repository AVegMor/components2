package com.example.components2

data class CheckInfo(val title:String, var selected:Boolean, var onCheckedChange:(Boolean) -> Unit) {

}