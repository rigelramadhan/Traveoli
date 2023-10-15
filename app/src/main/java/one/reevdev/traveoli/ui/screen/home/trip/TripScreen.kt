package one.reevdev.traveoli.ui.screen.home.trip

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import one.reevdev.traveoli.core.domain.entity.Trip
import one.reevdev.traveoli.ui.component.TraveoliError
import one.reevdev.traveoli.ui.component.TraveoliLoading
import one.reevdev.traveoli.ui.component.TripItem

@Composable
fun TripScreen(
    modifier: Modifier = Modifier,
    viewModel: TripViewModel = hiltViewModel()
) {
    val uiState: TripUiState by viewModel.uiState.collectAsStateWithLifecycle()

    uiState.trips.handle(
        onLoading = {
            TraveoliLoading()
        },
        onSuccess = { trips ->
            TripContent(trips = trips)
        },
        onFailure = { message ->
            TraveoliError(message = message)
        }
    )
}

@Composable
fun TripContent(
    modifier: Modifier = Modifier,
    trips: List<Trip>,
) {
    LazyColumn(
        modifier = modifier,
        content = {
            items(trips) { trip ->
                TripItem(
                    modifier = Modifier,
                    trip = trip
                )
            }
        }
    )
}