package com.example.proyecto.ui.screens.dashboard

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
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
fun ReportsScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Reportes y Analíticas", fontWeight = FontWeight.Bold) },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = SurfaceLight),
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Text("arrow_back")
                    }
                }
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
            // Summary Cards
            item {
                Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                    ReportSummaryCard("Vistas de Perfil", "+12.5%", "1,204", Color(0xFF16A34A), Modifier.weight(1f))
                    ReportSummaryCard("Postulaciones", "+5.2%", "48", PrimaryBlue, Modifier.weight(1f))
                }
            }
            
            // Detailed Stats
            item {
                Card(
                    colors = CardDefaults.cardColors(containerColor = SurfaceLight),
                    shape = RoundedCornerShape(12.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text("Actividad Semanal", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
                        Spacer(modifier = Modifier.height(24.dp))
                        
                        // Mock Bar Chart
                        Row(
                            modifier = Modifier.fillMaxWidth().height(150.dp),
                            horizontalArrangement = Arrangement.SpaceEvenly,
                            verticalAlignment = Alignment.Bottom
                        ) {
                             MockBar("Lun", 0.4f)
                             MockBar("Mar", 0.7f)
                             MockBar("Mie", 0.5f)
                             MockBar("Jue", 0.9f)
                             MockBar("Vie", 0.6f)
                             MockBar("Sab", 0.3f)
                             MockBar("Dom", 0.2f)
                        }
                    }
                }
            }
            
            // Recent Activity List
             item {
                Text("Actividad Reciente", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(8.dp))
             }
             
             items(3) {
                 ListItem(
                     headlineContent = { Text("Descarga de CV", fontWeight = FontWeight.Bold) },
                     supportingContent = { Text("Empresa Tech Solutions", color = Color.Gray) },
                     trailingContent = { Text("Hace 2h", style = MaterialTheme.typography.labelSmall) },
                     leadingContent = { 
                         Box(modifier = Modifier.size(40.dp).background(Color(0xFFE0E7FF), RoundedCornerShape(8.dp)), contentAlignment = Alignment.Center) {
                             Text("file_download") // Icon
                         }
                     },
                     colors = ListItemDefaults.colors(containerColor = SurfaceLight)
                 )
                 Divider()
             }
        }
    }
}

@Composable
fun ReportSummaryCard(title: String, percentage: String, count: String, color: Color, modifier: Modifier) {
    Card(
        modifier = modifier,
        colors = CardDefaults.cardColors(containerColor = SurfaceLight),
        shape = RoundedCornerShape(12.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(title, style = MaterialTheme.typography.labelMedium, color = Color.Gray)
            Spacer(modifier = Modifier.height(8.dp))
            Text(count, style = MaterialTheme.typography.headlineSmall, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(4.dp))
            Box(
                modifier = Modifier
                    .background(color.copy(alpha = 0.1f), RoundedCornerShape(4.dp))
                    .padding(horizontal = 4.dp, vertical = 2.dp)
            ) {
                Text(percentage, color = color, style = MaterialTheme.typography.labelSmall, fontWeight = FontWeight.Bold)
            }
        }
    }
}

@Composable
fun MockBar(label: String, heightNodes: Float) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Box(
            modifier = Modifier
                .width(20.dp)
                .fillMaxHeight(heightNodes)
                .background(PrimaryBlue, RoundedCornerShape(topStart = 4.dp, topEnd = 4.dp))
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(label, style = MaterialTheme.typography.labelSmall, color = Color.Gray)
    }
}
