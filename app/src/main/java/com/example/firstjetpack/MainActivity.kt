package com.example.firstjetpack

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.firstjetpack.ui.screens.FirstJetpackNavigationGraph
import com.example.firstjetpack.ui.screens.Routes
import com.example.firstjetpack.ui.screens.UserInputScreen
import com.example.firstjetpack.ui.screens.WelcomeScreen
import com.example.firstjetpack.ui.theme.FirstJetpackTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContent {
            FirstJetpackTheme {
                FirstJetpackApp()
            }
        }
    }

    @Composable
    fun FirstJetpackApp(){
        FirstJetpackNavigationGraph()
    }
}
