package com.example.tpfirebase.ui.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatDelegate
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.tpfirebase.R
import com.example.tpfirebase.data.Prefs
import com.example.tpfirebase.databinding.FragmentSettingsBinding
import com.example.app.databinding.FragmentDataBdinding;


class SettingsFragment : Fragment() {

    private lateinit var settingsViewModel: SettingsViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        settingsViewModel = ViewModelProvider(this).get(SettingsViewModel::class.java)

        val binding: FragmentSettingsBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_settings, container, false
        )

        binding.switchNightMode.isChecked = Prefs.nightMode

        binding.switchNightMode.setOnCheckedChangeListener { _, isChecked ->
            Prefs.nightMode = isChecked
        }

        return binding.root
    }
}