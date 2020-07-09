package com.amercosovic.dummynews2.modelwithmandatorysearchandcategory


import com.google.gson.annotations.SerializedName

data class MandatorySearchAndCategory(
    @SerializedName("copyright")
    val copyright: String,
    @SerializedName("response")
    val response: Response,
    @SerializedName("status")
    val status: String
)