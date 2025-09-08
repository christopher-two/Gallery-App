package org.christophertwo.gallery.domain.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Representa el objeto topic_submissions.
 */
@Serializable
data class TopicSubmissions(
    @SerialName("people")
    val people: People? = null, // Añadido para manejar la clave 'people'
    // Puedes añadir otras propiedades aquí si la API las devuelve.
    // Considera configurar el Json { ignoreUnknownKeys = true } globalmente
    // si no quieres declarar todos los campos posibles.
)

/**
 * Representa el objeto anidado 'people' dentro de 'topic_submissions'.
 * Ajusta los campos según la estructura real de este objeto en el JSON.
 */
@Serializable
data class People(
    val status: String? = null
    // Agrega aquí otros campos que pueda contener el objeto 'people'
)

// Ejemplo de cómo podrías tener una clase genérica si la estructura varía mucho
// o si prefieres no modelar explícitamente cada campo que podría no estar siempre presente.
// @Serializable
// data class TopicSubmissions(
//     @SerialName("people")
//     val people: JsonElement? = null, // Permite cualquier estructura JSON para 'people'
//     // ... otros campos conocidos ...
// )
//
// Y en tu Ktor HttpClient, asegúrate de que el Json está configurado para ignorar claves desconocidas:
// install(ContentNegotiation) {
//     json(Json {
//         prettyPrint = true
//         isLenient = true
//         ignoreUnknownKeys = true // ¡Importante!
//     })
// }