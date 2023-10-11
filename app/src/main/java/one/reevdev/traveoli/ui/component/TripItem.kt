package one.reevdev.traveoli.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import one.reevdev.traveoli.R
import one.reevdev.traveoli.core.domain.entity.Activity
import one.reevdev.traveoli.core.domain.entity.Destination
import one.reevdev.traveoli.core.domain.entity.Trip
import one.reevdev.traveoli.ui.theme.TraveoliTheme

@Composable
fun TripItem(
    modifier: Modifier = Modifier,
    trip: Trip,
) {
    Card(
        modifier = modifier
    ) {
        Column(
            modifier = Modifier
        ) {
            Image(
                modifier = Modifier
                    .aspectRatio(1.4f),
                painter = painterResource(id = R.drawable.img_default_destination),
                contentDescription = stringResource(
                    R.string.content_description_destination_image
                ),
                contentScale = ContentScale.Crop
            )
            Text(
                modifier = Modifier
                    .padding(8.dp),
                text = trip.tripName,
                style = MaterialTheme.typography.titleSmall
            )
            trip.notes?.let {
                Divider()
                Text(
                    modifier = Modifier
                        .padding(8.dp),
                    text = it,
                    style = MaterialTheme.typography.bodySmall
                )
            } ?: Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

@Preview(showBackground = true, device = Devices.PIXEL_4)
@Composable
fun TripItemPreview() {
    TraveoliTheme {
        val destinationDummy = Destination(
            0,
            "Landscepo 101",
            "This landscape was founded by Italian-Spanish explorers. It was officially named Landscepo when those explorers brainstorm the idea in the middle of the farm field",
        )
        val activityDummy = Activity(
            activityId = 0,
            tripId = "",
            name = "Jumping around",
            duration = 3,
            notes = "Just jumping you know what I'm saying"
        )
        val tripDummy = Trip(
            tripId = 0,
            userId = "",
            tripName = "Natural Landscape",
            destination = destinationDummy,
            budget = 2500000,
            notes = "This is for post exam!",
            activities = listOf(activityDummy, activityDummy, activityDummy, activityDummy)
        )
        Column(
            modifier = Modifier
                .padding(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            TripItem(
                trip = tripDummy
            )
            TripItem(
                trip = tripDummy
            )
            TripItem(
                trip = tripDummy
            )
        }
    }
}