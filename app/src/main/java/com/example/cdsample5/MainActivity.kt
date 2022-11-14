package com.example.cdsample5

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.cdsample5.ui.theme.Cdsample5Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Cdsample5Theme {
                MainScreen()
            }
        }
    }
}
//
//@Preview(showBackground = true)
//@Composable
//fun DefaultPreview() {
//    Cdsample5Theme {
//        Greeting("Android")
//    }
//}