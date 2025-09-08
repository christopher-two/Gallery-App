package org.christophertwo.gallery.presentation.screens.gallery

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
// LocalContext ya no es necesario aquí si no se usa directamente en este archivo
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.christophertwo.gallery.presentation.components.PictureComponent
import org.christophertwo.gallery.presentation.components.picturePlaceholder
import org.christophertwo.gallery.presentation.theme.GalleryTheme

@Composable
fun GalleryRoot(
    viewModel: GalleryViewModel
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    GalleryScreen(
        state = state,
        onAction = viewModel::onAction
    )
}

@Composable
private fun GalleryScreen(
    state: GalleryState,
    onAction: (GalleryAction) -> Unit,
) {
    Scaffold(
        content = { padding ->
            GalleryContent(
                state = state,
                onAction = onAction,
                padding = padding
            )
        }
    )
}

@Composable
fun GalleryContent(state: GalleryState, onAction: (GalleryAction) -> Unit, padding: PaddingValues) {
    val context = LocalContext.current // Ya no es necesario aquí
    LazyVerticalStaggeredGrid(
        columns = StaggeredGridCells.Fixed(2),
        contentPadding = padding,
        content = {
            if (!state.isLoading) {
                items(state.pictures) { picture -> // Renombrado 'it' a 'picture' para claridad
                    Log.d("GalleryContent", "GalleryContent: ${picture.urls.full}")
                    PictureComponent(
                        imageUrl = picture.urls.full, // Usar la URL de la imagen del estado
                        ctx = context // ya no se pasa
                    )
                }
            } else {
                items(5) {
                    Box(
                        modifier = Modifier
                            .picturePlaceholder()
                            .size(100.dp)
                            .padding(8.dp)
                    )
                }
            }
        }
    )
}

@Preview
@Composable
private fun Preview() {
    GalleryTheme {
        GalleryScreen(
            state = GalleryState(),
            onAction = {}
        )
    }
}