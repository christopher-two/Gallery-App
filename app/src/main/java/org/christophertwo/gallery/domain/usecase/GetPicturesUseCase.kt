package org.christophertwo.gallery.domain.usecase

import org.christophertwo.gallery.api.PicturesRepository
import org.christophertwo.gallery.domain.models.UnsplashPhoto

class GetPicturesUseCase(
    private val repository: PicturesRepository
) {
    suspend operator fun invoke(): List<UnsplashPhoto> {
        return repository.getPictures()
    }
}