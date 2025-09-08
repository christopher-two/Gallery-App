package org.christophertwo.gallery.data.repository

import android.util.Log
import org.christophertwo.gallery.api.PicturesRepository
import org.christophertwo.gallery.data.network.PicturesNetwork
import org.christophertwo.gallery.domain.models.UnsplashPhoto

class PicturesRepositoryImpl(
    private val network: PicturesNetwork
) : PicturesRepository {
    override suspend fun getPictures(): List<UnsplashPhoto> {
        return try {
            network.getPictures()
        } catch (e: Exception) {
            Log.e("PicturesRepository", "getPictures: ${e.message}")
            emptyList()
        }
    }

    override suspend fun getPicture(id: String): UnsplashPhoto {
        TODO("Not yet implemented")
    }

    override suspend fun searchPictures(query: String): List<UnsplashPhoto> {
        TODO("Not yet implemented")
    }
}