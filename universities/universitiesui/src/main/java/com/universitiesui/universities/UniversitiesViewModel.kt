package com.universitiesui.universities

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aait.coreui.util.fromJson
import com.coredomain.util.DataState
import com.universitiesdomain.model.Universities
import com.universitiesdomain.model.University
import com.universitiesdomain.usecase.OfflineUniversitiesUseCase
import com.universitiesdomain.usecase.SetOfflineUniversitiesUseCase
import com.universitiesdomain.usecase.UniversitiesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class UniversitiesViewModel @Inject constructor(
    private val universitiesUseCase: UniversitiesUseCase,
    private val setOfflineUniversitiesUseCase: SetOfflineUniversitiesUseCase,
    private val offlineUniversitiesUseCase: OfflineUniversitiesUseCase
) : ViewModel() {

    private val _universitiesResponse = Channel<DataState<MutableList<University>>>()
    val universitiesResponse
        get() = _universitiesResponse.receiveAsFlow()

    private var _universitiesOfflineResponse = Channel<MutableList<University>>()
    val universitiesOfflineResponse get() = _universitiesOfflineResponse.receiveAsFlow()
    fun getUniversities() {
        viewModelScope.launch {
            universitiesUseCase.invoke().collectLatest {
                _universitiesResponse.send(it)
            }
        }
    }

    fun getOfflineUniversities() {
        viewModelScope.launch {
            offlineUniversitiesUseCase.invoke().collectLatest {
                if (it.isNotEmpty()) {
                    _universitiesOfflineResponse.send(it.fromJson<Universities>().universities)
                }
            }
        }
    }

    fun setUniversities(list: String) {
        viewModelScope.launch {
            delay(500)
            setOfflineUniversitiesUseCase.invoke(list)
        }
    }
}