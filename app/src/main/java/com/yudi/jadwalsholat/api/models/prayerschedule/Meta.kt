package com.yudi.jadwalsholat.api.models.prayerschedule

import com.fasterxml.jackson.annotation.JsonProperty
import com.google.gson.annotations.SerializedName

data class Meta (

	@field:JsonProperty("latitude") var latitude : Double? = null,
	@field:JsonProperty("longitude") var longitude : Double? = null,
	@field:JsonProperty("timezone") var timezone : String? = null,
	@field:JsonProperty("method") var method : Method? = null,
	@field:JsonProperty("latitudeAdjustmentMethod") var latitudeAdjustmentMethod : String? = null,
	@field:JsonProperty("midnightMode") var midnightMode : String? = null,
	@field:JsonProperty("school") var school : String? = null,
	@field:JsonProperty("offset") var offset : Offset? = null
)