package com.example.lab1mob

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lab1mob.ui.theme.Lab1mobTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Lab1mobTheme {
                BusinessCardApp()
            }
        }
    }
}

@Composable
fun BusinessCardApp() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = colorResource(id = R.color.background)
    ) {
        val configuration = LocalConfiguration.current
        val isLandscape = configuration.orientation == android.content.res.Configuration.ORIENTATION_LANDSCAPE

        BusinessCardContent(isLandscape = isLandscape)
    }
}

@Composable
fun BusinessCardContent(isLandscape: Boolean) {
    val maxContentWidth = dimensionResource(id = R.dimen.max_content_width)

    if (isLandscape) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(dimensionResource(id = R.dimen.padding_large)),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Ограничиваем максимальную ширину контента на планшетах
            Box(
                modifier = Modifier.widthIn(max = maxContentWidth)
            ) {
                Row(
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    // Левая часть
                    Column(
                        modifier = Modifier.weight(1f),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        AvatarImage()
                        Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.spacing_large)))
                        NameAndGroup()
                    }

                    // Правая часть
                    Column(
                        modifier = Modifier
                            .weight(1f)
                            .padding(start = dimensionResource(id = R.dimen.spacing_large)),
                        horizontalAlignment = Alignment.Start,
                        verticalArrangement = Arrangement.Center
                    ) {
                        ContactInfo()
                    }
                }
            }
        }
    } else {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(dimensionResource(id = R.dimen.padding_large)),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // Ограничиваем максимальную ширину контента
            Box(
                modifier = Modifier.widthIn(max = maxContentWidth)
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    AvatarImage()
                    Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.spacing_large)))
                    NameAndGroup()
                    Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.section_spacing)))
                    ContactInfo()
                }
            }
        }
    }
}


@Composable
fun AvatarImage() {
    Image(
        painter = painterResource(id = R.drawable.avatar),
        contentDescription = stringResource(id = R.string.full_name),
        modifier = Modifier.size(dimensionResource(id = R.dimen.avatar_size)),
        contentScale = ContentScale.Crop
    )
}

@Composable
fun NameAndGroup() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(id = R.string.full_name),
            color = colorResource(id = R.color.text_primary),
            fontSize = dimensionResource(id = R.dimen.text_large).value.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(bottom = dimensionResource(id = R.dimen.spacing_small))
        )

        Text(
            text = stringResource(id = R.string.position),
            color = colorResource(id = R.color.text_secondary),
            fontSize = dimensionResource(id = R.dimen.text_medium).value.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(bottom = dimensionResource(id = R.dimen.spacing_small))
        )

        Text(
            text = stringResource(id = R.string.group),
            color = colorResource(id = R.color.text_secondary),
            fontSize = dimensionResource(id = R.dimen.text_small).value.sp,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun ContactInfo() {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = "Контакты:",
            color = colorResource(id = R.color.text_primary),
            fontSize = dimensionResource(id = R.dimen.text_medium).value.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = dimensionResource(id = R.dimen.spacing_medium))
        )

        Text(
            text = "Email: ${stringResource(id = R.string.email)}",
            color = colorResource(id = R.color.text_primary),
            fontSize = dimensionResource(id = R.dimen.text_small).value.sp,
            modifier = Modifier.padding(bottom = dimensionResource(id = R.dimen.spacing_small))
        )

        Text(
            text = "Телефон: ${stringResource(id = R.string.phone)}",
            color = colorResource(id = R.color.text_primary),
            fontSize = dimensionResource(id = R.dimen.text_small).value.sp,
            modifier = Modifier.padding(bottom = dimensionResource(id = R.dimen.spacing_small))
        )

        Text(
            text = "Telegram: ${stringResource(id = R.string.telegram)}",
            color = colorResource(id = R.color.text_primary),
            fontSize = dimensionResource(id = R.dimen.text_small).value.sp
        )
    }
}

@Preview(
    showBackground = true,
    name = "Портрет",
    widthDp = 360,
    heightDp = 640
)
@Composable
fun PortraitPreview() {
    Lab1mobTheme {
        BusinessCardContent(isLandscape = false)
    }
}

@Preview(
    showBackground = true,
    name = "Ландшафт",
    widthDp = 640,
    heightDp = 360
)
@Composable
fun LandscapePreview() {
    Lab1mobTheme {
        BusinessCardContent(isLandscape = true)
    }
}