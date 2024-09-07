package com.umesh.composecall.screen

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.umesh.composecall.R
import com.umesh.composecall.ui.theme.BlackLight
import com.umesh.composecall.ui.theme.DarkGreen
import com.umesh.composecall.ui.theme.LightCyan
import com.umesh.composecall.ui.theme.LightRed

@Composable
fun CallingProfile(
    modifier: Modifier = Modifier,
    expandState: Boolean = false,
    onStateChanged: (Boolean) -> Unit,
    onCallEnd: () -> Unit,
    onCallHold: () -> Unit,
    onCallConference: () -> Unit
) {
    Column(
        modifier = modifier
            .padding(10.dp)
            .fillMaxWidth()
            .animateContentSize()
            .background(color = BlackLight, shape = RoundedCornerShape(18.dp))
            .padding(10.dp)
    ) {
        val rotationState by animateFloatAsState(
            targetValue = if (expandState) 180f else 0f,
            label = "drop down"
        )

        Row(
            modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically
        ) {

            Image(
                modifier = Modifier
                    .padding(5.dp)
                    .size(50.dp)
                    .clip(CircleShape),
                painter = painterResource(id = R.drawable.img_pic),
                contentDescription = "user profile",
                contentScale = ContentScale.Crop
            )

            Column(
                modifier = Modifier.padding(start = 5.dp),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Tony Stark",
                    color = Color.White,
                    style = MaterialTheme.typography.titleLarge.copy(
                        fontWeight = FontWeight.Normal
                    )
                )
                Text(
                    text = "00:24",
                    color = Color.Gray,
                    style = MaterialTheme.typography.titleSmall.copy(
                        fontWeight = FontWeight.SemiBold
                    )
                )
            }

            Spacer(modifier = Modifier.weight(1f))
            Box(
                modifier = Modifier
                    .padding(end = 5.dp)
                    .size(35.dp)
                    .rotate(rotationState)
                    .background(shape = CircleShape, color = Color.Gray)
                    .clip(shape = CircleShape)
                    .clickable(
                        interactionSource = remember { MutableInteractionSource() },
                        indication = null
                    ) {
                        onStateChanged(!expandState)
                    },
                contentAlignment = Alignment.Center
            ) {
                Image(
                    imageVector = Icons.Filled.KeyboardArrowDown,
                    contentDescription = "drop down",
                    colorFilter = ColorFilter.tint(color = Color.White)
                )
            }
        }

        if (expandState) {
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
                            .background(shape = CircleShape, color = LightRed).clickable { onCallEnd() },
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            modifier = Modifier.size(45.dp),
                            painter = painterResource(id = R.drawable.ic_call_end),
                            contentDescription = "call end",
                            colorFilter = ColorFilter.tint(color = Color.White)
                        )
                    }

                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "End",
                        color = Color.White,
                        style = MaterialTheme.typography.labelSmall.copy(
                            fontWeight = FontWeight.Light
                        )
                    )
                }

                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Box(
                        modifier = Modifier
                            .size(70.dp)
                            .background(shape = CircleShape, color = Color.White).clickable { onCallHold() },
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            modifier = Modifier.size(35.dp),
                            painter = painterResource(id = R.drawable.ic_call_hold),
                            contentDescription = "call hold",
                            colorFilter = ColorFilter.tint(color = DarkGreen)
                        )
                    }

                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "Hold",
                        color = Color.White,
                        style = MaterialTheme.typography.labelSmall.copy(
                            fontWeight = FontWeight.Light
                        )
                    )
                }

                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Box(
                        modifier = Modifier
                            .size(70.dp)
                            .background(shape = CircleShape, color = LightCyan).clickable { onCallConference() },
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            modifier = Modifier.size(35.dp),
                            painter = painterResource(id = R.drawable.ic_call),
                            contentDescription = "call",
                            colorFilter = ColorFilter.tint(color = Color.White)
                        )
                    }

                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "Conference",
                        color = Color.White,
                        style = MaterialTheme.typography.labelSmall.copy(
                            fontWeight = FontWeight.Light
                        )
                    )
                }
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun PreviewIncomingUserProfile() {
    CallingProfile(expandState = true, onStateChanged = {}, onCallEnd = {}, onCallHold = {}, onCallConference = {})
}