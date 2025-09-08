package org.christophertwo.gallery.di

import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.christophertwo.gallery.api.PicturesRepository
import org.christophertwo.gallery.data.network.PicturesNetwork
import org.christophertwo.gallery.data.repository.PicturesRepositoryImpl
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val DataModule: Module
    get() = module {
        single<HttpClient> {
            HttpClient {
                expectSuccess = true
                install(ContentNegotiation) {
                    json(
                        Json {
                            prettyPrint = true
                            isLenient = true
                            ignoreUnknownKeys = true
                            encodeDefaults = true
                            coerceInputValues = true
                        }
                    )
                }
            }
        }
        singleOf(::PicturesNetwork)
        singleOf(::PicturesRepositoryImpl).bind(PicturesRepository::class)
    }