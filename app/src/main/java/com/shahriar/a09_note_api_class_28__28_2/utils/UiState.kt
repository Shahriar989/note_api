package com.shahriar.a09_note_api_class_28__28_2.utils

sealed class UiState <T>(val data:T?= null, val message:String?= null){

    class Loading<T>(): UiState<T>()

    class Error<T>(message: String?, data: T?): UiState<T>(data, message)

    class Success<T>(data: T?): UiState<T>(data)
}