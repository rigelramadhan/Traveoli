package one.reevdev.traveoli.utils

import one.reevdev.traveoli.R
import one.reevdev.traveoli.ui.data.TabItem

object DefaultValues {

    val homeTabs = listOf(
        TabItem(text = "Trip", iconDrawable = R.drawable.ic_travel_24),
        TabItem(text = "Destination", iconDrawable = R.drawable.ic_destinations_24)
    )

    const val DEFAULT_ERROR = "Oops! Something went wrong."
    const val DEFAULT_DATA_EMPTY = "What you're looking for doesn't exist :("
}