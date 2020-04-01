package com.yudi.jadwalsholat.api.models.prayerschedule

import com.fasterxml.jackson.annotation.JsonProperty
import com.google.gson.annotations.SerializedName

data class Designation (
	@field:JsonProperty("abbreviated") var abbreviated : String? = null,
	@field:JsonProperty("expanded") var expanded : String? = null
)