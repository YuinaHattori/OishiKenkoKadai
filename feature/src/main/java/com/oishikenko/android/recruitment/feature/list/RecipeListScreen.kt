package com.oishikenko.android.recruitment.feature.list


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.ExperimentalLifecycleComposeApi
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.oishikenko.android.recruitment.feature.R

@OptIn(ExperimentalLayoutApi::class, ExperimentalLifecycleComposeApi::class)
@Composable
fun RecipeListScreen(
    viewModel: RecipeListViewModel = hiltViewModel()
) {
    val cookingRecords by viewModel.cookingRecords.collectAsStateWithLifecycle()
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth())
    {
        Image(
            painter = painterResource(R.drawable.header),
            contentDescription = "Application Header",
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .size(width = 300.dp, height = 64.dp)
                .padding(vertical = 10.dp),
        )
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            items(cookingRecords) { it ->
                RecipeListItem(it)
            }
        }
    }
}

@Preview
@Composable
fun PreviewRecipeListScreen(){
    MaterialTheme {
        RecipeListScreen()
    }
}
