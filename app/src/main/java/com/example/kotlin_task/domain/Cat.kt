package com.example.kotlin_task.domain

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


//возраст, рост , вес, порода
//класс просто хранит данный и ничего в нём не происходит, он за меня
// переопредляет методы и делает для переменных конструкторы и геттеры и сеттеры
@Parcelize
data class Cat(
    var age: Int,
    var growth: Int,
    var weight: Int,
    var breed: String,
    val catResource:Int
) : Parcelable