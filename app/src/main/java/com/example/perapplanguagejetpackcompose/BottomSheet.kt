package com.example.perapplanguagejetpackcompose

import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.core.os.LocaleListCompat
import com.example.perapplanguagejetpackcompose.ListItemData
import com.example.perapplanguagejetpackcompose.MainPageContent


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun BottomSheet() {
    val scope = rememberCoroutineScope()
    val bottomSheetState =
        rememberModalBottomSheetState(initialValue = ModalBottomSheetValue.Hidden)

    ModalBottomSheetLayout(
        sheetState = bottomSheetState,
        sheetContent = {
            Column(modifier = Modifier.padding(12.dp)) {
                ListItemData(title = "en", bottomSheetState, scope)
                ListItemData(title = "fr", bottomSheetState, scope)
                ListItemData(title = "de", bottomSheetState, scope)
                ListItemData(title = "it", bottomSheetState, scope)
            }

        },
        sheetShape = RoundedCornerShape(topStart = 8.dp, topEnd = 8.dp),
        sheetElevation = 8.dp
    ) {
        MainPageContent(scope, bottomSheetState)
    }
}

fun updateApplicationLocale(selectedLocale: String) {
    Log.d("sdiudwqoi","selectedLocale-->"+selectedLocale)
    val localeList = LocaleListCompat.forLanguageTags(selectedLocale)
    AppCompatDelegate.setApplicationLocales(localeList)
}
