package org.christophertwo.gallery.domain.models

import kotlinx.serialization.Serializable

@Serializable
data class UserLinks(
    val self: String,
    val html: String,
    val photos: String,
    val likes: String,
    val portfolio: String
)
