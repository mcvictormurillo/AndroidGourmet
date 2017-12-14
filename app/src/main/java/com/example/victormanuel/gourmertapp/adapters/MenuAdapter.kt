package com.example.victormanuel.gourmertapp.adapters

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.example.victormanuel.gourmertapp.R
import com.example.victormanuel.gourmertapp.databinding.TemplateMenuBinding
import com.example.victormanuel.gourmertapp.models.Menu
import com.example.victormanuel.gourmertapp.util.inflate


class MenuAdapter(val callback:(pos:Int)->Unit) : RecyclerView.Adapter<MenuViewHolder>(){

    var data: List<Menu> = emptyList()
        set(value) {
            field=value
            notifyDataSetChanged()
        }
    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        holder.binding.menu = data[position]
        holder.binding.root.tag = position
        holder.binding.handler = this
    }

    fun onMenuClick(pos:Int){
    callback(pos)
    }


    override fun getItemCount(): Int = data.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder
    = MenuViewHolder(parent.inflate(R.layout.template_menu))



}



class MenuViewHolder(view: View): RecyclerView.ViewHolder(view){
    val binding:TemplateMenuBinding = DataBindingUtil.bind(view)


}