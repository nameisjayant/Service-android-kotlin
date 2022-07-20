package com.yt.mynavigation

import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import android.provider.MediaStore
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.result.launch
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.graphics.decodeBitmap
import java.util.jar.Manifest


@Composable
fun PickImageFromGallery() {

    var imageUri by remember { mutableStateOf<Uri?>(null)}
    val context = LocalContext.current
    var bitmap by remember { mutableStateOf<Bitmap?>(null)}

    val launcher = rememberLauncherForActivityResult(contract =
        ActivityResultContracts.GetContent()){
        imageUri = it
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = {
            launcher.launch("image/*")
        }) {
            Text(text = "Pick Image")
        }
        
        Spacer(modifier = Modifier.height(15.dp))

        imageUri?.let {
            bitmap = if(Build.VERSION.SDK_INT < 28){
                MediaStore.Images.Media.getBitmap(context.contentResolver,it)
            }else{
                val source = ImageDecoder.createSource(context.contentResolver,it)
                ImageDecoder.decodeBitmap(source)
            }

            Image(bitmap = bitmap?.asImageBitmap()!!, contentDescription = "" ,
                modifier = Modifier.size(200.dp)
            )
        }
    }


}


@Composable
fun PickImageFromCamera() {

    var bitmap by remember{ mutableStateOf<Bitmap?>(null)}

    val launcher = rememberLauncherForActivityResult(contract =
        ActivityResultContracts.TakePicturePreview()){
        bitmap = it
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = {
            launcher.launch()
        }) {
            Text(text = "Pick Image From Camera")
        }

        Spacer(modifier = Modifier.height(15.dp))

        bitmap?.let {
            Image(bitmap?.asImageBitmap()!!, contentDescription = "", modifier = Modifier.size(200.dp))
        }
    }
}


@Composable
fun PickImageFromCameraX(context:Activity) {

    val requestPermissionLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission()){
        when(it){
             true -> {
                 Log.d("main", "Permission granted")
             }
            false -> {
                Log.d("main", "Permission denied")
            }
        }
    }

    when {
        ContextCompat.checkSelfPermission(
            context,
            android.Manifest.permission.CAMERA
        ) == PackageManager.PERMISSION_GRANTED -> {
            Log.d("main", "Permission already granted")
        }

        ActivityCompat.shouldShowRequestPermissionRationale(
            context,
            android.Manifest.permission.CAMERA
        ) -> {
            requestPermissionLauncher.launch(android.Manifest.permission.CAMERA)
        }
    }

}
