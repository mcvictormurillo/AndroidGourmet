package com.example.victormanuel.gourmertapp


import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle

import android.support.design.widget.TextInputEditText
import android.widget.Button
import android.widget.ListView

import android.widget.Toast
import com.example.victormanuel.gourmertapp.adapters.UserAdapter
import com.example.victormanuel.gourmertapp.databinding.ActivityLoginBinding
import com.example.victormanuel.gourmertapp.models.User
import com.google.firebase.database.*
import org.jetbrains.anko.startActivity


class LoginActivity : AppCompatActivity() {
    //----- base de datos
    lateinit var editTextCed : TextInputEditText
    lateinit var editTextPassword: TextInputEditText
    lateinit var btnReg: Button
    lateinit var userList: MutableList<User>
    lateinit var ref: DatabaseReference
    lateinit var listView: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val binding: ActivityLoginBinding = DataBindingUtil.setContentView(this,R.layout.activity_login)
        binding.handler=this
        userList= mutableListOf()
        ref = FirebaseDatabase.getInstance().getReference("Users")


        editTextCed = findViewById(R.id.editTextCedula)
        editTextPassword = findViewById(R.id.editTextPassword)
        btnReg = findViewById(R.id.btnReg)
        listView = findViewById(R.id.listView)
        btnReg.setOnClickListener{
            saveUser()
        }

        ref.addValueEventListener(object: ValueEventListener{
            override fun onCancelled(p0: DatabaseError?) {
                TODO("not implemented")
            }

            override fun onDataChange(p0: DataSnapshot?) {
               userList.clear()
                if(p0!!.exists()){
                    for(h in p0.children){
                        val user = h.getValue(User::class.java)
                        userList.add(user!!)

                    }
                    val adapter = UserAdapter(this@LoginActivity,R.layout.template_user,userList)

                    listView.adapter = adapter
                }
            }

        })



    }

    fun login(){
    startActivity<MainActivity>()
    }



    private fun saveUser(){
        val ced = editTextCed.text.toString().trim()
        val password = editTextPassword.text.toString().trim()

        if(ced.isEmpty()){
            editTextCed.error = "error"
            return
        }
        //val userId = ref.push().key
        val user = User(ced,password)
        val userId = editTextCed.text.toString().trim()
        ref.child(userId).setValue(user).addOnCompleteListener({
            Toast.makeText(applicationContext, "Registro Exitoso", Toast.LENGTH_LONG).show()
        })
    }


}
