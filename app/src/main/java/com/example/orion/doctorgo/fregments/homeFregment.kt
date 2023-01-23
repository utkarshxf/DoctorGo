package com.example.orion.doctorgo.fregments

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.orion.doctorgo.R
import com.example.orion.doctorgo.baseAdapter
import com.example.orion.doctorgo.databinding.FragmentHomeFregmentBinding
import kotlinx.android.synthetic.main.fragment_home_fregment.*
class homeFregment : Fragment() {

    @SuppressLint("SuspiciousIndentation")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        var adpt:baseAdapter

        var binding= DataBindingUtil.inflate<FragmentHomeFregmentBinding>(inflater,
            R.layout.fragment_home_fregment, container,false)

            binding.listbutton.setOnClickListener {
//                 myViewModel.getCall()
            textView.text= "working"
            it.findNavController().navigate(R.id.action_homeFregment_to_doctorList)
        }

        return binding.root
    }
}