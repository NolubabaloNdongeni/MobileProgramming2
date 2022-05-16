package za.ac.cput.myapplicationjourneympii

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplicationjourneympii.ModuleActivity
import com.example.myapplicationjourneympii.ui.theme.MyApplicationJourneyMPIITheme


class AnotherActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationJourneyMPIITheme {

                Column(
                    modifier = Modifier.fillMaxSize().background(Color.Gray),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,

                    )
                {

                    ParagraphStyle()

                    Button(
                        onClick = {
                            val navigate = Intent(this@AnotherActivity, MainActivity::class.java)
                            startActivity(navigate)
                        },

                        shape = CircleShape,
                        contentPadding = PaddingValues(16.dp),
                        border = BorderStroke(10.dp, Color.White),
                        modifier = Modifier.size(width = 200.dp, height = 60.dp),
                        colors = ButtonDefaults.textButtonColors(
                            backgroundColor = Color.Green, contentColor = Color.White
                        )

                    ) {
                        Text(text = "Return\n", fontSize = 18.sp)
                    }
                }


            }
        }
    }

    @Composable
    fun ParagraphStyle() {

        Column(


        ) {


            Text(
                buildAnnotatedString {
                    withStyle(style = SpanStyle(color = Color.White)) {
                        withStyle(style = SpanStyle(color = Color.White, fontSize = 25.sp)) {
                            append("Name:" + "Nolubabalo Ndongeni \n")
                        }
                        withStyle(
                            style = SpanStyle(
                                fontWeight = FontWeight.Bold,
                                color = Color.White,
                                fontSize = 25.sp

                            )
                        ) {
                            append("\nCourse of study:" + "Application Development\n")
                        }
                        withStyle(
                            style = SpanStyle(
                                fontWeight = FontWeight.Bold,
                                color = Color.White,
                                fontSize = 25.sp
                            )
                        ) {
                            append("\n Department:" + "Informatics and Design \n")
                        }
                        withStyle(
                            style = SpanStyle(
                                fontWeight = FontWeight.Bold,
                                color = Color.White,
                                fontSize = 25.sp
                            )
                        ) {
                            append("\nStudent number" + "219319464")
                        }

                    }
                }
            )

        }
        Column(
            Modifier


                .padding(100.dp),
            verticalArrangement = Arrangement.spacedBy(24.dp)

        ) {

            Button(
                onClick =  { val nave= Intent(this@AnotherActivity , ModuleActivity::class.java)
                    startActivity(nave) },
                shape = CircleShape,
                contentPadding = PaddingValues(16.dp),
                border = BorderStroke(10.dp, Color.White),
                modifier = Modifier.size(width = 200.dp, height = 60.dp),
                colors = ButtonDefaults.textButtonColors(
                    backgroundColor = Color.Green, contentColor = Color.White
                )
            ) {
                Text(text = "current modules", fontSize = 15.sp)
            }
        }
    }
}

