package com.example.victormanuel.gourmertapp.adapters
import android.content.Context

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.victormanuel.gourmertapp.R
import com.example.victormanuel.gourmertapp.models.User

/**
 * Created by Victor Manuel on 14/12/2017.
 */
class UserAdapter( val mCtx: Context, val layoutResId:Int,  val userList: List<User>):
        ArrayAdapter<User>(mCtx,layoutResId,userList){

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val layoutInflater: LayoutInflater = LayoutInflater.from(mCtx)
        val view: View = layoutInflater.inflate(layoutResId,null)
        val textViewUser = view.findViewById<TextView>(R.id.textViewUser)
        val user = userList[position]
        textViewUser.text = user.identificacion
        return view

    }

}