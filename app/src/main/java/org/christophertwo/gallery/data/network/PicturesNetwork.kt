package org.christophertwo.gallery.data.network

import android.util.Log
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.url
import org.christophertwo.gallery.domain.models.UnsplashPhoto

class PicturesNetwork(
    private val client: HttpClient
) {
    suspend fun getPictures(): List<UnsplashPhoto> {
        return try {
            client.get {
                headers.append("Authorization", "Client-ID TQCdTuLqMmmyUmuhj9uKFxLphyZvG5hq6L-zX2WHNpA")
                url("https://api.unsplash.com/photos")
            }.body<List<UnsplashPhoto>>()
        } catch (e: Exception) {
            Log.e("PicturesNetwork", "getPictures: ${e.message}")
            emptyList()
        }
    }
}