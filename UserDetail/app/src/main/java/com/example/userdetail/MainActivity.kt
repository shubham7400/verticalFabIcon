package com.example.userdetail


import android.app.Activity

import android.content.Intent
import android.icu.lang.UCharacter

import androidx.appcompat.app.AppCompatActivity

import android.os.Bundle

import android.provider.SyncStateContract.Helpers.insert

import android.util.Log
import android.widget.LinearLayout

import android.widget.Toast

import androidx.activity.viewModels

import androidx.lifecycle.LiveData

import androidx.recyclerview.widget.LinearLayoutManager

import androidx.recyclerview.widget.RecyclerView

import androidx.room.Room

import com.google.android.material.floatingactionbutton.FloatingActionButton

import java.util.Observer



class MainActivity : AppCompatActivity() {

    lateinit var fabInMain: FloatingActionButton

    private val newUserActivityRequestCode = 1

    lateinit var recyclerView:RecyclerView
    lateinit var userRoomDatabase: UserRoomDatabase
    lateinit var allUsers: List<User>



    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerViewId)
        recyclerView.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)



        fabInMain = findViewById<FloatingActionButton>(R.id.fabInMainId)

        Log.d("tag","check fab icon"+fabInMain)

        fabInMain.setOnClickListener{

            val intent = Intent(this, AddNewUserActivity::class.java)

            startActivityForResult(intent, newUserActivityRequestCode)

        }
        userRoomDatabase = UserRoomDatabase.getInstance(this)
        allUsers = userRoomDatabase.userDao().getAllUsers()
        recyclerView.adapter = UserAdapter(allUsers, { user -> userClicked(user) })

    }





    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == newUserActivityRequestCode && resultCode == Activity.RESULT_OK)
        {
            val reply = data?.getStringArrayExtra(AddNewUserActivity.EXTRA_REPLY)
            val user = User(reply?.get(0).toString(), reply?.get(1).toString(), reply?.get(2).toString())
            Log.d("tag ","${reply?.get(0)}  ${reply?.get(1)}  ${reply?.get(2)}")

            val username = reply?.get(0)
            val isUserExist = username?.let { userRoomDatabase.userDao().isUserExist(it) }
           /* userRoomDatabase = UserRoomDatabase.getInstance(this)*/
            if (isUserExist == username)
            {
                Toast.makeText(this,"Username already exist! please try with another one",Toast.LENGTH_LONG).show()
            }else{
                 userRoomDatabase.userDao().insertUser(user)
            }
            Log.d("tag ", "data has beeb saved")
            allUsers = userRoomDatabase.userDao().getAllUsers()
            Log.d("tag", "user list "+allUsers)
            for (user in allUsers)
            {
                Log.d("tag", "user result "+user.username)
            }
            recyclerView.adapter = UserAdapter(allUsers, { user -> userClicked(user) })
        }else{
            Toast.makeText(applicationContext, "data not saved! please make sure that you filled all field", Toast.LENGTH_LONG).show()
        }
    }

    private fun userClicked(user: User) {
        Toast.makeText(this, "Clicked: ${user.username}", Toast.LENGTH_SHORT).show()

        val intent = Intent(this, UserDetailActivity::class.java)
        val username = user.username
        intent.putExtra("username",username)

        startActivity(intent)
    }

}