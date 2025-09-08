package org.christophertwo.gallery.utils

sealed class RoutesApp(val route: String) {
    data object Gallery : RoutesApp("gallery")
}