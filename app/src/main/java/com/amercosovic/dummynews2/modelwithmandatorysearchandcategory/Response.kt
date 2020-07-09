package com.amercosovic.dummynews2.modelwithmandatorysearchandcategory


import com.google.gson.annotations.SerializedName

data class Response(
    @SerializedName("docs")
    val docs: List<Doc>,
    @SerializedName("meta")
    val meta: Meta
)