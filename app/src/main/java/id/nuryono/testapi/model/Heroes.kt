package id.nuryono.testapi.model

import com.google.gson.annotations.SerializedName

data class Heroes(
    val name: String,
    @SerializedName("birth_year")
    val birthYear: String,
    @SerializedName("death_year")
    val deathYear: Int,
    val description: String = "",
    @SerializedName("ascension_year")
    val ascensionYear: Int
)
