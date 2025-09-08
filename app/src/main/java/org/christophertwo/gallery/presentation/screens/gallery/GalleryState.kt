package org.christophertwo.gallery.presentation.screens.gallery

import org.christophertwo.gallery.domain.models.UnsplashPhoto

data class GalleryState(
    val pictures: List<UnsplashPhoto> = emptyList(),
    val isLoading: Boolean = false
)