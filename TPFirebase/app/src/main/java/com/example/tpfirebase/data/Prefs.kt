package com.example.tpfirebase.data

import com.chibatching.kotpref.KotprefModel

object Prefs : KotprefModel() {
    var nightMode by booleanPref(default = false)
}