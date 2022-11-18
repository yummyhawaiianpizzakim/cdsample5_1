package com.example.cdsample5.screens

//import com.example.cdsample5.LectureRoomes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.example.cdsample5.*


@Composable
fun Reserving(
    modifier: Modifier
) {
    val datepicker = DatePicker(modifier = Modifier)
    Column(
        modifier = Modifier
            .wrapContentHeight()
            .fillMaxWidth()
    ) {
        Spacer(Modifier.height(16.dp))
        BackLayerTextField("Search", "Search dummy...", Icons.Default.Search)
        Spacer(Modifier.height(16.dp))
        Button(
            onClick = { datepicker },
            colors = ButtonDefaults.buttonColors(
//                    containerColor = MaterialTheme.colorScheme.surface,
                contentColor = MaterialTheme.colors.onSurface
                    .copy(alpha = 0.12f)
            ),
            shape = MaterialTheme.shapes.small,
            modifier = modifier
                .padding(vertical = 20.dp)
                .height(54.dp),
            border = BorderStroke(1.dp, MaterialTheme.colors.onSurface.copy(alpha = 0.12f))

        ) {
            Text(
                text = "Date",
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1.8f)
            )
            Icon(
                imageVector = Icons.Filled.ArrowDropDown,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(0.2f)
            )
        }


        BackLayerTextField("Date", "Date dummy...", Icons.Default.DateRange)
        Spacer(Modifier.height(16.dp))
        BackLayerTextField("Place", "Place dummy...", Icons.Default.Place)
        Spacer(Modifier.height(8.dp))

        CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
            Text(
                text = "SubHeader",
                modifier = Modifier.padding(top = 16.dp, start = 8.dp, end = 8.dp, bottom = 8.dp)
            )
        }
        Divider(
            modifier = Modifier
                .padding(horizontal = 8.dp)
                .background(Color.LightGray)
                .height(1.dp)
        )
        Spacer(modifier = Modifier.height(8.dp))
        LazyColumn(
            contentPadding = PaddingValues(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(places) { place ->
                PlacesToBookVerticalComponent(place = place)
            }
        }

    }
}

@Composable
fun PlacesToBookVerticalComponent(place: Place) {
    Card(
        modifier = Modifier
            .fillMaxWidth(),
        elevation = 2.dp,
        shape = RoundedCornerShape(8.dp)
    ) {
        Row(modifier = Modifier.clickable { }) {
            PlaceContent(place, Modifier.weight(1f))
            ImageContent(place)
        }
    }
}


@Composable
fun BackLayerTextField(
    label: String,
    placeHolder: String,
    imageVector: ImageVector
) {
    var textFieldValue by remember { mutableStateOf("") }

    TextField(
        modifier = Modifier
            .padding(8.dp)
            .clip(RoundedCornerShape(8.dp))
            .fillMaxWidth(),
        value = textFieldValue,
        label = { Text(label) },
        placeholder = { Text(placeHolder) },
        onValueChange = { newValue ->
            textFieldValue = newValue
        },
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = Color(0xffD1C4E9),
        ),
        textStyle = TextStyle(
            color = MaterialTheme.colors.primary
        ),
        leadingIcon = {
            Icon(imageVector = imageVector, contentDescription = null)
        }
    )
}


//
//@Preview(showBackground = true)
//@Composable
//fun DefaultPreview1() {
//    Cdsample5Theme {
//        Reserving()
//    }
//}