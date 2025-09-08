package org.christophertwo.gallery.di

import org.christophertwo.gallery.domain.usecase.GetPicturesUseCase
import org.koin.core.module.Module
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val DomainModule: Module
    get() = module {
        factoryOf(::GetPicturesUseCase)
    }