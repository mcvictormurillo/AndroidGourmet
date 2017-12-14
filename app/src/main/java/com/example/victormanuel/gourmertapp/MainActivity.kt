package com.example.victormanuel.gourmertapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v4.app.Fragment
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.view.MenuItem
import android.view.View
import com.example.victormanuel.gourmertapp.fragments.MainFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), DrawerLayout.DrawerListener {


    val toogle : ActionBarDrawerToggle by lazy {ActionBarDrawerToggle(this,drawer,R.string.open_menu, R.string.close_menu)}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        drawer.addDrawerListener(this)


        nav.setNavigationItemSelectedListener{
            setContent(it)
        }


        putFragment(R.id.container,MainFragment.instance())
    }



    fun putFragment(container: Int, fragment: Fragment) {
        supportFragmentManager.beginTransaction()
                .replace(container, fragment)
                .commit()
    }

    fun setContent(item:MenuItem):Boolean{
        drawer.closeDrawers()
        when(item?.itemId){
            R.id.nav_home -> putFragment(R.id.container, MainFragment.instance())
        }
        return true
    }

    //region Toogle

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        toogle.syncState()
    }


    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if(toogle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onDrawerStateChanged(newState: Int) {
        toogle.onDrawerStateChanged(newState)
    }

    override fun onDrawerSlide(drawerView: View, slideOffset: Float) {
        toogle.onDrawerSlide(drawerView,slideOffset)
    }

    override fun onDrawerClosed(drawerView: View) {
        toogle.onDrawerClosed(drawerView)
    }

    override fun onDrawerOpened(drawerView: View) {
        toogle.onDrawerOpened(drawerView)
    }
    //endregion
}
