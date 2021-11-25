package com.example.listaimagenes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter

@Composable
fun SecondScreen (
    id: Int,
    titulo: String,
    url: String,
    desc: String,
    temporadas: Int,
    ){

    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color(0, 0, 0,))){

        Row(){
            Text(text = titulo, textAlign = TextAlign.Center, fontSize = 26.sp, color = Color.White
                ,fontFamily = FontFamily.Monospace,
                fontWeight = FontWeight.Bold
                ,modifier = Modifier.fillMaxWidth().padding(top = 10.dp)
            )

        }
        Spacer(modifier = Modifier.size(10.dp))
        Row(
            Modifier.fillMaxWidth()){
            CargarFoto(url = url)
        }
        Spacer(modifier = Modifier.size(20.dp))
        Row(modifier = Modifier
            .fillMaxWidth()
            .background(Color(10, 10, 10))
            .padding(5.dp)
            .border(
                4.dp, color = Color(10,150,200),
                RoundedCornerShape(16.dp)
            )){
            Text(text = desc,color = Color.White,
                fontSize =20.sp,
                textAlign = TextAlign.Center,
                fontFamily = FontFamily.Monospace,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(6.dp)
                )
        }
        Spacer(modifier = Modifier.size(20.dp))
        Row(modifier = Modifier
            .fillMaxWidth().height(44.dp).align(alignment = Alignment.CenterHorizontally)
            .background(Color(10, 10, 10))
            .padding(5.dp)
            .border(
                4.dp, color = Color(10,150,200),
                RoundedCornerShape(16.dp)
            )){
            Text(text = "Temporadas: $temporadas", textAlign = TextAlign.Center, fontSize = 20.sp,
                color = Color.White
                ,fontFamily = FontFamily.Monospace,
                modifier = Modifier.fillMaxWidth()
            )
        }


    }
}


@Composable
fun CargarFoto(url: String) {
    Image(
        painter = rememberImagePainter(url),
        contentDescription = null,
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .height(190.dp)
            .clip(RoundedCornerShape(80.dp)),
        contentScale = ContentScale.FillWidth
    )
}






