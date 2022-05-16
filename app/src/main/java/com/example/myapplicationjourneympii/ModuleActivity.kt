package com.example.myapplicationjourneympii

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat.startActivity
import com.example.myapplicationjourneympii.ui.theme.MyApplicationJourneyMPIITheme
import za.ac.cput.myapplicationjourneympii.AnotherActivity
import za.ac.cput.myapplicationjourneympii.MainActivity

class ModuleActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{
            MyApplicationJourneyMPIITheme{
                var visible: MutableState<Boolean> = remember { mutableStateOf(false) }
               Alert(setVisible = visible)

                var module1= appDev("APPLICATIONS DEVELOPMENT PRACTICE 3",
                    "Practical module", "1 year ")
                var module2= appDev("APPLICATIONS DEVELOPMENT THEORY 3",
                    "Theory module",
                    "1 year ")
                var module3= appDev("INFORMATION SYSTEMS 3",
                    "Practical module", "1 year")
                var module4= appDev("ICE ELECTIVES (MOBILE PROGRAMMING 2)",
                    "Practical module", "6 months")
                var module5= appDev("PROFESSIONAL PRACTICE 3",
                    "Theory module", "6 months ")
                var module6= appDev("PROJECT 3",
                    "Practical module", "1 year ")
                var module7= appDev("PROJECT PRESENTATION 3",
                    "Practical module", " 1 year")
                var module8= appDev("PROJECT MANAGEMENT 3",
                    "Theory module", " 6 months" )

                val mod=listOf (module1,module2,module3,module4,module5,module6,module7,module8)
                List(mod)


            }
        }
    }
}

data class appDev(var name:String, var type: String,var period:String,)

@Composable
fun Greeting(message: appDev )
{

    Row() {

        Image(painter = painterResource(id=R.drawable.download),
            contentDescription ="Image",
            modifier = Modifier
                .size(80.dp)
                .clip(CircleShape)
                .border(
                    1.4.dp, MaterialTheme.colors.secondary,
                    CircleShape
                )
        )

        Spacer(modifier = Modifier.width(23.2.dp))
        var isExpanded by remember { mutableStateOf(false) }

        Column(modifier = Modifier.clickable { isExpanded =!isExpanded  }) {

            Text(text = "${message.name}",
                color = MaterialTheme.colors.secondaryVariant,


                style= MaterialTheme.typography.subtitle2

            )
            Spacer(modifier = Modifier.width(14.2.dp))

            Surface(shape = MaterialTheme.shapes.medium,
                color = MaterialTheme.colors.secondary, elevation = 800.dp) {

                Text(text = "${message.type}",style= MaterialTheme.typography.body1,
                    modifier = Modifier.padding(all = 1.6.dp),
                    maxLines = if (isExpanded) Int.MAX_VALUE else 1)
            }


            Spacer(modifier = Modifier.width(14.2.dp))

            Surface(shape = MaterialTheme.shapes.medium,
                color = MaterialTheme.colors.secondary, elevation = 800.dp) {

                Text(text = "${message.period}",style= MaterialTheme.typography.body1,
                    modifier = Modifier.padding(all = 1.6.dp),
                    maxLines = if (isExpanded) Int.MAX_VALUE else 1)
            }
        }
    }
}
@Composable
fun List (messages: List<appDev>)
{
    Column() {
//

        LazyColumn()
        {

            items(messages) { m-> Greeting(message = m) }
        }
        Column(
            verticalArrangement = Arrangement.Center,

            horizontalAlignment = Alignment.CenterHorizontally,) {


            Box()

            {
                Button(
                    onClick =   { },
                    border = BorderStroke(12.dp, Color.Gray),
                    contentPadding = PaddingValues(16.dp),
                    modifier = Modifier
                        .size(width = 800.dp, height = 70.dp)
                        .background(Color.Blue),
                ) {
                    Text(text = "back", color = Color.Black)
                }
            }}
    }}
@Composable
fun Alert(setVisible: MutableState<Boolean>)
{
    if(setVisible.value){
        AlertDialog(
            onDismissRequest ={  setVisible.value=false },

            confirmButton = {
                TextButton(onClick = {setVisible.value=false}) {
                    Text(text = "Yes")
                }
            },

            text = { Text(text = "Are you leaving ?")
            }
        )


    }
}



