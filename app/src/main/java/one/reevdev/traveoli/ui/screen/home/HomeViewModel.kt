package one.reevdev.traveoli.ui.screen.home

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import one.reevdev.traveoli.core.domain.usecase.TravelUseCase
import one.reevdev.traveoli.ui.data.TabItem
import one.reevdev.traveoli.utils.DefaultValues
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val travelUseCase: TravelUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(HomeState())
    val uiState: StateFlow<HomeState> by lazy { _uiState }
}

data class HomeState(
    val tabs: List<TabItem> = DefaultValues.homeTabs,
)