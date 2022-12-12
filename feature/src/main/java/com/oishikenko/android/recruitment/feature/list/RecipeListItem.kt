package com.oishikenko.android.recruitment.feature.list

import android.annotation.SuppressLint
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.oishikenko.android.recruitment.data.model.CookingRecord
import java.text.SimpleDateFormat
import java.util.*

@SuppressLint("SuspiciousIndentation")
@Composable
fun RecipeListItem(
    cookingRecord: CookingRecord
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                horizontal = 16.dp,
                vertical = 8.dp,
            )
            .border(
                width = 1.dp,
                color = Gray,
                shape = RoundedCornerShape(10.dp)
            )
    ) {
        AsyncImage(
            model = cookingRecord.imageUrl,
            contentDescription = cookingRecord.comment,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(64.dp)
                .clip(RoundedCornerShape(
                    topStartPercent = 15,
                    bottomStartPercent = 15
                ))
        )
        Column {
            if(cookingRecord.recipeType.equals("soup")){
                Text(
                    text ="スープ",
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(start = 10.dp),
                )
            } else if (cookingRecord.recipeType.equals("main_dish")){
                Text(
                    text ="主菜/主食",
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(start = 10.dp),
                )
            }else if (cookingRecord.recipeType.equals("side_dish")){
                Text(
                    text ="副菜",
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(start = 10.dp),
                )
            }
            val sdFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.JAPANESE)
            val date = sdFormat.parse(cookingRecord.recordedAt)
            val str = SimpleDateFormat("yyyy/MM/dd HH:mm", Locale.JAPANESE).format(date)
                Text(
                    text =str,
                    color = Gray,
                    modifier = Modifier
                        .padding(start = 10.dp),
                )
        }
    }
}

@Preview
@Composable
fun PreviewRecipeListItem() {
    RecipeListItem(
        cookingRecord = CookingRecord(
            imageUrl= "",
            comment = "豚肉のコクとごぼうの香り、野菜の甘みで奥行きのある味わい。",
            recipeType = "soup",
            recordedAt = "2018-05-01 17:57:31"
        )
    )
}