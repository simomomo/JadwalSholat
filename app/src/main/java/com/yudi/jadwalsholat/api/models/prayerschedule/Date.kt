package com.yudi.jadwalsholat.api.models.prayerschedule

import com.fasterxml.jackson.annotation.JsonProperty
import com.google.gson.annotations.SerializedName

data class Date (
	@field:JsonProperty("readable") var readable : String? = null,
	@field:JsonProperty("timestamp") var timestamp : Int? = null,
	@field:JsonProperty("hijri") var hijri : Hijri? = null,
	@field:JsonProperty("gregorian") var gregorian : Gregorian? = null
)