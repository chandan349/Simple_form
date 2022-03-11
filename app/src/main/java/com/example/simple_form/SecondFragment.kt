package com.example.simple_form

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.simple_form.databinding.FragmentSecondBinding

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

       /* binding.buttonSecond.setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }*/

        var fname = arguments?.getString("fname")
        var lname = arguments?.getString("lname")
        var cname = arguments?.getString("cname")
        var isCollege = arguments?.getBoolean("college")
        var isHappy = arguments?.getBoolean("happy")
        var gender = arguments?.getString("gender")

        binding.edittext1.setText(fname)
        binding.textView1.setText(lname)
        binding.textView2.setText(cname)
        binding.textView03.setText(if(isCollege == true){"Yes"} else{"false"})
        binding.textView04.setText(if(isHappy == true){"Yes"} else{"false"})
        binding.textView05.setText (gender)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}