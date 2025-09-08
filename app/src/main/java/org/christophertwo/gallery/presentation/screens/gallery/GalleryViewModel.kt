package org.christophertwo.gallery.presentation.screens.gallery

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import org.christophertwo.gallery.domain.usecase.GetPicturesUseCase

class GalleryViewModel(
    private val getPicturesUseCase: GetPicturesUseCase
) : ViewModel() {
    private var hasLoadedInitialData = false

    private val _state = MutableStateFlow(GalleryState())
    val state = _state
        .onStart {
            if (!hasLoadedInitialData) {
                _state.value = _state.value.copy(
                    isLoading = true
                )
                val pictures = getPicturesUseCase()
                Log.d("GalleryViewModel", "state: ${pictures.first().urls.full}")
                _state.value = _state.value.copy(
                    pictures = pictures
                )
                _state.value = _state.value.copy(
                    isLoading = false
                )
                hasLoadedInitialData = true
            }
        }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000L),
            initialValue = GalleryState()
        )

    fun onAction(action: GalleryAction) {
        when (action) {
            else -> TODO("Handle actions")
        }
    }

}