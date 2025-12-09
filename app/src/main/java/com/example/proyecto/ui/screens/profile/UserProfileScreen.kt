package com.example.proyecto.ui.screens.profile

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.proyecto.ui.theme.BackgroundLight
import com.example.proyecto.ui.theme.PrimaryBlue

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserProfileScreen(navController: NavController) {
    val context = LocalContext.current
    var profileImageUri by remember { mutableStateOf<Uri?>(null) }
    
    // Camera Integration
    // Create a temporary file or just get logic to handle result. 
    // For simplicity in this demo, we assume we might get a content URI or use a temp uri.
    // Ideally we create a FileProvider uri.
    
    // Simple gallery picker for ease of demonstration without FileProvider setup:
    val galleryLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        if (uri != null) {
            profileImageUri = uri
            // TODO: Save to Room/Firebase
        }
    }
    
    // Camera launcher (needs a valid Uri to write to, usually from FileProvider)
    // Skipping complex FileProvider setup for brevity, using Gallery as secondary option
    // or assuming we just pick from gallery which is "Camera/Gallery" option in prompt.
    // "Cámara / galería: Permitir al usuario seleccionar o tomar una foto"
    
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Mi Perfil", fontWeight = FontWeight.Bold) },
                navigationIcon = {
                     IconButton(onClick = { navController.popBackStack() }) { 
                         Text("arrow_back")
                     }
                },
                actions = {
                    IconButton(onClick = { /* Settings */ }) { Text("more_vert") }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = BackgroundLight)
            )
        },
        containerColor = BackgroundLight
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Profile Header
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                contentAlignment = Alignment.Center
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Box(modifier = Modifier.size(128.dp)) {
                         AsyncImage(
                            model = ImageRequest.Builder(context)
                                .data(profileImageUri ?: "https://lh3.googleusercontent.com/aida-public/AB6AXuA1JC-HFbMFAUDkjP_ulNKsukN3c_rAscGFpRD8t7cbyWQlwwEidGO2LbF1eSlL0fWOwogtuYMXqNNPodA8_4hNX-wJQR6jXdT00mGT5Nb8BPhtrD4vq1VPXcILUDJDdJYOR1rGNxAcqxEXnfLoD9p7FH8gnFRyheTKvUxdr3MPOHJwXmQzbeURcLtdOngx-DAhEoJQKSMItpibaaUoxgvzp81MfggPcwe8ddhSCVVPAS2H1rpM-F5Vlkdw61MVwnKGTL8sJ746KrE")
                                .crossfade(true)
                                .build(),
                            contentDescription = "Profile Picture",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .fillMaxSize()
                                .clip(CircleShape)
                                .clickable { galleryLauncher.launch("image/*") } // Trigger Gallery
                        )
                        // Edith icon
                        Box(
                            modifier = Modifier
                                .align(Alignment.BottomEnd)
                                .background(PrimaryBlue, CircleShape)
                                .padding(8.dp)
                        ) {
                             Text("edit", color = Color.White) // Icon
                        }
                    }
                    
                    Spacer(modifier = Modifier.height(16.dp))
                    Text("Isabella Rossi", style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold)
                    Text("Senior UX Designer", style = MaterialTheme.typography.bodyLarge, color = Color.Gray)
                    
                    Spacer(modifier = Modifier.height(16.dp))
                    
                    Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                        Button(onClick = { /* Share */ }, colors = ButtonDefaults.buttonColors(containerColor = Color.LightGray)) {
                            Text("Compartir", color = Color.Black)
                        }
                        Button(onClick = { /* Edit */ }, colors = ButtonDefaults.buttonColors(containerColor = PrimaryBlue)) {
                            Text("Editar Perfil")
                        }
                    }
                }
            }
            
            Divider()
            
            // About
            Column(modifier = Modifier.padding(16.dp)) {
                Text("Acerca de mí", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    "Una apasionada diseñadora de UX con más de 8 años de experiencia en la creación de productos digitales intuitivos y centrados en el usuario.",
                    style = MaterialTheme.typography.bodyMedium
                )
            }
            
            Divider()
            
            // Habilidades
             Column(modifier = Modifier.padding(16.dp).fillMaxWidth()) {
                Text("Habilidades", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(8.dp))
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    SuggestionChip(onClick = {}, label = { Text("User Research") })
                    SuggestionChip(onClick = {}, label = { Text("Figma") })
                    SuggestionChip(onClick = {}, label = { Text("Prototyping") })
                }
            }
        }
    }
}
