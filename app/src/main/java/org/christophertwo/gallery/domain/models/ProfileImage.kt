package org.christophertwo.gallery.domain.models

import kotlinx.serialization.Serializable

@Serializable
data class ProfileImage(
    val small: String,
    val medium: String,
    val large: String
)
