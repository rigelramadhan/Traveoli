package one.reevdev.traveoli.ui.screen.home.destination

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import one.reevdev.traveoli.core.domain.entity.Destination
import one.reevdev.traveoli.core.domain.usecase.TravelUseCase
import one.reevdev.traveoli.utils.Resource
import javax.inject.Inject

@HiltViewModel
class DestinationViewModel @Inject constructor(
    private val travelUseCase: TravelUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow<Resource<DestinationUiState>>(Resource.Loading())
    val uiState: StateFlow<Resource<DestinationUiState>> by lazy { _uiState }

    fun loadDestinations() {
        viewModelScope.launch {
            travelUseCase.getDestinations()
                .catch {

                }
                .collect { destinations ->
                    _uiState.value = Resource.Success(DestinationUiState(destinations))
                }
        }
    }
}

data class DestinationUiState(
    val destinations: List<Destination>
)