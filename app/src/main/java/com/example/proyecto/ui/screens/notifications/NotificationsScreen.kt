package com.example.proyecto.ui.screens.notifications

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.proyecto.ui.theme.BackgroundLight
import com.example.proyecto.ui.theme.PrimaryBlue
import com.example.proyecto.ui.theme.SurfaceLight

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NotificationsScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Notificaciones", fontWeight = FontWeight.Bold) },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = SurfaceLight),
                 navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Text("arrow_back")
                    }
                },
                actions = {
                    TextButton(onClick = { /* Mark all read */ }) {
                        Text("Marcar leídas", color = PrimaryBlue)
                    }
                }
            )
        },
        containerColor = BackgroundLight
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
        ) {
            item { NotificationItem("Nueva oportunidad", "Tech Solutions ha publicado un empleo que coincide con tu perfil.", "10 min", true) }
            item { NotificationItem("Mensaje recibido", "Ana García te envió un mensaje directo.", "1 hora", true) }
            item { NotificationItem("Postulación vista", "Tu postulación en Creative Studio ha sido vista.", "3 horas", false) }
            item { NotificationItem("Recordatorio", "Completa tu perfil para aumentar tu visibilidad.", "1 día", false) }
        }
    }
}

@Composable
fun NotificationItem(title: String, body: String, time: String, isUnread: Boolean) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(if (isUnread) PrimaryBlue.copy(alpha = 0.05f) else Color.Transparent)
            .padding(16.dp)
    ) {
        Row(crossAxisAlignment = CrossAxisAlignment.Start) {
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .background(PrimaryBlue.copy(alpha = 0.1f), CircleShape)
                    .padding(8.dp),
                contentAlignment = Alignment.Center
            ) {
                 Text("notifications", color = PrimaryBlue, style = MaterialTheme.typography.labelSmall) // Icon placeholder
            }
            Spacer(modifier = Modifier.width(16.dp))
            Column(modifier = Modifier.weight(1f)) {
                Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
                     Text(text = title, style = MaterialTheme.typography.bodyMedium, fontWeight = FontWeight.Bold)
                     Text(text = time, style = MaterialTheme.typography.labelSmall, color = Color.Gray)
                }
                Spacer(modifier = Modifier.height(4.dp))
                Text(text = body, style = MaterialTheme.typography.bodySmall, color = Color.DarkGray)
            }
            if (isUnread) {
                Spacer(modifier = Modifier.width(8.dp))
                Box(modifier = Modifier.size(8.dp).background(PrimaryBlue, CircleShape).align(Alignment.CenterVertically))
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Divider(color = Color.LightGray.copy(alpha = 0.5f))
    }
}
