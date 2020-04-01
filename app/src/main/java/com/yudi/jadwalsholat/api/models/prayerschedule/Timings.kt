package com.yudi.jadwalsholat.api.models.prayerschedule

import com.fasterxml.jackson.annotation.JsonProperty
import com.google.gson.annotations.SerializedName

data class Timings (
	@field:JsonProperty("Fajr") var fajr : String? = null,
	@field:JsonProperty("Sunrise") var sunrise : String? = null,
	@field:JsonProperty("Dhuhr") var dhuhr : String? = null,
	@field:JsonProperty("Asr") var asr : String? = null,
	@field:JsonProperty("Sunset") var sunset : String? = null,
	@field:JsonProperty("Maghrib") var maghrib : String? = null,
	@field:JsonProperty("Isha") var isha : String? = null,
	@field:JsonProperty("Imsak") var imsak : String? = null,
	@field:JsonProperty("Midnight") var midnight : String? = null
)