package com.example.mtgapp.base.network

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ErrorResponse(
    val errors: List<String>
)