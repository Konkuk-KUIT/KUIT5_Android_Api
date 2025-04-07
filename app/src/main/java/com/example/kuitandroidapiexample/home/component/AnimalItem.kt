package com.example.kuitandroidapiexample.home.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.example.kuitandroidapiexample.R
import com.example.kuitandroidapiexample.common.TagChip
import com.example.kuitandroidapiexample.model.AnimalData
import com.example.kuitandroidapiexample.model.AnimalType
import com.example.kuitandroidapiexample.ui.theme.FindUTheme.colors
import com.example.kuitandroidapiexample.ui.theme.FindUTheme.typography

@Composable
fun AnimalItem(
    modifier: Modifier = Modifier,
    animalData: AnimalData,
    navigateToDetail: () -> Unit = {}
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .clickable { navigateToDetail() },
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        AsyncImage(
            modifier = Modifier.size(130.dp),
            model = animalData.imageUrl,
            contentDescription = "동물 사진입니다."
        )
        Column(
            modifier = Modifier.padding(vertical = 12.dp)
        ) {
            Text(
                modifier = Modifier.padding(start = 1.dp),
                text = animalData.animalName,
                style = typography.semiBold.copy(fontSize = 18.sp)
            )
            TagChip(
                modifier = Modifier.padding(top = 10.dp, start = 1.dp),
                animalType = animalData.type
            )
            Row(
                modifier = Modifier.padding(top = 31.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(R.drawable.ic_address_pin),
                    contentDescription = "지도 핀",
                    tint = Color.Unspecified
                )
                Text(
                    text = animalData.address,
                    style = typography.semiBold.copy(
                        fontSize = 14.sp,
                        color = colors.gray100
                    )
                )
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
private fun AnimalItemPreview() {
    AnimalItem(
        animalData = AnimalData(
            imageUrl = "https://cdn.pixabay.com/photo/2018/05/26/18/06/dog-3431913_640.jpg",
            animalName = "점박이",
            type = AnimalType.PROTECT,
            address = "서울특별시 광진구 구의동"
        )
    )
}