package com.example.victormanuel.gourmertapp.util

import android.databinding.BindingAdapter
import android.net.Uri
import android.widget.ImageView
import com.squareup.picasso.Picasso


@BindingAdapter("app:imgUrl")
fun setImageUrl(img:ImageView, url:String){
    Picasso.with(img.context)
            .load(Uri.parse(url))
            .into(img)
}