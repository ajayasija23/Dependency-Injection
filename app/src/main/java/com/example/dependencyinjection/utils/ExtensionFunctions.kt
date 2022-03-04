package com.example.dependencyinjection.utils

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.load(url:String,mContext:Context){
    Glide.with(mContext).load(url).into(this)
}