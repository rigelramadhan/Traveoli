package one.reevdev.traveoli.ui.screen.home.trip

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import one.reevdev.traveoli.core.domain.entity.Trip
import one.reevdev.traveoli.core.domain.usecase.TravelUseCase
import one.reevdev.traveoli.utils.DefaultValues
import one.reevdev.traveoli.utils.Resource
import javax.inject.Inject

@HiltViewModel
class TripViewModel @Inject constructor(
    private val travelUseCase: TravelUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(TripUiState())
    val uiState: StateFlow<TripUiState> by lazy { _uiState }

    init {
        loadTrips()
    }

    private fun loadTrips() {
        viewModelScope.launch {
            travelUseCase.getTrips("test")
                .catch {
                    _uiState.value = TripUiState(
                        Resource.Error(it.message ?: DefaultValues.DEFAULT_ERROR)
                    )
                }
                .collect { trips ->
                    _uiState.value = TripUiState(Resource.Success(trips))
                }
        }
    }
}

data class TripUiState(
    val trips: Resource<List<Trip>> = Resource.Loading()
)