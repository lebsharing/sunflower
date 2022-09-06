package com.leb.sunflower

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.leb.sunflower.adapters.PlantAdapter
import com.leb.sunflower.data.model.Plant
import com.leb.sunflower.databinding.FragmentPlantListBinding
import com.leb.sunflower.viewmodels.PlantListViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PlantListFragment:Fragment() {
    private val viewModel:PlantListViewModel by viewModels<PlantListViewModel>()
    private lateinit var binding:FragmentPlantListBinding;

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPlantListBinding.inflate(inflater,container,false);
//        context ?: return binding.root;

        val adapter = PlantAdapter();
        binding.plantRecyclerView.adapter = adapter;

        subscribeUi(adapter);
        return binding.root;
    }

    private fun subscribeUi(adapter:PlantAdapter) {
        // Create the observer which updates the UI.
        val plantObserver = Observer<List<Plant>>{ plants ->
            adapter.submitList(plants);
        }
        viewModel.plants.observe(viewLifecycleOwner,plantObserver)
    }
}