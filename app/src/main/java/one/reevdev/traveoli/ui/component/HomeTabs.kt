package one.reevdev.traveoli.ui.component

import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import one.reevdev.traveoli.ui.data.TabItem
import one.reevdev.traveoli.ui.theme.TraveoliTheme
import one.reevdev.traveoli.utils.DefaultValues

@Composable
fun HomeTabs(
    modifier: Modifier = Modifier,
    tabs: List<TabItem>,
    selectedTabIndex: Int,
    onTabClick: (index: Int) -> Unit,
) {
    TabRow(
        modifier = modifier,
        selectedTabIndex = selectedTabIndex,
    ) {
        tabs.forEachIndexed { index, tab ->
            Tab(
                modifier = Modifier,
                selected = index == selectedTabIndex,
                text = { Text(text = tab.text) },
                icon = {
                    Icon(
                        imageVector = ImageVector.vectorResource(id = tab.iconDrawable),
                        contentDescription = tab.text
                    )
                },
                selectedContentColor = MaterialTheme.colorScheme.primary,
                unselectedContentColor = Color.Gray,
                onClick = {
                    onTabClick(index)
                }
            )
        }
    }
}

@Preview
@Composable
fun HomeTabsPreview() {
    TraveoliTheme {
        HomeTabs(tabs = DefaultValues.homeTabs, selectedTabIndex = 1, onTabClick = {})
    }
}