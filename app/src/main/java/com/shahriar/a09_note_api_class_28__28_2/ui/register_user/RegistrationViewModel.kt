package com.shahriar.a09_note_api_class_28__28_2.ui.register_user

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shahriar.a09_note_api_class_28__28_2.data.model.registration.RequestUserRegistration
import com.shahriar.a09_note_api_class_28__28_2.data.model.registration.ResponseRegisteredUser
import com.shahriar.a09_note_api_class_28__28_2.data.model.repo.UserRepo
import com.shahriar.a09_note_api_class_28__28_2.utils.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegistrationViewModel @Inject constructor(private val userRepo: UserRepo): ViewModel(){

    val userRegistrationResponse: LiveData<UiState<ResponseRegisteredUser>>
    get() = userRepo.userRegistrationResponse

    fun registerUser(requestUserRegistration: RequestUserRegistration){

        viewModelScope.launch {
            userRepo.registerUser(requestUserRegistration)
        }
    }
}