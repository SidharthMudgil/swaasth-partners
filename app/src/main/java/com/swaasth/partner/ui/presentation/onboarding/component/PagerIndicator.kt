package com.swaasth.partner.ui.presentation.onboarding.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Check
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import com.swaasth.partner.ui.theme.Blue80
import com.swaasth.partner.ui.theme.Grey20
import com.swaasth.partner.ui.theme.Grey80
import com.swaasth.partner.ui.theme.White

@Composable
fun PagerIndicator(
    activePage: Int = 3
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {
        ConstraintLayout(
            decoupledConstraints(),
            modifier = Modifier.fillMaxWidth()
        ) {
            Spacer(
                modifier = Modifier
                    .layoutId("bar1")
                    .width(150.dp)
                    .height(4.dp)
                    .background(if (activePage > 1) Blue80 else Grey20)
            )

            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .layoutId("indicator1")
                    .size(48.dp)
                    .background(Blue80, CircleShape)
            ) {
                if (activePage == 1) {
                    Text(
                        text = "1",
                        color = White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp
                    )
                } else {
                    Icon(
                        imageVector = Icons.Rounded.Check,
                        contentDescription = null,
                        tint = White
                    )
                }
            }

            Text(
                text = "Personal\nInformation",
                textAlign = TextAlign.Center,
                color = if (activePage == 1) Grey80 else Grey20,
                modifier = Modifier.layoutId("title1")
            )

            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .layoutId("indicator2")
                    .size(48.dp)
                    .background(if (activePage > 1) Blue80 else Grey20, CircleShape)
            ) {
                if (activePage > 1) {
                    if (activePage == 2) {
                        Text(
                            text = "2",
                            color = White,
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp
                        )
                    } else {
                        Icon(
                            imageVector = Icons.Rounded.Check,
                            contentDescription = null,
                            tint = White
                        )
                    }
                }
            }

            Text(
                text = "Professional\nInformation",
                textAlign = TextAlign.Center,
                color = if (activePage == 2) Grey80 else Grey20,
                modifier = Modifier.layoutId("title2")
            )

            Spacer(
                modifier = Modifier
                    .layoutId("bar2")
                    .height(4.dp)
                    .width(100.dp)
                    .background(if (activePage > 2) Blue80 else Grey20)
            )

            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .layoutId("indicator3")
                    .size(48.dp)
                    .background(if (activePage > 2) Blue80 else Grey20, CircleShape)
            ) {
                if (activePage > 2) {
                    if (activePage == 3) {
                        Text(
                            text = "3",
                            color = White,
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp
                        )
                    } else {
                        Icon(
                            imageVector = Icons.Rounded.Check,
                            contentDescription = null,
                            modifier = Modifier
                                .fillMaxWidth()
                                .fillMaxHeight(),
                            tint = White
                        )
                    }
                }
            }

            Text(
                text = "Verification",
                color = if (activePage == 3) Grey80 else Grey20,
                modifier = Modifier.layoutId("title3")
            )
        }
    }
}

private fun decoupledConstraints(): ConstraintSet {
    return ConstraintSet {
        val title1 = createRefFor("title1")
        val title2 = createRefFor("title2")
        val title3 = createRefFor("title3")

        val indicator1 = createRefFor("indicator1")
        val indicator2 = createRefFor("indicator2")
        val indicator3 = createRefFor("indicator3")

        val bar1 = createRefFor("bar1")
        val bar2 = createRefFor("bar2")

        constrain(indicator1) {
            start.linkTo(title1.start)
            top.linkTo(parent.top)
            end.linkTo(title1.end)
            bottom.linkTo(indicator1.bottom)
        }

        constrain(indicator2) {
            start.linkTo(title2.start)
            top.linkTo(parent.top)
            end.linkTo(title2.end)
            bottom.linkTo(indicator2.bottom)
        }

        constrain(indicator3) {
            start.linkTo(title3.start)
            top.linkTo(parent.top)
            end.linkTo(title3.end)
            bottom.linkTo(indicator3.bottom)
        }

        constrain(bar1) {
            start.linkTo(indicator1.end)
            top.linkTo(indicator1.top)
            end.linkTo(indicator2.start)
            bottom.linkTo(indicator1.bottom)
        }

        constrain(bar2) {
            start.linkTo(indicator2.end)
            top.linkTo(indicator2.top)
            end.linkTo(indicator3.start)
            bottom.linkTo(indicator2.bottom)
        }

        createHorizontalChain(title1, title2, title3, chainStyle = ChainStyle.SpreadInside)

        constrain(title1) {
            top.linkTo(indicator1.bottom)
            bottom.linkTo(parent.bottom)
        }

        constrain(title2) {
            top.linkTo(indicator2.bottom)
            bottom.linkTo(parent.bottom)
        }

        constrain(title3) {
            top.linkTo(indicator3.bottom)
            bottom.linkTo(parent.bottom)
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PagerIndicatorPreview() {
    PagerIndicator()
}