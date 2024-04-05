package com.nomaddeveloper.accessmanager

import java.security.MessageDigest

private const val passwordHash = "e10adc3949ba59abbe56e057f20f883e" // 123456

class AccessManager {

    fun authenticate(username: String, password: String): Boolean {
        val hashedPassword = hashPassword(password)
        return username == "admin" && hashedPassword == passwordHash
    }

    private fun hashPassword(password: String): String {
        val bytes = password.toByteArray()
        val md = MessageDigest.getInstance("MD5")
        val digest = md.digest(bytes)
        return digest.joinToString("") { "%02x".format(it) }
    }
}