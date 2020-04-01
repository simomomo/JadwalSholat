package com.yudi.jadwalsholat.api.models.prayerschedule

import com.fasterxml.jackson.annotation.JsonProperty
import com.google.gson.annotations.SerializedName

data class PrayerData (
	@field:JsonProperty("timings") var timings : Timings? = null,
	@field:JsonProperty("date") var date : Date? = null,
	@field:JsonProperty("meta") var meta : Meta? = null
)