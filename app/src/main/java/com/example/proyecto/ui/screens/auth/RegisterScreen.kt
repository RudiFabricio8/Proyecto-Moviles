package com.example.proyecto.ui.screens.auth

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.proyecto.ui.theme.PrimaryBlue

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterScreen(
    onRegisterSuccess: () -> Unit,
    onLoginClick: () -> Unit
) {
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    var isTalent by remember { mutableStateOf(true) } // true = Talent, false = Employer

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF6F7F8))
            .padding(24.dp)
            .systemBarsPadding(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Icon
        Text("work_outline", color = PrimaryBlue) // Placeholder
        Spacer(modifier = Modifier.height(16.dp))
        
        Text("Crea tu Cuenta", style = MaterialTheme.typography.headlineMedium, fontWeight = FontWeight.Bold)
        Text("Únete a la comunidad", style = MaterialTheme.typography.bodyMedium, color = Color.Gray)
        
        Spacer(modifier = Modifier.height(32.dp))
        
        // Name
        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Nombre Completo") },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(8.dp),
            colors = TextFieldDefaults.outlinedTextFieldColors(containerColor = Color.White),
            singleLine = true
        )
        Spacer(modifier = Modifier.height(16.dp))
        
        // Email
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(8.dp),
            colors = TextFieldDefaults.outlinedTextFieldColors(containerColor = Color.White),
            singleLine = true
        )
        Spacer(modifier = Modifier.height(16.dp))
        
        // Password
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Contraseña") },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(8.dp),
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            colors = TextFieldDefaults.outlinedTextFieldColors(containerColor = Color.White),
            singleLine = true
        )
        Spacer(modifier = Modifier.height(16.dp))
        
        // Confirm Password
        OutlinedTextField(
            value = confirmPassword,
            onValueChange = { confirmPassword = it },
            label = { Text("Confirmar Contraseña") },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(8.dp),
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            colors = TextFieldDefaults.outlinedTextFieldColors(containerColor = Color.White),
            singleLine = true
        )
        
        Spacer(modifier = Modifier.height(24.dp))
        
        // Profile Selector
        Text("Elige tu perfil", style = MaterialTheme.typography.labelLarge)
        Spacer(modifier = Modifier.height(8.dp))
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(16.dp)) {
            // Talent Button
            OutlinedButton(
                onClick = { isTalent = true },
                modifier = Modifier.weight(1f).height(50.dp),
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.outlinedButtonColors(
                    containerColor = if (isTalent) PrimaryBlue.copy(alpha = 0.1f) else Color.White,
                    contentColor = if (isTalent) PrimaryBlue else Color.Gray
                ),
                border = if (isTalent) androidx.compose.foundation.BorderStroke(2.dp, PrimaryBlue) else ButtonDefaults.outlinedButtonBorder
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text("person") // Icon
                    Spacer(modifier = Modifier.width(8.dp))
                    Text("Talento")
                }
            }
            
            // Employer Button
            OutlinedButton(
                onClick = { isTalent = false },
                modifier = Modifier.weight(1f).height(50.dp),
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.outlinedButtonColors(
                    containerColor = if (!isTalent) PrimaryBlue.copy(alpha = 0.1f) else Color.White,
                    contentColor = if (!isTalent) PrimaryBlue else Color.Gray
                ),
                border = if (!isTalent) androidx.compose.foundation.BorderStroke(2.dp, PrimaryBlue) else ButtonDefaults.outlinedButtonBorder
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text("corporate_fare") // Icon
                    Spacer(modifier = Modifier.width(8.dp))
                    Text("Empleador")
                }
            }
        }
        
        Spacer(modifier = Modifier.height(32.dp))
        
        Button(
            onClick = onRegisterSuccess,
            modifier = Modifier.fillMaxWidth().height(50.dp),
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(containerColor = PrimaryBlue)
        ) {
            Text("Registrarse", fontWeight = FontWeight.Bold)
        }
        
        Spacer(modifier = Modifier.height(16.dp))
        
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text("¿Ya tienes una cuenta? ", color = Color.Gray)
            Text(
                text = "Inicia Sesión",
                color = PrimaryBlue,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.clickable { onLoginClick() }
            )
        }
    }
}
