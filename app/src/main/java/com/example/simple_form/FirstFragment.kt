package com.example.simple_form

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.example.simple_form.databinding.FragmentFirstBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

       /* binding.buttonFirst.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }*/
        binding.btnClear.setOnClickListener {
            //Toast.makeText(activity, "Clear button was pressed", Toast.LENGTH_LONG).show()
            clearForm()
        }

        binding.btnSave.setOnClickListener {
            //Toast.makeText(activity, "Save button was pressed", Toast.LENGTH_LONG).show()
            handelForm()
        }

    }

    private fun clearForm() {
        binding.female.clearFocus()
        binding.male.clearFocus()

        binding.editfName.setText("");
        binding.editlName.setText("");
        binding.editCollege.setText("");

        binding.cbCollegeComplete.clearFocus()
        binding.cbHappiness.clearFocus()


    }

    private fun handelForm(){
        var gender = when(binding.rgGender.checkedRadioButtonId){
            R.id.female -> "female"
            R.id.male -> "male"
            else -> "not conformed"
        }
        val fname = binding.editfName.text.toString();
        val lname = binding.editlName.text.toString();
        val cname = binding.editCollege.text.toString();

        val isCollegeComplete = binding.cbCollegeComplete.isChecked
        val isHappy = binding.cbHappiness.isChecked

        val bundle = bundleOf(
            "fname" to fname,
            "lname" to lname,
            "gender" to gender,
            "cname" to cname,
            "college" to isCollegeComplete,
            "happy" to isHappy
        )

        findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment, bundle)
    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}