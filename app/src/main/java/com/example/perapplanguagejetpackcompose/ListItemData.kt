package com.example.perapplanguagejetpackcompose

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ListItemData(title: String, bottomSheetState: ModalBottomSheetState, scope: CoroutineScope) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = {
                scope.launch { bottomSheetState.hide() }
                updateApplicationLocale(title)
            })
            .padding(top = 10.dp, bottom = 10.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        Text(text = title)
    }
}
