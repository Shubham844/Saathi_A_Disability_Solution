package com.example.myapplication.saathi

import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part

interface ApiService {
    @Multipart
    @POST("upload")
    fun uploadImagesWithRatingReview(
        @Part images: List<MultipartBody.Part>,
        @Part("rating") rating: RequestBody,
        @Part("review") review: RequestBody
    ): Call<UploadImg>
}
