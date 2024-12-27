package com.example.myapplication.saathi.models

import com.google.gson.annotations.SerializedName

data class UploadImg(
    @SerializedName("success") val success: Boolean,
    @SerializedName("message") val message: String
)


//data class UploadImg(
  //  val success: Boolean,
    //val message: String
//)