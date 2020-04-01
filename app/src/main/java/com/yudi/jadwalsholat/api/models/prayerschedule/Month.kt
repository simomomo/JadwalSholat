package com.yudi.jadwalsholat.api.models.prayerschedule

import com.fasterxml.jackson.annotation.JsonProperty
import com.google.gson.annotations.SerializedName

data class Month (

	@field:JsonProperty("number") var number : Int? = null,
	@field:JsonProperty("en") var en : String? = null,
	@field:JsonProperty("ar") var ar : String? = null
)