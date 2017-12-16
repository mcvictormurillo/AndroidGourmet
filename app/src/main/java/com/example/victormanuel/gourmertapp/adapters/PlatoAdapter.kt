package com.example.victormanuel.gourmertapp.adapters

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.example.victormanuel.gourmertapp.R
import com.example.victormanuel.gourmertapp.databinding.TemplatePlatosBinding
import com.example.victormanuel.gourmertapp.models.Plato
import com.example.victormanuel.gourmertapp.util.inflate

/**
 * Created by Victor Manuel on 15/12/2017.
 */
class PlatoAdapter: RecyclerView.Adapter<PlatoViewHolder>(){

    var data: List<Plato> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlatoViewHolder =
            PlatoViewHolder(parent.inflate(R.layout.template_platos))

    override fun onBindViewHolder(holder: PlatoViewHolder, position: Int) {
        holder.binding.plato = data[position]
    }

    override fun getItemCount(): Int = data.size

}


class PlatoViewHolder(view: View): RecyclerView.ViewHolder(view){
    val binding: TemplatePlatosBinding = DataBindingUtil.bind(view)

}