package com.sosauce.cutemusic.ui.screens.settings.compenents

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.sosauce.cutemusic.R
import com.sosauce.cutemusic.ui.shared_components.CuteText

@Composable
fun AboutCard() {

    val context = LocalContext.current
    val version = context.packageManager.getPackageInfo(context.packageName, 0).versionName
    val uriHandler = LocalUriHandler.current

    Card(
        colors = CardDefaults.cardColors(MaterialTheme.colorScheme.surfaceContainer),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 2.dp),
        shape = RoundedCornerShape(24.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painterResource(id = R.drawable.cute_music_icon),
                contentDescription = stringResource(id = R.string.app_icon),
                modifier = Modifier
                    .size(100.dp)
                    .padding(15.dp)
                    .clip(RoundedCornerShape(15))
            )
            Column {
                CuteText(
                    text = stringResource(id = R.string.cm_by_sosauce),

                    )
                CuteText(
                    text = "${stringResource(id = R.string.version)} $version",
                    color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.85f)
                )
            }
        }
        Row(
            modifier = Modifier
                .padding(8.dp)
        ) {
            Button(
                onClick = { uriHandler.openUri("https://github.com/sosauce/CuteMusic/releases") },
                shape = RoundedCornerShape(
                    topStart = 24.dp,
                    bottomStart = 24.dp,
                    topEnd = 24.dp,
                    bottomEnd = 24.dp
                ),
                modifier = Modifier.fillMaxWidth()
            ) {
                CuteText(text = stringResource(id = R.string.update))
            }
//                Spacer(modifier = Modifier.width(2.dp))
//                Button(
//                    onClick = { uriHandler.openUri("https://bit.ly/sosaucePayPal") },
//                    shape = RoundedCornerShape(
//                        topStart = 4.dp,
//                        bottomStart = 4.dp,
//                        topEnd = 24.dp,
//                        bottomEnd = 24.dp
//                    ),
//                    modifier = Modifier.weight(1f)
//                ) {
//                    CuteText(text = stringResource(id = R.string.support))
//
//                }
        }
    }
}