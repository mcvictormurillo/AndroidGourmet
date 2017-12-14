package com.example.victormanuel.gourmertapp.fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.victormanuel.gourmertapp.DetailActivity
import com.example.victormanuel.gourmertapp.adapters.MenuAdapter
import com.example.victormanuel.gourmertapp.R
import com.example.victormanuel.gourmertapp.R.id.list
import com.example.victormanuel.gourmertapp.util.Data
import kotlinx.android.synthetic.main.fragment_main.*
import org.jetbrains.anko.support.v4.startActivity


class MainFragment : Fragment() {

    val adapter: MenuAdapter =  MenuAdapter(this::menuSelected)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onResume() {
        super.onResume()

        list.adapter = adapter
        list.layoutManager = LinearLayoutManager(activity)
        adapter.data = Data.menus
    }

    fun menuSelected(pos:Int){
        startActivity<DetailActivity>("pos" to pos)
    }
    companion object {
        fun instance(): MainFragment = MainFragment()
    }

}
