package com.odogwudev.supportallscreens.ui.layoutmodes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update

class LayoutModesViewModel : ViewModel() {
    private val viewModelState = MutableStateFlow(LayoutModesUiState())

    val uiState = viewModelState
        .stateIn(
            viewModelScope,
            SharingStarted.Eagerly,
            LayoutModesUiState()
        )

    fun closeDetails() {
        viewModelState.update {
            it.copy(detailsSelected = false)
        }
    }

    fun openDetails() {
        viewModelState.update {
            it.copy(detailsSelected = true)
        }
    }
}

data class LayoutModesUiState(
    val detailsSelected: Boolean = false
)

//majorly to check the number the user selected and whether a number has been selected
//actions open and close details