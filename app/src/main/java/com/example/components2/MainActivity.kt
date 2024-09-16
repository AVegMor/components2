package com.example.components2

import android.R
import android.os.Bundle
import android.widget.RadioButton
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Checkbox
import androidx.compose.material3.RadioButton
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.RadioButtonColors
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.components2.ui.theme.Components2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Components2Theme {

/*
            val myCheckedBoxs = getOptions(listOf("Ejemplo1", "Ejemplo2", "Ejemplo3"))

                Column (Modifier.padding(24.dp)){
                    myCheckedBoxs.forEach {
                        MyCheckBox3(it)
                    }
                }*/
                var selected by rememberSaveable { mutableStateOf("opcion1") }
                MyRadioButton3(selected) { selected = it }
            }
        }
    }
}

@Composable
fun MyRadioButton3(name: String, onItemSelected: (String)->Unit) {

    Column(Modifier.fillMaxWidth()) {
        Row(Modifier.fillMaxWidth()) {
            RadioButton(
                selected = name == "opcion1",
                onClick = { onItemSelected("opcion1") }
            )
            Text(text = "opcion1", Modifier.padding(top = 12.dp))
        }
        Row(Modifier.fillMaxWidth()) {
            RadioButton(
                selected = name == "opcion2",
                onClick = { onItemSelected("opcion2") }
            )
            Text(text = "opcion2", Modifier.padding(top = 12.dp))
        }
        Row(Modifier.fillMaxWidth()) {
            RadioButton(
                selected = name == "opcion3",
                onClick = { onItemSelected("opcion3") }
            )
            Text(text = "opcion3", Modifier.padding(top = 12.dp))
        }
    }
}

@Composable
fun MyRadioButton2() {
    var selected by rememberSaveable { mutableStateOf("opcion1") }
    Column(Modifier.fillMaxWidth()) {
        Row(Modifier.fillMaxWidth()) {
            RadioButton(
                selected = selected == "opcion1",
                onClick = { selected = "opcion1" }
            )
            Text(text = "opcion1", Modifier.padding(top = 12.dp))
        }
        Row(Modifier.fillMaxWidth()) {
            RadioButton(
                selected = selected == "opcion2",
                onClick = { selected = "opcion2" }
            )
            Text(text = "opcion2", Modifier.padding(top = 12.dp))
        }
        Row(Modifier.fillMaxWidth()) {
            RadioButton(
                selected = selected == "opcion3",
                onClick = { selected = "opcion3" }
            )
            Text(text = "opcion3", Modifier.padding(top = 12.dp))
        }
    }
}

@Composable
fun MyRadioButton() {
    Row(Modifier.fillMaxWidth()) {
        RadioButton(
            selected = true,
            enabled = false,
            onClick = {},
            colors = RadioButtonDefaults.colors(
                selectedColor = Color.Blue,
                unselectedColor = Color.Red,
                disabledSelectedColor = Color.Gray,
                disabledUnselectedColor = Color.Magenta
            )
        )
        Text(text = "Ejemplo", Modifier.padding(top = 12.dp))
    }
}


@Composable
fun getOptions(titles: List<String>): List<CheckInfo> {
    return titles.map {
        var status by rememberSaveable { mutableStateOf(false) }
        CheckInfo(
            title = it,
            selected = status,
            onCheckedChange = { myNewStatus -> status = myNewStatus }
        )
    }
}

@Composable
fun MyCheckBox() {
    var state by rememberSaveable { mutableStateOf(true) }
    Box(Modifier.padding(24.dp)) {
        Checkbox(
            checked = state,
            onCheckedChange = { state = !state },
            enabled = true,
            colors = CheckboxDefaults.colors(
                checkedColor = Color.Red,
                uncheckedColor = Color.Gray,
                checkmarkColor = Color.Blue
            )
        )
    }
}

@Composable
fun MyCheckBox3(checkInfo: CheckInfo) {
    Row(Modifier.padding(8.dp)) {
        Checkbox(
            checked = checkInfo.selected,
            onCheckedChange = { checkInfo.onCheckedChange(!checkInfo.selected) })
        Spacer(modifier = Modifier.width(4.dp))
        Text(text = checkInfo.title, modifier = Modifier.padding(top = 12.dp))
    }
}


@Composable
fun MyCheckBox2() {
    var state by rememberSaveable { mutableStateOf(true) }
    Row(Modifier.padding(8.dp)) {
        Checkbox(
            checked = state,
            onCheckedChange = { state = !state })
        Spacer(modifier = Modifier.width(4.dp))
        Text(text = "Texto de ejemplo", modifier = Modifier.padding(top = 12.dp))
    }
}

@Composable
fun MySwitch() {
    var state by rememberSaveable { mutableStateOf(true) }
    Box(Modifier.padding(24.dp)) {
        Switch(
            checked = state,
            onCheckedChange = { state = !state },
            enabled = true,
            colors = SwitchDefaults.colors(
                uncheckedThumbColor = Color.Black,
                checkedThumbColor = Color.Blue,
                uncheckedTrackColor = Color.Magenta,
                checkedTrackColor = Color.Cyan
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Components2Theme {
        MyRadioButton()
    }
}