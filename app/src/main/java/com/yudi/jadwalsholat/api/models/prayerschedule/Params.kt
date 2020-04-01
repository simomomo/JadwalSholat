package com.yudi.jadwalsholat.api.models.prayerschedule

import com.fasterxml.jackson.annotation.JsonProperty
import com.google.gson.annotations.SerializedName

data class Params (
	@field:JsonProperty("Fajr") var fajr : Double? = null,
	@field:JsonProperty("Isha") var isha : String? = null
)