package ${PACKAGE_NAME}

interface Encrypt {
    suspend fun encryptText(
        algorithm: String,
        clearText: String,
        seed: String,
    ) : String

    suspend fun desencryptText(
        algorithm: String,
        clearText: String,
        seed: String,
    ) : String
}