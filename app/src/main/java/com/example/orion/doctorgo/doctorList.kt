package com.example.orion.doctorgo

import android.os.Bundle
import android.util.Log.d
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.orion.doctorgo.databinding.FragmentDoctorListBinding
import com.example.orion.doctorgo.viewmodel.DoctorListViewModel
import com.example.orion.doctorgo.viewmodel.DoctorListViewModelFactory

class doctorList() : Fragment() {
    private lateinit var binding : FragmentDoctorListBinding

    private lateinit var myAdapter : baseAdapter

    private lateinit var myViewModel : DoctorListViewModel
     override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding= DataBindingUtil.inflate<FragmentDoctorListBinding>(inflater,
            R.layout.fragment_doctor_list, container,false)
        return binding.root
    }

     override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
         super.onViewCreated(view, savedInstanceState)

         setupInstances()

         myViewModel.myResponse.observe(viewLifecycleOwner){

             if(it.isSuccessful) {

                 // TODO :- Fix this RecyclerView
                 myAdapter = baseAdapter(it.body()!!.d.results)
                 d("Doctor List Observer" , it.body().toString())
             }
             else
                 Toast.makeText(requireContext() , "Failed" , Toast.LENGTH_SHORT).show()
         }
     }
     private fun setupInstances(){

         binding.myrecyclerview.layoutManager = LinearLayoutManager(context)
         binding.myrecyclerview.setHasFixedSize(true)
         myViewModel = ViewModelProvider(this , DoctorListViewModelFactory())[DoctorListViewModel::class.java]
         myViewModel.getCall()
     }
}