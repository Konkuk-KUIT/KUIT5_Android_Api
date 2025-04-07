package com.example.kuitandroidapiexample.model

data class AnimalData(
    val imageUrl: String,
    val animalName: String,
    val reporterName: String = "조익성",
    val type: AnimalType,
    val address: String
)
