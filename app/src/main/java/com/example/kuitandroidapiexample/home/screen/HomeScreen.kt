package com.example.kuitandroidapiexample.home.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kuitandroidapiexample.home.component.AnimalItem
import com.example.kuitandroidapiexample.model.AnimalData
import com.example.kuitandroidapiexample.model.AnimalType
import com.example.kuitandroidapiexample.ui.theme.FindUTheme.colors
import com.example.kuitandroidapiexample.ui.theme.FindUTheme.typography

@Composable
fun HomeScreen(
    padding: PaddingValues
) {
    val lazyState = rememberLazyListState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(padding)
    ) {
        Column(
            modifier = Modifier.matchParentSize()
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp)
            ) {
                Text(
                    text = "조회하기",
                    modifier = Modifier.align(Alignment.Center),
                    style = typography.semiBold.copy(
                        fontSize = 18.sp
                    )
                )
            }
            LazyColumn(
                state = lazyState,
                contentPadding = PaddingValues(top = 20.dp, start = 20.dp, end = 20.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                items(animalDataList.size) {
                    animalDataList.forEach { item ->
                        AnimalItem(
                            animalData = item
                        )
                    }
                }
            }
        }

        IconButton(
            modifier = Modifier
                .padding(end = 17.dp, bottom = 20.dp)
                .size(56.dp)
                .clip(RoundedCornerShape(20.dp))
                .background(colors.orange)
                .align(Alignment.BottomEnd),
            onClick = {/* TODO */ }
        ) {
            Icon(
                modifier = Modifier
                    .size(36.dp),
                imageVector = Icons.Filled.Add,
                contentDescription = "등록하기 버튼",
                tint = colors.white
            )
        }
    }
}

private val animalDataList = listOf(
    AnimalData(
        imageUrl = "https://cdn.pixabay.com/photo/2018/05/26/18/06/dog-3431913_640.jpg",
        animalName = "점박이",
        type = AnimalType.PROTECT,
        address = "서울특별시 광진구 구의동"
    ),
    AnimalData(
        imageUrl = "https://cdn.pixabay.com/photo/2018/05/26/18/06/dog-3431913_640.jpg",
        animalName = "점박이",
        type = AnimalType.WITNESS,
        address = "서울특별시 광진구 구의동"
    ),
    AnimalData(
        imageUrl = "https://cdn.pixabay.com/photo/2018/05/26/18/06/dog-3431913_640.jpg",
        animalName = "점박이",
        type = AnimalType.PROTECT,
        address = "서울특별시 광진구 구의동"
    ),
    AnimalData(
        imageUrl = "https://cdn.pixabay.com/photo/2018/05/26/18/06/dog-3431913_640.jpg",
        animalName = "점박이",
        type = AnimalType.MISSING,
        address = "서울특별시 광진구 구의동"
    ),
    AnimalData(
        imageUrl = "https://cdn.pixabay.com/photo/2018/05/26/18/06/dog-3431913_640.jpg",
        animalName = "점박이",
        type = AnimalType.PROTECT,
        address = "서울특별시 광진구 구의동"
    )
)

@Preview(showBackground = true)
@Composable
private fun HomeScreenPreview() {
    HomeScreen(
        padding = PaddingValues()
    )
}