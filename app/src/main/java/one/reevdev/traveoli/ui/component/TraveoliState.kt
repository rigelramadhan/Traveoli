package one.reevdev.traveoli.ui.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import one.reevdev.traveoli.utils.DefaultValues
import one.reevdev.traveoli.utils.or


@Composable
fun TraveoliLoading(
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier.fillMaxSize()) {
        CircularProgressIndicator(
            modifier = Modifier
                .align(Alignment.Center)
        )
    }
}

@Composable
fun TraveoliError(
    modifier: Modifier = Modifier,
    message: String? = null
) {
    Box(modifier = modifier.fillMaxSize()) {
        Text(
            modifier = Modifier
                .align(Alignment.Center),
            text = message.or(DefaultValues.DEFAULT_ERROR)
        )
    }
}