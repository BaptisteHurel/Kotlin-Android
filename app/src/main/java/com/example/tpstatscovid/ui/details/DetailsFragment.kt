package com.example.tpstatscovid.ui.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.example.tpstatscovid.R
import com.example.tpstatscovid.databinding.FragmentDetailsBinding
import com.example.tpstatscovid.databinding.FragmentFavoritesBinding

class DetailsFragment : Fragment() {

    private lateinit var detailsViewModel: DetailsViewModel
    //private val args: DetailsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        detailsViewModel = ViewModelProvider(this).get(DetailsViewModel::class.java)

        val binding: FragmentDetailsBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_details, container, false
        )

        binding.viewModel = detailsViewModel

        binding.textView1.text = args.pays

        return binding.root
    }
}