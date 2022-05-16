package za.ac.cput.myapplicationjourneympii

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplicationjourneympii.ui.theme.MyApplicationJourneyMPIITheme



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationJourneyMPIITheme {

                var visible: MutableState<Boolean> = remember { mutableStateOf(false) }
                Alert(setVisible= visible)
                TextView()
                Column(
                    modifier = Modifier.fillMaxWidth().fillMaxHeight(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Box( modifier = Modifier.padding(all = Dp(10F)).background(color = MaterialTheme.colors.secondary)
                        .border(border = BorderStroke(width = 1.dp, brush = SolidColor(Color.Blue)))
                    )
                    {
                        TextButton(onClick = { visible.value = true }) {
                            Text(text = "Info",color= Color.White)
                        }
                    }
                    Button(onClick = {
                        val navigate= Intent(this@MainActivity, AnotherActivity::class.java)
                        startActivity(navigate)
                    }) {
                        Text(text = "Start Journey", fontSize = 18.sp)
                    }

                }


            }
        }
    }
}

@Composable
fun TextView() {
    Column(

        modifier = Modifier.fillMaxWidth().fillMaxHeight(),


        verticalArrangement = Arrangement.Top,

        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        Text(

            text = "Welcome to My Jetpack Compose Journey",

            style = TextStyle(
                color = Color.Black,
                fontWeight = FontWeight.Black,
                fontFamily = FontFamily.Default,
                background = Color.White,
                shadow = Shadow(color = Color.Blue),
                textAlign = TextAlign.Center,
            ),
            modifier = Modifier.padding(all = Dp(20.0F))
        )
    }
}

@Composable
fun Alert(setVisible: MutableState<Boolean>)
{
    if(setVisible.value){
        AlertDialog(
            onDismissRequest = { setVisible.value=false },

            confirmButton = {
                TextButton(onClick = {setVisible.value=false}) {
                    Text(text = "OK")
                }
            },
            title = { Text(text = "Alert Dialog Title") },
            text = { Text(text = "My journey on learning Jetpack Compose has been really wonderful, I have learnt how to do simple user interface using compose which I use Kotlin for it." +
                    "Jetpack compose has made things easier for me in terms of reducing the line of code compared to android and the runtime performance is much better. I have noticed that it is much easier now to maintain my code.")
            }
        )


    }
}
