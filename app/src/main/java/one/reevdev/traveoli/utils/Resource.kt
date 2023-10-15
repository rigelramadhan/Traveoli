package one.reevdev.traveoli.utils

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable

sealed class Resource<T>(val data: T? = null, val message: String? = null) {
    class Success<T>(data: T) : Resource<T>(data)
    class Loading<T>(data: T? = null) : Resource<T>(data)
    class Error<T>(message: String, data: T? = null) : Resource<T>(data, message)

    @SuppressLint("ComposableNaming")
    @Composable
    fun handle(
        onLoading: @Composable () -> Unit,
        onSuccess: @Composable (data: T) -> Unit,
        onFailure: @Composable (message: String?) -> Unit
    ) {
        when(this) {
            is Loading -> { onLoading() }
            is Success -> {
                if (data.isNotNull()) onSuccess(this.data!!)
                else onFailure(DefaultValues.DEFAULT_DATA_EMPTY)
            }
            is Error -> { onFailure(this.message) }
        }
    }
}