package business.core.db

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class User(
    @SerialName("id")
    val id: Int,
    @SerialName("userLogin")
    val login: String,
    @SerialName("userPassword")
    val pass: String
)