package com.example.userdetail

import android.util.Log
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class UserAdapter(val userList: List<User>, private val userClickListener: (User) -> Unit): RecyclerView.Adapter<UserAdapter.UserViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserAdapter.UserViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.user_list_layout,parent,false)
        return UserViewHolder(view)
    }

    override fun getItemCount(): Int {
        Log.d("tag", "userList"+userList.size)
         return userList.size
    }

    override fun onBindViewHolder(holder: UserAdapter.UserViewHolder, position: Int) {
         holder.userBind(userList[position], userClickListener)
    }


    class UserViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
    {
        fun userBind(user: User, userClickListener: (User) -> Unit)
        {
            val textViewUsername = itemView.findViewById<TextView>(R.id.textViewUsernameId)
            val textViewEmail = itemView.findViewById<TextView>(R.id.textViewEmailId)
            val textViewDOB = itemView.findViewById<TextView>(R.id.textViewDobId)

            textViewUsername.text = "Username : "+user.username
            textViewEmail.text = "Email : "+user.email
            textViewDOB.text = "Date : "+user.date

            itemView.setOnClickListener{
                userClickListener(user)
            }
        }


    }

}