package com.example.androidunittesting

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.androidunittesting.data.User
import com.example.androidunittesting.databinding.ItemUserBinding

class UserAdapter : ListAdapter<User,UserAdapter.UserHolder>(diffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserHolder {
       val view = ItemUserBinding.inflate(
           LayoutInflater.from(parent.context),parent,false
       )
        return UserHolder(view)
    }

    override fun onBindViewHolder(holder: UserHolder, position: Int) {
        val item = getItem(position)
        holder.apply {
            txt_username.text = item.username
            txt_password.text = item.password
        }
    }
    companion object{
        val diffUtil = object :DiffUtil.ItemCallback<User>(){
            override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
                return oldItem.username == newItem.username
            }

        }
    }
    class UserHolder(item:ItemUserBinding):RecyclerView.ViewHolder(item.root){
        val txt_username = item.txtUsername
        val txt_password = item.txtPassword
    }
}