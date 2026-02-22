package com.randomnumber

import kotlinx.serialization.Serializable

@Serializable
data class Scheme(
    val name: String,
    val min: Long,
    val max: Long
)
