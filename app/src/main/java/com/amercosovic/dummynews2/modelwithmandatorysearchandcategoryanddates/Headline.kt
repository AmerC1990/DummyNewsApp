package com.amercosovic.dummynews2.modelwithmandatorysearchandcategoryanddates


import com.google.gson.annotations.SerializedName

data class Headline(
    @SerializedName("content_kicker")
    val contentKicker: Any,
    @SerializedName("kicker")
    val kicker: Any,
    @SerializedName("main")
    val main: String,
    @SerializedName("name")
    val name: Any,
    @SerializedName("print_headline")
    val printHeadline: String,
    @SerializedName("seo")
    val seo: Any,
    @SerializedName("sub")
    val sub: Any
)