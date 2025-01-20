package com.first.testingjetpackcompose.pagination

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.paging.compose.LazyPagingItems
import com.first.testingjetpackcompose.pagination.data.remote.models.modelsQuotes.Quotes


@Composable
fun QuotesScreen(

    quotes: LazyPagingItems<Quotes>

){

    LazyColumn(

    ) {
        items(quotes.itemCount){
            index ->
            quotes[index]?.let { quote ->

                QuotesCard(quote)

            }
        }
    }

}

@Composable
private fun QuotesCard(
    quotes: Quotes
){

    Column(

        modifier = Modifier
            .wrapContentSize()
            .padding(24.dp)
            .background(MaterialTheme.colorScheme.primaryContainer)

    ) {

        Text(

            text = """ " """,
            style = MaterialTheme.typography.displayLarge,
            color = MaterialTheme.colorScheme.onBackground

        )

        Text(

            text = quotes.quoteText,
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onBackground,
            modifier = Modifier.padding(start = 12.dp)

        )

        Spacer(Modifier.height(12.dp))

        Box(

            modifier = Modifier.fillMaxSize()

        ){

            Text(

                modifier = Modifier
                    .align(Alignment.CenterEnd)
                    .padding(12.dp),

                text = quotes.quoteAuthor,
                color = MaterialTheme.colorScheme.onBackground

            )

            Spacer(Modifier.height(12.dp))

        }

    }

}