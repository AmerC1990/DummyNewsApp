package com.amercosovic.dummynews2.modelwithmandatorysearchandcategoryanddates


import com.google.gson.annotations.SerializedName

data class MandatorySearchAndCategoryAndDates(
    @SerializedName("copyright")
    val copyright: String,
    @SerializedName("response")
    val response: Response,
    @SerializedName("status")
    val status: String
)