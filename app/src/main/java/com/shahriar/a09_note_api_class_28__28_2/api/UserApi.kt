package com.shahriar.a09_note_api_class_28__28_2.api

import com.shahriar.a09_note_api_class_28__28_2.data.model.login.RequestLogin
import com.shahriar.a09_note_api_class_28__28_2.data.model.login.ResponseUserLogin
import com.shahriar.a09_note_api_class_28__28_2.data.model.registration.RequestUserRegistration
import com.shahriar.a09_note_api_class_28__28_2.data.model.registration.ResponseRegisteredUser
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface UserApi {

    @POST("/users/signup")
    suspend fun registration(@Body request: RequestUserRegistration): Response<ResponseRegisteredUser>

    @POST("/users/signin")
    suspend fun login(@Body request: RequestLogin): Response<ResponseUserLogin>
}