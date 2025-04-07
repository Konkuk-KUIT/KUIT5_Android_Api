package com.example.kuitandroidapiexample.navigation

import kotlinx.serialization.Serializable

sealed interface Route {
    @Serializable
    data object Home : Route
    @Serializable
    data object Register : Route
    @Serializable
    data object Detail: Route
}