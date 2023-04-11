package com.example.perapplanguagejetpackcompose

import android.graphics.Paint.Align
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.perapplanguagejetpackcompose.ui.theme.PerAppLanguageJetpackComposeTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PerAppLanguageJetpackComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    BottomSheet()
                }
            }
        }
    }
}


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MainPageContent(scope: CoroutineScope, bottomSheetState: ModalBottomSheetState) {
    Column {
        Surface(
            modifier = Modifier
                .padding(start = 10.dp, end = 10.dp, top = 100.dp)
                .wrapContentSize()
        ) {
            Button(
                modifier = Modifier
                    .height(40.dp)
                    .fillMaxSize(),
                onClick = { scope.launch { bottomSheetState.show() } },
                elevation = ButtonDefaults.elevation(
                    defaultElevation = 10.dp,
                    pressedElevation = 15.dp,
                    disabledElevation = 0.dp
                )
            ) {
                Text(text = stringResource(id = R.string.text_select_language))
            }
        }
        Surface(
            modifier = Modifier
                .padding(start = 30.dp, end = 30.dp, top = 60.dp)
                .wrapContentSize()
        ) {
            Text(text = stringResource(id = R.string.text_to_translate))
        }
    }
}
