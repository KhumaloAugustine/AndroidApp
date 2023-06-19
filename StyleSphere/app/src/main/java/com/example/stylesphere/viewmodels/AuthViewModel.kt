package com.example.stylesphere.viewmodels
// viewmodels/AuthViewModel.kt
import androidx.lifecycle.ViewModel
import com.example.stylesphere.data.AuthRepository
import com.example.stylesphere.data.User

class AuthViewModel(private val authRepository: AuthRepository) : ViewModel() {
    fun registerUser(email: String, password: String) {
        authRepository.insertUser(email, password)
    }

    fun loginUser(email: String, password: String): User? {
        return authRepository.getUserByEmail(email)?.takeIf { it.password == password }
    }
}



