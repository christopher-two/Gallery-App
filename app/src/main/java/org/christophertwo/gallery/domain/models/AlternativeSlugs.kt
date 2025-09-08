package org.christophertwo.gallery.domain.models

import kotlinx.serialization.Serializable

@Serializable
data class AlternativeSlugs(
    val en: String,
    val es: String? = null,
    val ja: String? = null,
    val fr: String? = null,
    val it: String? = null,
    val ko: String? = null,
    val de: String? = null,
    val pt: String? = null,
    val id: String? = null
)
