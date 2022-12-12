package com.oishikenko.android.recruitment.data.model


import com.squareup.moshi.Json
import java.text.SimpleDateFormat
import java.util.*

data class CookingRecord(
    @Json(name = "comment")
    val comment: String,
    @Json(name = "image_url")
    val imageUrl: String,
    @Json(name = "recipe_type")
    val recipeType: String,
    @Json(name = "recorded_at")
    val recordedAt: String,
)