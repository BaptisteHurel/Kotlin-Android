package com.example.tpstatscovid.data

import com.chibatching.kotpref.KotprefModel

object Prefs : KotprefModel() {
    var nightMode by booleanPref(default = false)
}