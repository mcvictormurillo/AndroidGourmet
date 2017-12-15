package com.example.victormanuel.gourmertapp.adapters
import android.app.AlertDialog
import android.content.Context
import android.support.design.widget.TextInputEditText

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import android.widget.Toast
import com.example.victormanuel.gourmertapp.R
import com.example.victormanuel.gourmertapp.models.User
import com.google.firebase.database.FirebaseDatabase
import org.w3c.dom.Text

/**
 * Created by Victor Manuel on 14/12/2017.
 */
class UserAdapter( val mCtx: Context, val layoutResId:Int,  val userList: List<User>):
        ArrayAdapter<User>(mCtx,layoutResId,userList){

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val layoutInflater: LayoutInflater = LayoutInflater.from(mCtx)
        val view: View = layoutInflater.inflate(layoutResId,null)
        val textViewUser = view.findViewById<TextView>(R.id.textViewUser)

        val textViewUpdate = view.findViewById<TextView>(R.id.textViewUpdate)
        val user = userList[position]
        textViewUser.text = user.identificacion


        textViewUpdate.setOnClickListener{
            showUpdateDialog(user)
        }


        return view

    }




    private fun showUpdateDialog(user: User) {
        val builder = AlertDialog.Builder(mCtx)
        builder.setTitle("Update User")
        val inflater = LayoutInflater.from(mCtx)


        val view = inflater.inflate(R.layout.template_update_user,null)
        val ediTextCe = view.findViewById<TextInputEditText>(R.id.editTextCe)
        val ediTextPass = view.findViewById<TextInputEditText>(R.id.editTextPass)

        ediTextCe.setText(user.identificacion)
        ediTextCe.setText(user.contrasenia)


        builder.setView(view)


        builder.setPositiveButton("update"){p0, p1 ->
            val dbUser = FirebaseDatabase.getInstance().getReference("Users")
            val identificacion = ediTextCe.text.toString().trim()
            if (identificacion.isEmpty()){
                ediTextCe.error = "please enter cedula"
                ediTextCe.requestFocus()
                return@setPositiveButton
            }
            val contrasenia = ediTextPass.text.toString().trim()
            val user = User(user.identificacion,contrasenia)
            dbUser.child(user.identificacion).setValue(user)
            Toast.makeText(mCtx,"Usuario Actualizado",  Toast.LENGTH_LONG).show()
        }

        builder.setNegativeButton("No"){p0, p1 -> }


        val alert = builder.create()

        alert.show()
    }

}