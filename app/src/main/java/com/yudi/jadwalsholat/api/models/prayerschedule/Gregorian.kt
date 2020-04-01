package com.yudi.jadwalsholat.api.models.prayerschedule

import com.fasterxml.jackson.annotation.JsonProperty
import com.google.gson.annotations.SerializedName
import com.yudi.jadwalsholat.api.models.prayerschedule.*

data class Gregorian (

	@field:JsonProperty("date") var date : String? = null,
	@field:JsonProperty("format") var format : String? = null,
	@field:JsonProperty("day") var day : Int? = null,
	@field:JsonProperty("weekday") var weekday : Weekday? = null,
	@field:JsonProperty("month") var month : Month? = null,
	@field:JsonProperty("year") var year : Int? = null,
	@field:JsonProperty("designation") var designation : Designation? = null
)