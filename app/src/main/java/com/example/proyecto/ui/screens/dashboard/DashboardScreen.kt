package com.example.proyecto.ui.screens.dashboard

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
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
fun DashboardScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Dashboard", fontWeight = FontWeight.Bold) },
                navigationIcon = {
                    IconButton(onClick = { /* TODO Open Drawer */ }) {
                        Text("menu") // Icon
                    }
                },
                actions = {
                    TextButton(onClick = { /* TODO Logout */ }) {
                         Text("logout", color = PrimaryBlue)
                         Spacer(modifier = Modifier.width(4.dp))
                         Text("Salir", color = PrimaryBlue, fontWeight = FontWeight.Bold)
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = SurfaceLight)
            )
        },
        containerColor = BackgroundLight
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            // Stats Section
            item {
                Text(
                    text = "Estadísticas Clave",
                    style = MaterialTheme.typography.titleLarge,
                    color = Color.Black
                )
                Spacer(modifier = Modifier.height(16.dp))
                
                // Grid of 2x2 cards
                Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
                    Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                        StatsCard(
                            label = "Usuarios Totales",
                            value = "1,250",
                            modifier = Modifier.weight(1f)
                        )
                        StatsCard(
                            label = "Empleadores",
                            value = "340",
                            modifier = Modifier.weight(1f)
                        )
                    }
                    Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                         StatsCard(
                            label = "Talentos Activos",
                            value = "910",
                            modifier = Modifier.weight(1f)
                        )
                        StatsCard(
                            label = "Tutores Verificados",
                            value = "150",
                            modifier = Modifier.weight(1f)
                        )
                    }
                }
            }
            
            // Charts Section (Mock)
            item {
                 Card(
                     colors = CardDefaults.cardColors(containerColor = SurfaceLight),
                     elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
                     shape = RoundedCornerShape(12.dp),
                     modifier = Modifier.fillMaxWidth()
                 ) {
                     Column(modifier = Modifier.padding(16.dp)) {
                         Text("Distribución de Habilidades", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
                         Text("Talentos por habilidad principal", style = MaterialTheme.typography.bodySmall, color = Color.Gray)
                         
                         Spacer(modifier = Modifier.height(16.dp))
                         
                         Row(
                             modifier = Modifier
                                 .fillMaxWidth()
                                 .height(200.dp),
                             horizontalArrangement = Arrangement.SpaceEvenly,
                             verticalAlignment = Alignment.Bottom
                         ) {
                             ChartBar("Diseño", 0.6f)
                             ChartBar("Dev", 0.8f)
                             ChartBar("Mktg", 0.45f)
                             ChartBar("Ventas", 0.3f)
                             ChartBar("Gestión", 0.7f)
                         }
                     }
                 }
            }
        }
    }
}

@Composable
fun StatsCard(label: String, value: String, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier,
        colors = CardDefaults.cardColors(containerColor = SurfaceLight),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        shape = RoundedCornerShape(12.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = label, style = MaterialTheme.typography.bodyMedium, color = Color.Gray)
            Text(text = value, style = MaterialTheme.typography.headlineMedium, fontWeight = FontWeight.Bold, color = Color.Black)
        }
    }
}

@Composable
fun ChartBar(label: String, heightNodes: Float) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom,
        modifier = Modifier.fillMaxHeight()
    ) {
        Box(
            modifier = Modifier
                .width(40.dp)
                .fillMaxHeight(heightNodes)
                .background(PrimaryBlue.copy(alpha = 0.2f), RoundedCornerShape(topStart = 4.dp, topEnd = 4.dp))
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = label, style = MaterialTheme.typography.labelSmall, fontWeight = FontWeight.Bold)
    }
}
