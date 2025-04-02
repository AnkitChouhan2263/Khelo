package com.example.khelo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()
        }
    }
}

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = "login") {
        composable("login") {
            LoginScreen(navController)
        }
        composable("register") {
            RegistrationScreen(navController)
        }
        composable("profile") {
            ProfileScreen(navController)
        }
        composable(HomeScreen.route) {
            HomeScreen(navController)
        }
        composable(SearchScreen.route) {
            SearchScreen(navController)
        }
        composable(ShopScreen.route) {
            ShopScreen(navController)
        }
        composable(StartAMatchScreen.route) {
            StartAMatchScreen(navController)
        }
        composable("CaptainSelectionScreen") {
            // Pass empty lists and dummy values as placeholders
            // These should be replaced with actual data in a real implementation
            CaptainSelectionScreen(
                navController = navController,
                team1Players = emptyList(),
                team2Players = emptyList(),
                team1Name = null,
                team2Name = null,
                tossWinner = null,
                tossDecision = null
            )
        }
        composable(
            "CaptainSelectionScreen?team1Players={team1Players}&team2Players={team2Players}&team1Name={team1Name}&team2Name={team2Name}&tossWinner={tossWinner}&tossDecision={tossDecision}",
            arguments = listOf(
                navArgument("team1Players") { type = NavType.StringType },
                navArgument("team2Players") { type = NavType.StringType },
                navArgument("team1Name") { type = NavType.StringType },
                navArgument("team2Name") { type = NavType.StringType },
                navArgument("tossWinner") { type = NavType.StringType },
                navArgument("tossDecision") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            CaptainSelectionScreen(
                navController = navController,
                team1Players = backStackEntry.arguments?.getString("team1Players")?.split(",") ?: emptyList(),
                team2Players = backStackEntry.arguments?.getString("team2Players")?.split(",") ?: emptyList(),
                team1Name = backStackEntry.arguments?.getString("team1Name"),
                team2Name = backStackEntry.arguments?.getString("team2Name"),
                tossWinner = backStackEntry.arguments?.getString("tossWinner"),
                tossDecision = backStackEntry.arguments?.getString("tossDecision")
            )
        }
        composable(
            "LineupSelectionScreen?team1Players={team1Players}&team2Players={team2Players}&team1Name={team1Name}&team2Name={team2Name}&tossWinner={tossWinner}&tossDecision={tossDecision}&team1Captain={team1Captain}&team1ViceCaptain={team1ViceCaptain}&team2Captain={team2Captain}&team2ViceCaptain={team2ViceCaptain}",
            arguments = listOf(
                navArgument("team1Players") { type = NavType.StringType },
                navArgument("team2Players") { type = NavType.StringType },
                navArgument("team1Name") { type = NavType.StringType },
                navArgument("team2Name") { type = NavType.StringType },
                navArgument("tossWinner") { type = NavType.StringType },
                navArgument("tossDecision") { type = NavType.StringType },
                navArgument("team1Captain") { type = NavType.StringType },
                navArgument("team1ViceCaptain") { type = NavType.StringType },
                navArgument("team2Captain") { type = NavType.StringType },
                navArgument("team2ViceCaptain") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            LineupSelectionScreen(
                navController = navController,
                team1Players = backStackEntry.arguments?.getString("team1Players")?.split(",") ?: emptyList(),
                team2Players = backStackEntry.arguments?.getString("team2Players")?.split(",") ?: emptyList(),
                team1Name = backStackEntry.arguments?.getString("team1Name"),
                team2Name = backStackEntry.arguments?.getString("team2Name"),
                tossWinner = backStackEntry.arguments?.getString("tossWinner"),
                tossDecision = backStackEntry.arguments?.getString("tossDecision"),
                team1Captain = backStackEntry.arguments?.getString("team1Captain"),
                team1ViceCaptain = backStackEntry.arguments?.getString("team1ViceCaptain"),
                team2Captain = backStackEntry.arguments?.getString("team2Captain"),
                team2ViceCaptain = backStackEntry.arguments?.getString("team2ViceCaptain")
            )
        }
        composable(
            "StartAMatchScreen2?team1Name={team1Name}&team2Name={team2Name}&totalOvers={totalOvers}",
            arguments = listOf(
                navArgument("team1Name") { type = NavType.StringType },
                navArgument("team2Name") { type = NavType.StringType },
                navArgument("totalOvers") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val team1Name = backStackEntry.arguments?.getString("team1Name") ?: ""
            val team2Name = backStackEntry.arguments?.getString("team2Name") ?: ""
            val totalOvers = backStackEntry.arguments?.getString("totalOvers") ?: "20"
            StartAMatchScreen2(
                navController = navController,
                team1Name = team1Name,
                team2Name = team2Name,
                totalOvers = totalOvers
            )
        }
        composable(
            "TossAndPlaying11Screen?team1Players={team1Players}&team2Players={team2Players}&team1Name={team1Name}&team2Name={team2Name}&totalOvers={totalOvers}",
            arguments = listOf(
                navArgument("team1Players") { type = NavType.StringType },
                navArgument("team2Players") { type = NavType.StringType },
                navArgument("team1Name") { type = NavType.StringType },
                navArgument("team2Name") { type = NavType.StringType },
                navArgument("totalOvers") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val team1Players = backStackEntry.arguments?.getString("team1Players")?.split(",") ?: emptyList()
            val team2Players = backStackEntry.arguments?.getString("team2Players")?.split(",") ?: emptyList()
            val team1Name = backStackEntry.arguments?.getString("team1Name") ?: ""
            val team2Name = backStackEntry.arguments?.getString("team2Name") ?: ""
            val totalOvers = backStackEntry.arguments?.getString("totalOvers") ?: "20"
            TossAndPlaying11Screen(
                navController = navController,
                team1Players = team1Players,
                team2Players = team2Players,
                team1Name = team1Name,
                team2Name = team2Name,
                totalOvers = totalOvers
            )
        }
        composable(
            "CaptainSelectionScreen?team1Players={team1Players}&team2Players={team2Players}&team1Name={team1Name}&team2Name={team2Name}&tossWinner={tossWinner}&tossDecision={tossDecision}",
            arguments = listOf(
                navArgument("team1Players") { type = NavType.StringType },
                navArgument("team2Players") { type = NavType.StringType },
                navArgument("team1Name") { type = NavType.StringType },
                navArgument("team2Name") { type = NavType.StringType },
                navArgument("tossWinner") { type = NavType.StringType },
                navArgument("tossDecision") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val team1Players = backStackEntry.arguments?.getString("team1Players")?.split(",") ?: emptyList()
            val team2Players = backStackEntry.arguments?.getString("team2Players")?.split(",") ?: emptyList()
            val team1Name = backStackEntry.arguments?.getString("team1Name") ?: "Team 1"
            val team2Name = backStackEntry.arguments?.getString("team2Name") ?: "Team 2"
            val tossWinner = backStackEntry.arguments?.getString("tossWinner") ?: ""
            val tossDecision = backStackEntry.arguments?.getString("tossDecision") ?: ""

            @Composable
            fun Content() {
                CaptainSelectionScreen(
                    navController = navController,
                    team1Players = team1Players,
                    team2Players = team2Players,
                    team1Name = team1Name,
                    team2Name = team2Name,
                    tossWinner = tossWinner,
                    tossDecision = tossDecision
                )
            }

            Content()
        }
        composable(
            "MatchScoringScreen?team1Name={team1Name}&team2Name={team2Name}&tossWinner={tossWinner}&tossDecision={tossDecision}&openingBatsman1={openingBatsman1}&openingBatsman2={openingBatsman2}&openingBowler={openingBowler}&wicketKeeper={wicketKeeper}&battingTeam={battingTeam}&bowlingTeam={bowlingTeam}",
            arguments = listOf(
                navArgument("team1Name") { type = NavType.StringType },
                navArgument("team2Name") { type = NavType.StringType },
                navArgument("tossWinner") { type = NavType.StringType },
                navArgument("tossDecision") { type = NavType.StringType },
                navArgument("openingBatsman1") { type = NavType.StringType },
                navArgument("openingBatsman2") { type = NavType.StringType },
                navArgument("openingBowler") { type = NavType.StringType },
                navArgument("wicketKeeper") { type = NavType.StringType },
                navArgument("battingTeam") { type = NavType.StringType },
                navArgument("bowlingTeam") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val team1Name = backStackEntry.arguments?.getString("team1Name") ?: ""
            val team2Name = backStackEntry.arguments?.getString("team2Name") ?: ""
            val tossWinner = backStackEntry.arguments?.getString("tossWinner") ?: ""
            val tossDecision = backStackEntry.arguments?.getString("tossDecision") ?: ""
            val openingBatsman1 = backStackEntry.arguments?.getString("openingBatsman1") ?: ""
            val openingBatsman2 = backStackEntry.arguments?.getString("openingBatsman2") ?: ""
            val openingBowler = backStackEntry.arguments?.getString("openingBowler") ?: ""
            val wicketKeeper = backStackEntry.arguments?.getString("wicketKeeper") ?: ""
            val battingTeam = backStackEntry.arguments?.getString("battingTeam") ?: ""
            val bowlingTeam = backStackEntry.arguments?.getString("bowlingTeam") ?: ""
            
            MatchScoringScreen(
                navController = navController,
                team1Name = team1Name,
                team2Name = team2Name,
                tossWinner = tossWinner,
                tossDecision = tossDecision,
                openingBatsman1 = openingBatsman1,
                openingBatsman2 = openingBatsman2,
                openingBowler = openingBowler,
                wicketKeeper = wicketKeeper,
                battingTeam = battingTeam,
                bowlingTeam = bowlingTeam
            )
        }
//        composable(
//            "liveScoring/{matchId}",
//            arguments = listOf(
//                navArgument("matchId") { type = NavType.StringType }
//            )
//        ) { backStackEntry ->
//            val matchId = backStackEntry.arguments?.getString("matchId") ?: ""
//            LiveScoringScreen(
//                navController = navController,
//                matchId = matchId
//            )
//        }
        
        composable(
            route = "ScoringScreen?team1Name={team1Name}&team2Name={team2Name}&team1Players={team1Players}&team2Players={team2Players}&tossWinner={tossWinner}&tossDecision={tossDecision}&team1Captain={team1Captain}&team1ViceCaptain={team1ViceCaptain}&team2Captain={team2Captain}&team2ViceCaptain={team2ViceCaptain}&striker={striker}&nonStriker={nonStriker}&bowler={bowler}&wicketkeeper={wicketkeeper}&battingTeamName={battingTeamName}&bowlingTeamName={bowlingTeamName}&totalOvers={totalOvers}",
            arguments = listOf(
                navArgument("team1Name") { type = NavType.StringType },
                navArgument("team2Name") { type = NavType.StringType },
                navArgument("team1Players") { type = NavType.StringType },
                navArgument("team2Players") { type = NavType.StringType },
                navArgument("tossWinner") { type = NavType.StringType },
                navArgument("tossDecision") { type = NavType.StringType },
                navArgument("team1Captain") { type = NavType.StringType },
                navArgument("team1ViceCaptain") { type = NavType.StringType },
                navArgument("team2Captain") { type = NavType.StringType },
                navArgument("team2ViceCaptain") { type = NavType.StringType },
                navArgument("striker") { type = NavType.StringType },
                navArgument("nonStriker") { type = NavType.StringType },
                navArgument("bowler") { type = NavType.StringType },
                navArgument("wicketkeeper") { type = NavType.StringType },
                navArgument("battingTeamName") { type = NavType.StringType },
                navArgument("bowlingTeamName") { type = NavType.StringType },
                navArgument("totalOvers") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val team1Name = backStackEntry.arguments?.getString("team1Name") ?: ""
            val team2Name = backStackEntry.arguments?.getString("team2Name") ?: ""
            val team1PlayersStr = backStackEntry.arguments?.getString("team1Players") ?: ""
            val team2PlayersStr = backStackEntry.arguments?.getString("team2Players") ?: ""
            val tossWinner = backStackEntry.arguments?.getString("tossWinner") ?: ""
            val tossDecision = backStackEntry.arguments?.getString("tossDecision") ?: ""
            val team1Captain = backStackEntry.arguments?.getString("team1Captain") ?: ""
            val team1ViceCaptain = backStackEntry.arguments?.getString("team1ViceCaptain") ?: ""
            val team2Captain = backStackEntry.arguments?.getString("team2Captain") ?: ""
            val team2ViceCaptain = backStackEntry.arguments?.getString("team2ViceCaptain") ?: ""
            val striker = backStackEntry.arguments?.getString("striker") ?: ""
            val nonStriker = backStackEntry.arguments?.getString("nonStriker") ?: ""
            val bowler = backStackEntry.arguments?.getString("bowler") ?: ""
            val wicketkeeper = backStackEntry.arguments?.getString("wicketkeeper") ?: ""
            val battingTeam = backStackEntry.arguments?.getString("battingTeamName") ?: ""
            val bowlingTeam = backStackEntry.arguments?.getString("bowlingTeamName") ?: ""
            val totalOversStr = backStackEntry.arguments?.getString("totalOvers") ?: "20"
            val totalOvers = totalOversStr.toIntOrNull() ?: 20
            
            val team1Players = if (team1PlayersStr.isNotEmpty()) team1PlayersStr.split(",") else emptyList()
            val team2Players = if (team2PlayersStr.isNotEmpty()) team2PlayersStr.split(",") else emptyList()
            
            ScoringScreen(
                navController = navController,
                team1Name = team1Name,
                team2Name = team2Name,
                team1Players = team1Players,
                team2Players = team2Players,
                tossWinner = tossWinner,
                tossDecision = tossDecision,
                team1Captain = team1Captain,
                team1ViceCaptain = team1ViceCaptain,
                team2Captain = team2Captain,
                team2ViceCaptain = team2ViceCaptain,
                striker = striker,
                nonStriker = nonStriker,
                bowler = bowler,
                wicketkeeper = wicketkeeper,
                battingTeam = battingTeam,
                bowlingTeam = bowlingTeam,
                totalOvers = totalOvers
            )
        }
        
        composable(StartATournamentScreen.route) {
            StartATournamentScreen(navController)
        }
    }
}

@Preview
@Composable
fun PreviewMainScreen(){
    MainScreen()
}
