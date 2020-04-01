package com.yudi.jadwalsholat.api.models.prayerschedule

import com.fasterxml.jackson.annotation.JsonProperty
import com.google.gson.annotations.SerializedName

data class Method (

	@field:JsonProperty("id") var id : Int? = null,
	@field:JsonProperty("name") var name : String? = null,
	@field:JsonProperty("params") var params : Params? = null
)