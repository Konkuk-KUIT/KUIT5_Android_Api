package com.example.kuitandroidapiexample.detail.screen

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.example.kuitandroidapiexample.R
import com.example.kuitandroidapiexample.common.TagChip
import com.example.kuitandroidapiexample.model.AnimalData.Companion.animalDataList
import com.example.kuitandroidapiexample.ui.theme.FindUTheme.colors
import com.example.kuitandroidapiexample.ui.theme.FindUTheme.typography

@Composable
fun DetailScreen(
    padding: PaddingValues,
    index: Int,
    navigateToBack: () -> Unit = {}
) {
    val animalData = animalDataList[index]

    Box(
        modifier = Modifier
            .padding(padding)
            .fillMaxSize()
    ) {
        Column {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(64.dp)
            ) {
                Icon(
                    modifier = Modifier
                        .padding(20.dp)
                        .clickable { navigateToBack() },
                    painter = painterResource(R.drawable.ic_chevron_left),
                    contentDescription = "뒤로 가기",
                    tint = Color.Unspecified
                )
            }
            AsyncImage(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(420.dp),
                model = animalData.imageUrl,
                contentDescription = "동물 사진"
            )
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(304.dp)
                .align(Alignment.BottomCenter)
                .clip(RoundedCornerShape(topStart = 18.dp, topEnd = 18.dp))
        ) {
            Text(
                text = animalData.animalName,
                style = typography.semiBold.copy(fontSize = 24.sp),
                modifier = Modifier.padding(start = 40.dp, top = 42.dp, bottom = 20.dp)
            )

            TagChip(
                modifier = Modifier.padding(start = 40.dp),
                animalType = animalData.type
            )
            Spacer(modifier = Modifier.height(30.dp))

            Box(
                modifier = Modifier
                    .padding(horizontal = 20.dp)
                    .fillMaxWidth()
                    .border(width = 1.dp, color = colors.black, shape = RoundedCornerShape(20.dp))
                    .clip(RoundedCornerShape(20.dp))
                    .shadow(
                        elevation = 10.dp,
                        spotColor = Color(0x1AA0A0A0),
                        ambientColor = Color(0x1AA0A0A0)
                    )
                    .height(89.dp)
                    .padding(horizontal = 40.dp, vertical = 20.dp)
            ) {
                Text(
                    text = "주소",
                    style = typography.semiBold.copy(fontSize = 14.sp, color = colors.orange),
                )
                Text(
                    text = animalData.address,
                    style = typography.semiBold.copy(fontSize = 14.sp),
                    modifier = Modifier.align(Alignment.BottomStart)
                )


            }
            Text(
                text = "신고자 : ${animalData.reporterName}",
                style = typography.semiBold.copy(fontSize = 14.sp),
                modifier = Modifier.padding(start = 40.dp, top = 21.dp)
            )
        }


    }
}


@Preview(showBackground = true, widthDp = 360, heightDp = 800)
@Composable
private fun DetailScreenPreview() {
    DetailScreen(PaddingValues(), 0)
}