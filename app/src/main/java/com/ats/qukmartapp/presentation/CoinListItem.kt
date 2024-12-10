package com.ats.qukmartapp.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.ats.qukmartapp.R
import com.ats.qukmartapp.presentation.models.DisplayableNumber
import com.ats.qukmartapp.ui.theme.greenBackground


@Composable
fun CoinListItem(modifier: Modifier=Modifier,onClick:()->Unit){
    val contentColor = if (isSystemInDarkTheme()){
        Color.White
    }else{
        Color.Black
    }
    Row( modifier = modifier
        .clickable(onClick = onClick)
        .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(16.dp)){
        Icon(imageVector =ImageVector.vectorResource(R.drawable._inch),
            contentDescription = "",
            tint=MaterialTheme.colorScheme.primary,
            modifier = modifier.size(85.dp)
        )
        Column(modifier = modifier.weight(1f)) {
            Text(text="coin symbol", fontSize = 20.sp, fontWeight = FontWeight.SemiBold,color=contentColor)
            Text(text = "coin name", fontSize = 14.sp, fontWeight = FontWeight.Light, color = contentColor)
        }
        Column {
            Text(text = "Price Change", fontSize = 20.sp, fontWeight = FontWeight.SemiBold,color=contentColor)
            Spacer(modifier =Modifier.height(8.dp) )
            PriceChange(DisplayableNumber(1223.5666,"2"),modifier)
        }
    }
}

@Composable
fun PriceChange(priceChange: DisplayableNumber, modifier: Modifier=Modifier){
    val contentColor = if (priceChange.value<0.0){
        MaterialTheme.colorScheme.onErrorContainer
    }else{
        Color.Green
    }
    val backgroundColor = if (priceChange.value<0.0){
MaterialTheme.colorScheme.onErrorContainer
    }else{
        greenBackground
    }
    Row(modifier = modifier
        .clip(RoundedCornerShape(100f))
        .background(backgroundColor)
        .padding(horizontal = 10.dp),
        verticalAlignment = Alignment.CenterVertically) {
        Icon(
            imageVector = if (priceChange.value < 0.0) {
                Icons.Default.KeyboardArrowDown
            }else{
                 Icons.Default.KeyboardArrowUp
                 },
            contentDescription ="",
            modifier = modifier.size(20.dp),
            tint=contentColor
        )
        Text(text = "${priceChange.formatted} %", fontSize = 14.sp, fontWeight = FontWeight.Medium, color = contentColor)

    }
}