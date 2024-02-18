package com.bogdash.diplomafinance.register

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.bogdash.diplomafinance.R
import com.bogdash.diplomafinance.databinding.FragmentLogInBinding
import com.google.firebase.auth.FirebaseAuth

class LogInFragment : Fragment() {
    private lateinit var binding: FragmentLogInBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLogInBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            btLogIn.setOnClickListener {
                if (tietEnterEmailLogIn.text.toString()
                        .isEmpty() || edEnterPasswordLogIn.text.toString().isEmpty()
                ) {
                    Toast.makeText(
                        requireContext(),
                        getString(R.string.fields_cannot_be_empty),
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    FirebaseAuth.getInstance().signInWithEmailAndPassword(
                        tietEnterEmailLogIn.text.toString(),
                        edEnterPasswordLogIn.text.toString()
                    )
                        .addOnCompleteListener {
                            if (it.isSuccessful) {
                                findNavController().navigate(R.id.action_logInFragment_to_personalAccountFragment)
                                Toast.makeText(requireContext(), "Вход", Toast.LENGTH_SHORT).show()
                            }
                        }
                }
            }
        }

    }

}