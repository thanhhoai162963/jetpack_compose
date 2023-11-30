package com.example.composetutorial.util

enum class UiState {
    Loading,
    Success,
    Error,
    Loaded
}

sealed class UiState1{
     data class Loading(): UiState1
}

