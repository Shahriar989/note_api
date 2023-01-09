package com.shahriar.a09_note_api_class_28__28_2.data.model.repo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.shahriar.a09_note_api_class_28__28_2.api.UserApi
import com.shahriar.a09_note_api_class_28__28_2.data.model.registration.RequestUserRegistration
import com.shahriar.a09_note_api_class_28__28_2.data.model.registration.ResponseRegisteredUser
import com.shahriar.a09_note_api_class_28__28_2.utils.UiState
import org.json.JSONObject
import javax.inject.Inject

class UserRepo @Inject constructor(private val userApi: UserApi){

    private val _userRegistrationResponse= MutableLiveData<UiState<ResponseRegisteredUser>>()
    val userRegistrationResponse: LiveData<UiState<ResponseRegisteredUser>>
    get() = _userRegistrationResponse

    suspend fun registerUser(request: RequestUserRegistration){

        _userRegistrationResponse.postValue(UiState.Loading())

        val response = userApi.registration(request)

        if (response.isSuccessful && response.body() != null){

            _userRegistrationResponse.postValue(UiState.Success(response.body()))
        }else if (response.errorBody() != null){

            val errorObj= JSONObject(response.errorBody()!!.charStream().readText())
            _userRegistrationResponse.postValue(UiState.Error(errorObj.getString("message"), null))
        }else{

            _userRegistrationResponse.postValue(UiState.Error("Something went wrong", null))
        }
    }
}