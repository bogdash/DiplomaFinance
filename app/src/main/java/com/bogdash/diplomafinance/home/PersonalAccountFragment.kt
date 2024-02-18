package com.bogdash.diplomafinance.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bogdash.diplomafinance.R
import com.bogdash.diplomafinance.databinding.FragmentPersonalAccountBinding

class PersonalAccountFragment : Fragment() {
    private lateinit var binding: FragmentPersonalAccountBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPersonalAccountBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }
}