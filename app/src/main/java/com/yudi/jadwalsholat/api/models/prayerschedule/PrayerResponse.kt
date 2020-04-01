package com.yudi.jadwalsholat.api.models.prayerschedule

import com.fasterxml.jackson.annotation.JsonProperty
import com.google.gson.annotations.SerializedName

data class PrayerResponse(

	@field:JsonProperty("code") var code: Int? = null,
	@field:JsonProperty("status") var status: String? = null,
	@field:JsonProperty("data") var data: PrayerData? = null
)