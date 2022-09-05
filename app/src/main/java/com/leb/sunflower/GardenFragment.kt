package com.leb.sunflower

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.leb.sunflower.databinding.FragmentGardentBinding

class GardenFragment : Fragment() {

    private lateinit var binding: FragmentGardentBinding;

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentGardentBinding.inflate(inflater, container, false);

        binding.addPlantBtn.setOnClickListener { }
        return binding.root;
    }
}