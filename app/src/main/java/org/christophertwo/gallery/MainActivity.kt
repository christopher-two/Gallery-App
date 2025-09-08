package org.christophertwo.gallery

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import org.christophertwo.gallery.presentation.navigation.Navigation
import org.christophertwo.gallery.presentation.theme.GalleryTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent(
            content = {
                GalleryTheme(
                    content = {
                        Surface(
                            color = colorScheme.background,
                            contentColor = colorScheme.onBackground,
                            modifier = Modifier.fillMaxSize(),
                            content = {
                                Navigation(
                                    navController = rememberNavController()
                                )
                            }
                        )
                    }
                )
            }
        )
    }
}