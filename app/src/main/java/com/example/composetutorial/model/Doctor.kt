package com.example.composetutorial.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class City(val name: String, val country: String) : Parcelable

