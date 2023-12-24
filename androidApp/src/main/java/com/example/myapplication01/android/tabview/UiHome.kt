package com.example.myapplication.tabview

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.material3.IconButton as IconButton1

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UiHome(
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Text(text = "Home")
        Button(onClick = { println("确认onClick") }) {
            Text("默认样式")
        }
        var queryString = remember { mutableStateOf("") }

        // if the search bar is active or not
        var isActive = remember { mutableStateOf(false) }

        val contextForToast = LocalContext.current.applicationContext

        SearchBar(modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = if (isActive.value) 0.dp else 8.dp),
            query = queryString.value,
            onQueryChange = { newQueryString ->
                queryString.value = newQueryString
            },
            onSearch = {
                isActive.value = false
                Toast.makeText(
                    contextForToast, "Your query string: $queryString", Toast.LENGTH_SHORT
                ).show()
            },
            active = isActive.value,
            onActiveChange = { activeChange ->
                isActive.value = activeChange
            },
            placeholder = {
                Text(text = "Search")
            },
            leadingIcon = {
                Icon(imageVector = Icons.Default.Search, contentDescription = null)
            }) {

        }

    }


}