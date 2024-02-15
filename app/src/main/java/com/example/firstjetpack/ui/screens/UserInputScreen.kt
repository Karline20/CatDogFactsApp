package com.example.firstjetpack.ui.screens

import android.util.Log
import androidx.compose.animation.expandVertically
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.firstjetpack.R
import com.example.firstjetpack.data.UserDataUIEvents
import com.example.firstjetpack.ui.AnimalCard
import com.example.firstjetpack.ui.ButtonComponent
import com.example.firstjetpack.ui.TextComponent
import com.example.firstjetpack.ui.TextFieldComponent
import com.example.firstjetpack.ui.TopBar
import com.example.firstjetpack.ui.UserInputViewModel

@Composable
fun UserInputScreen(
    userInputViewModel: UserInputViewModel,
    showWelcomeScreen: (valuesPair: Pair<String, String>) -> Unit) {
    Surface(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(18.dp)
        ) {
            TopBar("Hi there \uD83D\uDE0A")

            TextComponent(
                textValue = "Let's learn about you!",
                textSize = 24.sp
            )
            
            Spacer(modifier = Modifier.size(20.dp))

            TextComponent(
                textValue = "This app will prepare a details page based on input provided by you",
                textSize = 18.sp
            )

            Spacer(modifier = Modifier.size(60.dp))


            TextComponent(
                textValue = "Name",
                textSize = 18.sp
            )

            Spacer(modifier = Modifier.size(10.dp))

            TextFieldComponent(onTextChanged = {
                userInputViewModel.onEvent(
                    UserDataUIEvents.UserNameEntered(it)
                )
            })

            Spacer(modifier = Modifier.size(20.dp))

            TextComponent(
                textValue = "What do you like?",
                textSize = 18.sp
            )

            Spacer(modifier = Modifier.size(20.dp))

            Row(modifier = Modifier.fillMaxWidth()){
                AnimalCard(image = R.drawable.cat, animalSelected = {
                    userInputViewModel.onEvent(
                        UserDataUIEvents.AnimalSelected(it)
                    )
                }, selected = userInputViewModel.uiState.value.animalSeleted == "Cat")
                AnimalCard(image = R.drawable.dog, animalSelected = {
                    userInputViewModel.onEvent(
                        UserDataUIEvents.AnimalSelected(it)
                    )
                }, selected = userInputViewModel.uiState.value.animalSeleted == "Dog")
            }

            Spacer(modifier = Modifier.weight(1f))

            if (userInputViewModel.isValidState()){
                ButtonComponent(
                    goToDetailsScreen = {
                        Log.d("ButtonComponent", "Coming here!")
                        Log.d("ButtonComponent", userInputViewModel.uiState.value.nameEntered)
                        showWelcomeScreen(
                            Pair(
                                userInputViewModel.uiState.value.nameEntered,
                                userInputViewModel.uiState.value.animalSeleted
                            )
                        )
                    }
                )
            }
        }
    }
}

@Preview
@Composable
fun UserInputScreenPreview(){
    UserInputScreen(UserInputViewModel(), { it.first })
}