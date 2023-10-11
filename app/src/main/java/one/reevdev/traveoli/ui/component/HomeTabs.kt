package one.reevdev.traveoli.ui.component

import androidx.compose.material3.Icon
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import one.reevdev.traveoli.ui.data.TabItem

@Composable
fun HomeTabs(
    modifier: Modifier = Modifier,
    tabs: List<TabItem>,
    selectedTabIndex: Int,
    onTabClick: (Int) -> Unit,
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
                icon = { Icon(imageVector = tab.icon, contentDescription = tab.text) },
                onClick = {
                    onTabClick(index)
                }
            )
        }
    }
}