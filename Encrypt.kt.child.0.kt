package ${PACKAGE_NAME}

import android.util.Base64
import java.security.Key
import java.security.MessageDigest
import javax.crypto.Cipher
import javax.crypto.spec.SecretKeySpec
import javax.inject.Inject

class EncryptImpl @Inject constructor() : Encrypt {

    override suspend fun encryptText(
        algorithm: String,
        clearText: String,
        seed: String ,
    ): String {
        val key = generateKey(seed = seed, algorithm = algorithm)
        val cipher = Cipher.getInstance(algorithm)
        cipher.init(Cipher.ENCRYPT_MODE, key)

        val encryptedByteValue = cipher.doFinal(clearText.toByteArray())
        return Base64.encodeToString(encryptedByteValue, Base64.DEFAULT)
    }

    override suspend fun desencryptText(
        algorithm: String,
        clearText: String,
        seed: String,
    ): String {
        val key = generateKey(seed = seed, algorithm = algorithm)
        val cipher = Cipher.getInstance(algorithm)
        cipher.init(Cipher.DECRYPT_MODE, key)

        val decryptedValue64 = Base64.decode(clearText, Base64.DEFAULT)
        val decryptedByteValue = cipher.doFinal(decryptedValue64)
        return String(decryptedByteValue)
    }

    private fun generateKey(seed: String, algorithm: String) : Key {
        val digest = MessageDigest.getInstance("SHA-256")
        val hash = digest.digest(seed.toByteArray())
        return SecretKeySpec(hash, algorithm)
    }
}