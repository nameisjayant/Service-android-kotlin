package com.yt.mynavigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet


@Composable
fun ConstraintLayoutDemo() {
   // ConstraintExample2()
    ConstraintLayoutWithConstraintSet()
}

@Composable
fun ConstraintLayoutWithConstraintSet() {

    val constraints = ConstraintSet {
        val username = createRefFor("username")
        val password = createRefFor("password")
        val button = createRefFor("button")

        constrain(username) {
            top.linkTo(parent.top, 20.dp)
            start.linkTo(parent.start, 20.dp)
            end.linkTo(parent.end, 20.dp)
        }

        constrain(password) {
            top.linkTo(username.bottom, 10.dp)
            start.linkTo(parent.start, 20.dp)
            end.linkTo(parent.end, 20.dp)
        }

        constrain(button) {
            top.linkTo(password.bottom, 10.dp)
            start.linkTo(parent.start, 20.dp)
            end.linkTo(parent.end, 20.dp)
        }
    }

    ConstraintLayout(
        constraintSet = constraints,
        modifier = Modifier.fillMaxWidth()
    ) {
        var username by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }

        TextField(
            value = username,
            onValueChange = {
                username = it
            },
            placeholder = { Text(text = "Enter user name") },
            modifier = Modifier
                .layoutId("username")
        )

        TextField(
            value = password,
            onValueChange = {
                password = it
            },
            placeholder = { Text(text = "Enter password") },
            modifier = Modifier
                .layoutId("password"),
            visualTransformation = PasswordVisualTransformation()
        )

        Button(onClick = { /*TODO*/ },
            modifier = Modifier
                .layoutId("button")
        ) {
            Text(text = "Login")
        }

    }


}

@Composable
fun ConstraintWithChain() {

    ConstraintLayout(
        modifier = Modifier.fillMaxSize()
    ) {
        val (box1, box2, box3) = createRefs()

        createHorizontalChain(
            box1,
            box2,
            box3,
            chainStyle = ChainStyle.Spread
        )

        Box(modifier = Modifier
            .size(50.dp)
            .background(Color.Red)
            .constrainAs(box1) {
                start.linkTo(parent.start)
                top.linkTo(parent.top)
            }
        )


        Box(modifier = Modifier
            .size(50.dp)
            .background(Color.Yellow)
            .constrainAs(box2) {
                start.linkTo(box1.end)
                top.linkTo(box1.top)
                bottom.linkTo(box1.bottom)
            }
        )

        Box(modifier = Modifier
            .size(50.dp)
            .background(Color.Black)
            .constrainAs(box3) {
                top.linkTo(box2.top)
                bottom.linkTo(box2.bottom)
                start.linkTo(box2.end)
            }
        )

    }

}

@Composable
fun Example() {
    ConstraintLayout(
        modifier = Modifier.padding(20.dp)
    ) {
        val (box1, box2, box3) = createRefs()

        Box(modifier = Modifier
            .size(150.dp)
            .background(Color.Red)
            .constrainAs(box1) {}
        )
        Box(modifier = Modifier
            .size(100.dp)
            .background(Color.Yellow)
            .constrainAs(box2) {}
        )
        Box(modifier = Modifier
            .size(50.dp)
            .background(Color.Black)
            .constrainAs(box3) {}
        )
    }

}

@Composable
fun ConstraintExample1() {

    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp)
    ) {
        val (firstText, secondText, thirdText) = createRefs()

        Text(text = "Text one",
            modifier = Modifier.constrainAs(firstText) {
                top.linkTo(parent.top)
                start.linkTo(parent.start)
                bottom.linkTo(parent.bottom)
            }
        )
        Text(text = "Text two",
            modifier = Modifier.constrainAs(secondText) {
                top.linkTo(parent.top)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                bottom.linkTo(parent.bottom)
            }
        )
        Text(text = "Text three",
            modifier = Modifier.constrainAs(thirdText) {
                top.linkTo(parent.top)
                end.linkTo(parent.end)
                bottom.linkTo(parent.bottom)
            }
        )
    }

}

@Composable
fun ConstraintExample2() {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 20.dp)
    ) {
        val (firstText, secondText, thirdText) = createRefs()

        Text(text = "Text one",
            modifier = Modifier.constrainAs(firstText) {
                top.linkTo(parent.top)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
        )
        Text(text = "Text two",
            modifier = Modifier.constrainAs(secondText) {
                top.linkTo(parent.top)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                bottom.linkTo(parent.bottom)
            }
        )
        Text(text = "Text three",
            modifier = Modifier.constrainAs(thirdText) {
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                bottom.linkTo(parent.bottom)
            }
        )
    }

}