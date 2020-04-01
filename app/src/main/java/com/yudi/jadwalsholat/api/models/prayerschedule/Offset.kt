package com.yudi.jadwalsholat.api.models.prayerschedule

import com.fasterxml.jackson.annotation.JsonProperty
import com.google.gson.annotations.SerializedName

data class Offset (
	@field:JsonProperty("Imsak") var imsak : Int? = null,
	@field:JsonProperty("Fajr") var fajr : Int? = null,
	@field:JsonProperty("Sunrise") var sunrise : Int? = null,
	@field:JsonProperty("Dhuhr") var dhuhr : Int? = null,
	@field:JsonProperty("Asr") var asr : Int? = null,
	@field:JsonProperty("Maghrib") var maghrib : Int? = null,
	@field:JsonProperty("Sunset") var sunset : Int? = null,
	@field:JsonProperty("Isha") var isha : Int? = null,
	@field:JsonProperty("Midnight") var midnight : Int? = null
)