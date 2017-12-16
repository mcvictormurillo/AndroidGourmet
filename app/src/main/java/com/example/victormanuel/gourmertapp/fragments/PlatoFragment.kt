package com.example.victormanuel.gourmertapp.fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.victormanuel.gourmertapp.R

import com.example.victormanuel.gourmertapp.adapters.PlatoAdapter
import com.example.victormanuel.gourmertapp.util.DataPlato
import kotlinx.android.synthetic.main.fragment_plato.*


class PlatoFragment : Fragment() {

    val adapter: PlatoAdapter = PlatoAdapter()


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_plato, container, false)
    }

    override fun onResume() {
        super.onResume()
        list.adapter = adapter
        list.layoutManager = LinearLayoutManager(activity)
        adapter.data= DataPlato.platos

    }

    companion object {
        fun instance(): PlatoFragment = PlatoFragment()
    }
}
