package one.reevdev.traveoli.ui.screen.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import one.reevdev.traveoli.ui.component.HomeTabs
import one.reevdev.traveoli.ui.data.TabItem
import one.reevdev.traveoli.ui.screen.home.trip.TripScreen
import one.reevdev.traveoli.ui.theme.TraveoliTheme
import one.reevdev.traveoli.utils.DefaultValues

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = hiltViewModel(),
) {
    val uiState: HomeState by viewModel.uiState.collectAsStateWithLifecycle()
    var tabIndex by remember { mutableStateOf(0) }

    HomeContent(
        modifier = modifier
            .fillMaxWidth(),
        tabs = uiState.tabs,
        selectedTabIndex = tabIndex,
        onTabClick = { index ->
            tabIndex = index
        }
    )

    when(tabIndex) {
        0 -> {
            TripScreen(
                modifier = modifier
            )
        }
    }
}

@Composable
fun HomeContent(
    modifier: Modifier = Modifier,
    tabs: List<TabItem>,
    selectedTabIndex: Int = 0,
    onTabClick: (index: Int) -> Unit,
) {
    Column(
        modifier = modifier
    ) {
        HomeTabs(
            tabs = tabs,
            selectedTabIndex = selectedTabIndex,
            onTabClick = { index ->
                onTabClick(index)
            }
        )
    }
}

@Preview
@Composable
fun HomeContentPreview() {
    TraveoliTheme {
        HomeContent(tabs = DefaultValues.homeTabs, onTabClick = {})
    }
}