package com.example.myviewmodelexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.lifecycle.lifecycleScope
import com.example.myviewmodelexample.ui.theme.MyViewModelExampleTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel: MyViewModel by viewModels()

        lifecycleScope.launch {
            //here you could do stuff - getting from api etc and store
            //in viewmodel

        }


        setContent {
            MyViewModelExampleTheme {
                var counter2 by remember {
                    mutableStateOf(1)
                }
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column()
                    {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.Center
                        ) {
                            Button(modifier = Modifier.fillMaxWidth(),
                                onClick = {
                                    viewModel.counter.value++
                                }) {
                                Text("Increase counter")
                            }
                        }

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.Center
                        ) {
                            ShowCounter(counter = viewModel.counter.value)
                        }

                        Button(modifier = Modifier.fillMaxWidth(),
                            onClick = {
                                counter2++
                            }) {
                            Text("Increase counter 2")
                        }

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.Center
                        ) {
                            ShowCounter(counter = counter2)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun ShowCounter(counter: Int, modifier: Modifier = Modifier) {
    Text(
        text = "Counter value: $counter",
        modifier = modifier,
        fontSize = 26.sp
    )
}
