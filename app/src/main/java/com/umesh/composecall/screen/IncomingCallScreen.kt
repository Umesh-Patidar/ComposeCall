package com.umesh.composecall.screen

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.umesh.composecall.R
import com.umesh.composecall.ui.theme.BlackLight
import com.umesh.composecall.ui.theme.DarkGreen
import com.umesh.composecall.ui.theme.LightRed

@Composable
fun IncomingCallScreen(
    expandState: Boolean = false,
    onCallDecline: () -> Unit,
    onCallAccept: () -> Unit,
    onRemindMe: () -> Unit,
    onMessageClick: () -> Unit
) {
    val density = LocalDensity.current
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = BlackLight,
                shape = RoundedCornerShape(topStart = 25.dp, topEnd = 25.dp)
            )
            .padding(40.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Incoming Call",
            color = Color.White,
            style = MaterialTheme.typography.titleSmall.copy(
                fontWeight = FontWeight.Light
            )
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Dangel Washington",
            color = Color.White,
            style = MaterialTheme.typography.headlineSmall.copy(
                fontWeight = FontWeight.Normal
            )
        )

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = "mobile",
            color = Color.White,
            style = MaterialTheme.typography.titleMedium.copy(
                fontWeight = FontWeight.Light
            )
        )

        AnimatedVisibility(
            visible = !expandState,
            enter = slideInVertically {
                with(density) { -40.dp.roundToPx() }
            } + expandVertically(
                expandFrom = Alignment.Top
            ) + fadeIn(
                initialAlpha = 0.3f
            ),
            exit = slideOutVertically() + shrinkVertically() + fadeOut()
        ) {

            Column {
                Spacer(modifier = Modifier.height(60.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Image(
                            modifier = Modifier
                                .size(20.dp)
                                .clickable { onRemindMe() },
                            painter = painterResource(id = R.drawable.ic_alarm),
                            contentDescription = "Remind Me",
                            colorFilter = ColorFilter.tint(color = Color.White)
                        )

                        Spacer(modifier = Modifier.height(10.dp))

                        Text(
                            text = "Remind Me",
                            style = MaterialTheme.typography.titleSmall.copy(
                                fontWeight = FontWeight.Light,
                                color = Color.White
                            )
                        )
                    }

                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Image(
                            modifier = Modifier
                                .size(20.dp)
                                .clickable { onMessageClick() },
                            painter = painterResource(id = R.drawable.ic_chat_bubble),
                            contentDescription = "Message",
                            colorFilter = ColorFilter.tint(color = Color.White)
                        )

                        Spacer(modifier = Modifier.height(10.dp))

                        Text(
                            text = "Message",
                            style = MaterialTheme.typography.titleSmall.copy(
                                fontWeight = FontWeight.Light,
                                color = Color.White
                            )
                        )
                    }
                }


                Row(
                    modifier = Modifier
                        .padding(20.dp)
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {

                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Box(
                            modifier = Modifier
                                .size(70.dp)
                                .background(shape = CircleShape, color = LightRed)
                                .clickable { onCallDecline() },
                            contentAlignment = Alignment.Center
                        ) {
                            Image(
                                modifier = Modifier.size(45.dp),
                                painter = painterResource(id = R.drawable.ic_call_end),
                                contentDescription = "Decline",
                                colorFilter = ColorFilter.tint(color = Color.White)
                            )
                        }

                        Spacer(modifier = Modifier.height(10.dp))
                        Text(
                            text = "Decline",
                            color = Color.White,
                            style = MaterialTheme.typography.titleSmall.copy(
                                fontWeight = FontWeight.Light
                            )
                        )
                    }

                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Box(
                            modifier = Modifier
                                .size(70.dp)
                                .background(shape = CircleShape, color = DarkGreen)
                                .clickable { onCallAccept() },
                            contentAlignment = Alignment.Center
                        ) {
                            Image(
                                modifier = Modifier.size(35.dp),
                                painter = painterResource(id = R.drawable.ic_call),
                                contentDescription = "Accept",
                                colorFilter = ColorFilter.tint(color = Color.White)
                            )
                        }

                        Spacer(modifier = Modifier.height(10.dp))
                        Text(
                            text = "Accept",
                            color = Color.White,
                            style = MaterialTheme.typography.titleSmall.copy(
                                fontWeight = FontWeight.Light
                            )
                        )
                    }
                }
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun PreviewIncomingCallScreen() {
    IncomingCallScreen(
        expandState = false,
        onCallAccept = {},
        onCallDecline = {},
        onMessageClick = {},
        onRemindMe = {})
}