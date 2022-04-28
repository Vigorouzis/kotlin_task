package com.example.kotlin_task.domain

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


//возраст, рост , вес, порода
@Parcelize
data class Cat(
    var age: Int,
    var growth: Int,
    var weight: Int,
    var breed: String,
    val catResource:Int
) : Parcelable