package com.example.tpfirebase.ui.creationCompte

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.tpfirebase.R
import com.example.tpfirebase.databinding.FragmentCreationCompteBinding


class CreationCompteFragment : Fragment() {

    private lateinit var creationCompteViewModel : CreationCompteViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        creationCompteViewModel = ViewModelProvider(this).get(CreationCompteViewModel::class.java)

        val binding: FragmentCreationCompteBinding= DataBindingUtil.inflate(
                inflater, R.layout.creation_compte, container, false
        )

        return binding.root
    }
}