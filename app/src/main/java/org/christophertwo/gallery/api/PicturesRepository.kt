package org.christophertwo.gallery.api

import org.christophertwo.gallery.domain.models.UnsplashPhoto

interface PicturesRepository {
    suspend fun getPictures(): List<UnsplashPhoto>
    suspend fun getPicture(id: String): UnsplashPhoto
    suspend fun searchPictures(query: String): List<UnsplashPhoto>
}