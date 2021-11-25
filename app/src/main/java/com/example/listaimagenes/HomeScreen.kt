package com.example.listaimagenes


import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.*
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberImagePainter
import com.example.listaimagenes.modelos.Imagenes


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen (navController: NavController) {

    LazyColumn(
        modifier = Modifier
            .background(Color(0, 0, 0))
            .fillMaxSize()
        ) {
        stickyHeader{
            Titulo()
            Spacer(modifier = Modifier.size(15.dp))
        }


        items(listaUrl()) { url ->
            Row(modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    navController.navigate(
                        Screen.Second.pasarSerie(
                            url.id,
                            url.titulo,
                            url.url,
                            url.desc,
                            url.temporadas
                        )
                    )
                }) {
                CargarImagen(url = url.url)
            }
            Row() {
                Text(text = url.titulo, textAlign = TextAlign.Center, fontSize = 20.sp, color = Color.White
                    ,fontFamily = FontFamily.Monospace, modifier = Modifier.fillMaxWidth()
                      )

            }

        }

        }

    }

@Composable

fun CargarImagen(url: String) {
    Image(
       painter = rememberImagePainter(url),
       contentDescription = null , modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .height(190.dp)
            .clip(RoundedCornerShape(80.dp)), contentScale = ContentScale.FillWidth

    )
}

@Composable
fun Titulo(){
        Text(text = "SERIES NETFLIX", color= Color.Black,
            fontSize =35.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            fontFamily = FontFamily.Monospace, modifier = Modifier
                .fillMaxWidth()
                .background(color = Color.LightGray))

}


fun listaUrl(): ArrayList<Imagenes> {

    val lista : ArrayList<Imagenes> = ArrayList()
       lista.add(
           Imagenes(
               1,
                "YOU",
                "https:\\encrypted-tbn0.gstatic.com\\images?q=tbn:ANd9GcT1iYNAQ5i5JPJxZiAJ31SeItDAy3jG7KXQLgoqEvpmLPcEb0LM6oMJyhieNGVyjS_vpFU&usqp=CAU",
               "Joe Goldberg es un joven brillante, pero que tiene todo el perfil de un psicópata acosador "+ " y obsesivo. " +
                       "Es un personaje oscuro con un enorme carisma, un ser que tiene una visión bastante "+" retorcida del amor. Su personalidad, carácter y encanto "+
                       "   lo llevarán a “enamorarse” de forma enfermiza, siendo capaz de llegar a cometer actos atroces " +
                       "y crueles.",
               3

           )
       )
       lista.add(
        Imagenes(
            2,
            "LOVE-DEATH-ROBOTS",
           "https:\\i.blogs.es\\eda894\\love-death-robots\\1366_2000.jpeg",
            "La serie, antología de episodios autoconclusivos, aborda distintos géneros, desde la comedia a " +
                    "la ciencia-ficción pasando por el terror o la fantasía, con claves de escenarios de apocalipsis," +
                    " cyberpunk, ambiente espacial, monstruos, tecnología…",
            3

       )

    )
    lista.add(
    Imagenes(
         3,
         "GOOD GIRLS",
         "https:\\hips.hearstapps.com\\hmg-prod.s3.amazonaws.com\\images\\chicas-malas-temporada-4-netflix-1630399386.jpeg?crop=1xw:1xh;center,top&resize=980:*",
    "Tres madres suburbanas con problemas económicos deciden poner fin a su calvario de no llegar a fin de mes, y lo hacen con una decisión que marca " +
            "su vida: piensan robar un supermercado con una pistola de juguete.",
        4
    )
    )
    lista.add(
    Imagenes (
        4,
         "BREAKING BAD",
         "https:\\i.blogs.es\\16e585\\breaking-bad\\1366_2000.jpg",
    "Un profesor de química con cáncer terminal se asocia con un exalumno suyo para fabricar y vender " +
            "metanfetamina a fin de que su familia no pase apuros económicos.",
        6
            )

    )
    lista.add(
    Imagenes(
         5,
        "DARK",
         "https:\\e00-marca.uecdn.es\\assets\\multimedia\\imagenes\\2020\\06\\21\\15926910732971.jpg",
        "Dark sigue las secuelas de la desaparición de un niño que expone los secretos y las conexiones ocultas entre cuatro familias mientras" +
                " desentrañan lentamente una siniestra conspiración de viaje en el tiempo que abarca tres generaciones.",
        4
        )
    )
    lista.add(
        Imagenes(
            6,
            "PRISON BREAK",
            "https:\\i.pinimg.com\\564x\\56\\c7\\9c\\56c79c4a1cf2f6698ff337b727c6900c.jpg",
            "La trama de la serie gira en torno a Michael Scofield, que en un elaborado plan para rescatar a su" +
                    " hermano Lincoln Burrows, entra a una cárcel de máxima seguridad cerca de " +
                    "Chicago, para sacar a su hermano acusado por un falso asesinato del hermano de la vicepresidenta.",
            8
        )
    )

   return lista

}

@Composable
fun PreviewGreeting() {
    HomeScreen(
        navController = rememberNavController()
    )
}



