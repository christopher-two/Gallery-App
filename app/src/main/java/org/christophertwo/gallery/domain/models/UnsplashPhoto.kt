package org.christophertwo.gallery.domain.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Clase de datos principal que representa la respuesta completa de un objeto de foto de la API de Unsplash.
 */
@Serializable
data class UnsplashPhoto(
    val id: String,
    val slug: String,
    @SerialName("alternative_slugs")
    val alternativeSlugs: AlternativeSlugs,
    @SerialName("created_at")
    val createdAt: String,
    @SerialName("updated_at")
    val updatedAt: String,
    @SerialName("promoted_at")
    val promotedAt: String? = null,
    val width: Int,
    val height: Int,
    val color: String,
    @SerialName("blur_hash")
    val blurHash: String,
    val description: String? = null,
    @SerialName("alt_description")
    val altDescription: String,
    val breadcrumbs: List<String>,
    val urls: PhotoUrls,
    val links: PhotoLinks,
    val likes: Int,
    @SerialName("liked_by_user")
    val likedByUser: Boolean,
    @SerialName("current_user_collections")
    val currentUserCollections: List<String>,
    val sponsorship: String? = null,
    @SerialName("topic_submissions")
    val topicSubmissions: TopicSubmissions,
    @SerialName("asset_type")
    val assetType: String,
    val user: User
)