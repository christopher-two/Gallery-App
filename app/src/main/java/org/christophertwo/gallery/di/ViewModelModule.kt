package org.christophertwo.gallery.di

import org.christophertwo.gallery.presentation.screens.gallery.GalleryViewModel
import org.koin.core.module.Module
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val ViewModelModule: Module
    get() = module {
        viewModelOf(::GalleryViewModel)
    }