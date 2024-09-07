package com.umesh.composecall.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.umesh.composecall.ui.theme.LightGreyBlue
import com.umesh.composecall.ui.theme.MediumGrey

@Composable
fun CallScreen() {
    val colorList = listOf(MediumGrey, LightGreyBlue)
    val gradient = Brush.verticalGradient(colorList)
    var expandState by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(gradient)
    ) {

        Column(modifier = Modifier.padding(top = 50.dp)) {
            CallingProfile(
                expandState = expandState,
                onCallEnd = {},
                onCallHold = {},
                onCallConference = {},
                onStateChanged = { changedState ->
                    expandState = changedState
                }
            )

            Spacer(modifier = Modifier.weight(1f))

            IncomingCallScreen(
                expandState = expandState,
                onCallAccept = {},
                onCallDecline = {},
                onMessageClick = {},
                onRemindMe = {})
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun PreviewCallScreen() {
    CallScreen()
}