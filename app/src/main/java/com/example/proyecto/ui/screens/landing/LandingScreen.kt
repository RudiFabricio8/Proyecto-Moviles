package com.example.proyecto.ui.screens.landing

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.proyecto.ui.theme.PrimaryBlue

@Composable
fun LandingScreen(
    onLoginClick: () -> Unit,
    onRegisterClick: () -> Unit
) {
    Box(modifier = Modifier.fillMaxSize()) {
        // Background Image with Overlay
        AsyncImage(
            model = "https://lh3.googleusercontent.com/aida-public/AB6AXuDVm6Z6wEyUY9EhojXrrV6KAHP-ol66E2VrruS4ON6ULdZrgMbfxckGz2MNrD4JkvgzEcvfwoDaEDQrf5-BlYzMEmHCuddOSB3ZV85VY3BIyXTooe11rpdRNjXQFGaY7d5kWs4Ohi5IlhvGIKXRZTdwMLLicbOLi23hzKjYIqz0fZI9QgycoYwmnCOTa_plo-qGPmZuJMp73GYvrxMC567xoy-Y6FwQtM5pHIEwYSwG6sbeqZ-3L15SBl9k07n8focKx5G6d4kkiF8",
            contentDescription = "Background",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        
        // Gradient Overlay (Darken)
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                             Color.Black.copy(alpha = 0.5f),
                             Color.Black.copy(alpha = 0.7f)
                        )
                    )
                )
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp)
                .systemBarsPadding(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            // Header
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) {
                TextButton(
                    onClick = onLoginClick,
                    colors = ButtonDefaults.textButtonColors(contentColor = Color.White)
                ) {
                    Text("Iniciar Sesión", fontWeight = FontWeight.Bold)
                }
                Spacer(modifier = Modifier.width(8.dp))
                Button(
                    onClick = onRegisterClick,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.White.copy(alpha = 0.2f)
                    ),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Text("Registrarse", fontWeight = FontWeight.Bold)
                }
            }

            // Center Content
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                // Icon + Title
                 Row(verticalAlignment = Alignment.CenterVertically) {
                     // Use a text icon or Icon composable if you have resource
                     // <span class="material-symbols-outlined text-4xl">workspaces</span>
                     // Using just text/placeholder for icon in default material
                     Text("connect_up", color = Color.White) // placeholder for icon
                     Spacer(modifier = Modifier.width(8.dp))
                     Text("ConectandoTalento", color = Color.White, fontWeight = FontWeight.Bold, fontSize = 20.sp)
                 }
                 Spacer(modifier = Modifier.height(16.dp))
                 
                 Text(
                     text = "Conectando Talento con Oportunidades",
                     style = MaterialTheme.typography.displayMedium, // Approx 45sp
                     color = Color.White,
                     textAlign = TextAlign.Center
                 )
                 
                 Spacer(modifier = Modifier.height(16.dp))
                 
                 Text(
                     text = "Descubre la plataforma que une a los mejores profesionales con las empresas más innovadoras. Tu próximo gran paso profesional empieza aquí.",
                     style = MaterialTheme.typography.bodyLarge,
                     color = Color.Gray, // text-gray-200
                     textAlign = TextAlign.Center
                 )
                 
                 Spacer(modifier = Modifier.height(32.dp))
                 
                 // Action Buttons
                 Column(
                     modifier = Modifier.fillMaxWidth(),
                     horizontalAlignment = Alignment.CenterHorizontally,
                     verticalArrangement = Arrangement.spacedBy(12.dp)
                 ) {
                     Button(
                         onClick = { /* TODO filter talent */ },
                         modifier = Modifier.fillMaxWidth().height(48.dp),
                         colors = ButtonDefaults.buttonColors(containerColor = PrimaryBlue),
                         shape = RoundedCornerShape(8.dp)
                     ) {
                         Text("Encontrar Talento", fontWeight = FontWeight.Bold)
                     }
                     
                     Button(
                         onClick = { /* TODO search jobs */ },
                         modifier = Modifier.fillMaxWidth().height(48.dp),
                         colors = ButtonDefaults.buttonColors(
                             containerColor = Color.White.copy(alpha = 0.9f),
                             contentColor = Color.Black
                         ),
                         shape = RoundedCornerShape(8.dp)
                     ) {
                         Text("Buscar Empleo", fontWeight = FontWeight.Bold)
                     }
                 }
            }
            
            Spacer(modifier = Modifier.height(56.dp)) // Bottom spacer
        }
    }
}
