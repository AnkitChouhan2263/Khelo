package com.example.khelo

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.khelo.data.model.Player
import com.example.khelo.data.model.User
import com.example.khelo.ui.theme.AccentYellow
import com.example.khelo.ui.theme.AccentYellowDark
import com.example.khelo.ui.theme.Purple40
import com.example.khelo.ui.theme.SecondaryGreen

@Composable
fun ProfileCard(user: User, player: Player?, navController: NavHostController){
    Card(onClick = {navController.navigate("profile")}, modifier = Modifier.fillMaxWidth(), elevation = CardDefaults.cardElevation(defaultElevation = 20.dp , pressedElevation = 0.dp)) {
        Column (modifier = Modifier.background(Purple40.copy(alpha = .6f))){
            Row (verticalAlignment = Alignment.CenterVertically , horizontalArrangement = Arrangement.SpaceEvenly , modifier = Modifier.padding(10.dp)){
                Image(painterResource(R.drawable.default_profile_image), contentDescription = "" ,
                    modifier = Modifier
                        .border(width = 2.dp, color = Color.Gray, shape = CircleShape)
                        .clip(CircleShape)
                        .size(60.dp))
                Column(modifier = Modifier.padding(horizontal = 10.dp)){
                    Text(user.name, fontSize = 25.sp)
                    Text(user.phoneNumber)
                    Text(user.email)
                }
            }
            HorizontalDivider()
            Row {
                Text("Right Handed Batsman , Right Arm Leg Spinner" , modifier = Modifier.padding(10.dp))
            }
            HorizontalDivider()
            Row {
                Row (horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.padding(10.dp).fillMaxWidth()){

                    val alignment= Alignment.CenterHorizontally
                    Column (horizontalAlignment = alignment){
                        Text("Matches")
                        Text("0")

                    }
                    Column (horizontalAlignment = alignment){
                        Text("Runs")
                        Text("2640")

                    }
                    Column (horizontalAlignment = alignment){
                        Text("Wickets")
                        Text("5")

                    }
                    Column (horizontalAlignment = alignment){
                        Text("catches")
                        Text("1")

                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewProfileCard(){
//    ProfileCard()
}
