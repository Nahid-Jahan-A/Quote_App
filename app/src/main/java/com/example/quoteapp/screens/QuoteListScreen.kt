package com.example.quoteapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.quoteapp.R
import com.example.quoteapp.models.Quote

@Composable
fun QuoteListScreen(data: Array<Quote>, onClick: (quote: Quote)-> Unit) {
    Column {
        Text(text = "Quote App",
            color = Color.White,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.headlineMedium,
            fontFamily = FontFamily(Font(R.font.montserrat_regular)),
            modifier = Modifier
                .background(Color.Black)
                .padding(8.dp, 24.dp)
                .fillMaxWidth(1f)
            )
        QuoteList(data = data, onClick)
    }
}