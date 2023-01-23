package com.example.orion.doctorgo.fregments

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
//import com.example.orion.doctorgo.GETcall.getCall
import com.example.orion.doctorgo.R
import com.example.orion.doctorgo.databinding.RegistrationBinding
import kotlinx.android.synthetic.main.fragment_doctor_list.*
import kotlinx.android.synthetic.main.registration.*
import kotlinx.android.synthetic.main.registration.view.*
import retrofit2.*


class homeFragment : Fragment() {
    @RequiresApi(Build.VERSION_CODES.M)
    @SuppressLint("ResourceAsColor")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var name:String
        var email:String
        var gender:String = ""
        var practiceMonth:String
        var practiceYear:String
        var binding= DataBindingUtil.inflate<RegistrationBinding>(inflater,
            R.layout.registration, container,false)
            binding.menbtn.setOnClickListener {
                gender = "M"
                binding.menbtn.setTextColor(getResources().getColor(R.color.white))
                binding.menbtn.setBackgroundResource(R.drawable.gender)

                binding.femalebtn.setTextColor(getResources().getColor(R.color.orange))
                binding.femalebtn.setBackgroundResource(R.drawable.genderselected)

                binding.otherbtn.setTextColor(getResources().getColor(R.color.orange))
                binding.otherbtn.setBackgroundResource(R.drawable.genderselected)
            }
        binding.femalebtn.setOnClickListener {
            gender = "F"
            binding.menbtn.setTextColor(getResources().getColor(R.color.orange))
            binding.menbtn.setBackgroundResource(R.drawable.genderselected)

            binding.femalebtn.setTextColor(getResources().getColor(R.color.white))
            binding.femalebtn.setBackgroundResource(R.drawable.gender)


            binding.otherbtn.setTextColor(getResources().getColor(R.color.orange))
            binding.otherbtn.setBackgroundResource(R.drawable.genderselected)
        }
        binding.otherbtn.setOnClickListener {
            gender = "O"
            binding.menbtn.setTextColor(getResources().getColor(R.color.orange))
            binding.menbtn.setBackgroundResource(R.drawable.genderselected)

            binding.femalebtn.setTextColor(getResources().getColor(R.color.orange))
            binding.femalebtn.setBackgroundResource(R.drawable.genderselected)

            binding.otherbtn.setTextColor(getResources().getColor(R.color.white))
            binding.otherbtn.setBackgroundResource(R.drawable.gender)
        }
        binding.submit.setOnClickListener {
                 name = binding.EditName.text.toString()
                 email = binding.EditEmail.text.toString()
                 practiceMonth=binding.textmonth.toString()
                 practiceYear=binding.textyear.toString()
            Toast.makeText(context, gender, Toast.LENGTH_SHORT).show()
        ////////////////////////////////////////////////////////////////////////////////////////////////////////
//           var name = PostRequest(requireContext(),name,gender,email,practiceMonth,practiceYear)
        //////////////////////////////////////////////////////////////////////////////////////////////////////////



                it.findNavController().navigate(R.id.action_homeFragment4_to_homeFregment)



        }
        return binding.root


    }


}