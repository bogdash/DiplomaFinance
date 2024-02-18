package com.bogdash.diplomafinance.register

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.bogdash.diplomafinance.R
import com.bogdash.diplomafinance.databinding.FragmentSignUpBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

class SignUpFragment : Fragment() {
    private lateinit var binding: FragmentSignUpBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSignUpBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            btSignUp.setOnClickListener {
                if (tietEnterEmail.text.toString().isEmpty() || edEnterUserName.text.toString()
                        .isEmpty() || edEnterPassword.text.toString().isEmpty()
                ) {
                    Toast.makeText(
                        requireContext(),
                        getString(R.string.fields_cannot_be_empty),
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    FirebaseAuth.getInstance().createUserWithEmailAndPassword(tietEnterEmail.text.toString(), edEnterPassword.text.toString())
                    val userInfo = hashMapOf<String, String>()
                    userInfo["email"] = tietEnterEmail.text.toString()
                    userInfo["userName"] = edEnterUserName.text.toString()
                    FirebaseAuth.getInstance().currentUser?.let {
                        FirebaseDatabase.getInstance().reference.child("Users").child(it.uid)
                            .setValue(userInfo)
                    }


                    findNavController().navigate(R.id.action_signUpFragment_to_personalAccountFragment)
                    Toast.makeText(requireContext(), "Регистрация", Toast.LENGTH_SHORT).show()

                }
            }
        }
    }

}