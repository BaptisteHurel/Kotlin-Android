package com.iplant.ui.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavDirections
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.iplant.R
import com.iplant.databinding.FragmentFavoritesBinding
import com.iplant.databinding.FragmentSearchBinding


class SearchFragment : Fragment() {

    private lateinit var searchViewModel: SearchViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {

        searchViewModel = ViewModelProvider(this).get(SearchViewModel::class.java)

        val binding: FragmentSearchBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_search, container, false
        )
        binding.viewModel = searchViewModel

        binding.btnDetails.setOnClickListener {it: View!
            val action:NavDirections = SearchFragmentDirections.actionNavigationSearchToDetailsFragment(
                plantName = binding.editTextplantName.text.toString()
            )
            findNavController().navigate(action)
        }

        return binding.root
    }

}