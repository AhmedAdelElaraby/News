package com.example.appnews.ui.screens.homescreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.core.utils.ApiState
import com.example.domain.model.Post
import com.example.domain.model.PostResponse


@Composable
fun HomeScreen(navController: NavController, viewModel: PostViewModel) {
    val state by viewModel._post.observeAsState(ApiState.Empty)



    LaunchedEffect(Unit) {
        viewModel.getPost()
    }

    when (state) {
        is ApiState.Loading -> {
            CircularProgressIndicator()
        }

        is ApiState.Success -> {
            val data = (state as ApiState.Success).data
            Text("Data: $data")
        }

        is ApiState.Failure -> {
            val error = (state as ApiState.Failure).message
            Text("Error: $error", color = Color.Red)
        }

        is ApiState.Empty -> {
            Text("No data yet")
        }
    }

}
@Composable
    fun List (lists:List<Post>, navController: NavController){
    LazyColumn(modifier = Modifier.padding(16.dp)) {
        items(lists) { post ->
            Column(modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    navController.navigate("details/${post.title}/${post.imageUrl ?: ""}")
                }) {
                Text(text = post.title, style = MaterialTheme.typography.subtitle2)
                post.imageUrl?.let {
                    Spacer(modifier = Modifier.height(8.dp))
                    Image(
                        painter = rememberAsyncImagePainter(it),
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(200.dp),
                        contentScale = ContentScale.Crop
                    )
                }
                Divider(modifier = Modifier.padding(vertical = 8.dp))
            }
        }
    }

    }