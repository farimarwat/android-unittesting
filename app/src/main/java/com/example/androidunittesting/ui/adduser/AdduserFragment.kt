package com.example.androidunittesting.ui.adduser

import android.app.Application
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.androidunittesting.R
import com.example.androidunittesting.data.User
import com.example.androidunittesting.databinding.FragmentAdduserBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class AdduserFragment : Fragment() {
    lateinit var binding:FragmentAdduserBinding
    @Inject
    lateinit var mContext:Application
     val mViewModel:AddUserViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAdduserBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnCreateuser.setOnClickListener{
            addUser()
        }

        lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
                mViewModel.isUserAdded.collect{
                    if(it){
                        binding.txtStatus.text = "User Added Successfully"
                        mViewModel.isUserAdded.value = false
                    }
                }
            }
        }
    }

    fun addUser(){
        val username = binding.edtUsername.text.toString()
        val password = binding.edtPassword.text.toString()
        mViewModel.addUser(User(username,password))
    }
}