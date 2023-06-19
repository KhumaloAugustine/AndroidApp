package com.example.stylesphere.ui
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.stylesphere.R
import com.example.stylesphere.viewmodels.AuthViewModel


@Composable
fun LoginActivity(authViewModel: AuthViewModel = viewModel()) {
    val emailState = remember { mutableStateOf("") }
    val passwordState = remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = stringResource(R.string.login_title), // Replace with your own string resource
            style = MaterialTheme.typography.h4
        )

        TextField(
            value = emailState.value,
            onValueChange = { emailState.value = it },
            label = { Text(text = stringResource(R.string.email_label)) } // Replace with your own string resource
        )

        TextField(
            value = passwordState.value,
            onValueChange = { passwordState.value = it },
            label = { Text(text = stringResource(R.string.password_label)) } // Replace with your own string resource
        )

        Button(
            onClick = {
                val email = emailState.value
                val password = passwordState.value

                val user = authViewModel.loginUser(email, password)
                if (user != null) {
                    // User is authenticated
                } else {
                    // Show login error
                }
            },
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Text(text = stringResource(R.string.login_button_label)) // Replace with your own string resource
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewLoginActivity() {
    LoginActivity()
}
