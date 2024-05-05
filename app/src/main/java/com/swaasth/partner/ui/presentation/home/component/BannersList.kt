package com.swaasth.partner.ui.presentation.home.component

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.swaasth.partner.R
import com.swaasth.partner.ui.theme.Blue20
import com.swaasth.partner.ui.theme.Blue80
import com.tbuonomo.viewpagerdotsindicator.compose.DotsIndicator
import com.tbuonomo.viewpagerdotsindicator.compose.model.DotGraphic
import com.tbuonomo.viewpagerdotsindicator.compose.type.SpringIndicatorType
import kotlinx.coroutines.time.delay
import java.time.Duration

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun BannersList() {
    val posters = listOf(R.drawable.banner1, R.drawable.banner2, R.drawable.banner3)
    val pageCount by remember { mutableIntStateOf(posters.size) }
    val pagerState = rememberPagerState(0) { 3 }

    Column(
        verticalArrangement = Arrangement.spacedBy(4.dp),
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
        ) {
            Image(
                painter = painterResource(id = posters[it]),
                contentDescription = null,
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)
                    .padding(horizontal = 16.dp)
                    .clip(RoundedCornerShape(12.dp))
            )
        }

        DotsIndicator(
            dotCount = pageCount,
            dotSpacing = 4.dp,
            type = SpringIndicatorType(
                dotsGraphic = DotGraphic(
                    size = 8.dp,
                    borderWidth = 1.dp,
                    borderColor = Blue20,
                    color = Blue20
                ),
                selectorDotGraphic = DotGraphic(
                    size = 8.dp,
                    color = Blue80
                )
            ),
            pagerState = pagerState
        )
    }

    LaunchedEffect(key1 = pagerState.currentPage, block = {
        delay(Duration.ofSeconds(1))
        pagerState.scrollToPage((pagerState.currentPage + 1) % pageCount)
    })
}


@Preview(showBackground = true)
@Composable
private fun BannersListPreview() {
    BannersList()
}

