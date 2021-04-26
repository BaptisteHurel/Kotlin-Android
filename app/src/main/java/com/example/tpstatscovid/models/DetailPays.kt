package com.example.tpstatscovid.models

data class DetailPays(
    val total_cases: Float,
    val active_cases: Float,
    val deaths: Float,
    val recovered: Float,
    val critical: Float,
    val tested: Float,
    val death_ratio: Float,
    val recovery_ratio: Float,
)