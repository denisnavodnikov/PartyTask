package ru.navodnikov.denis.partytask.ui.party

import androidx.lifecycle.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import ru.navodnikov.denis.partytask.R
import ru.navodnikov.denis.domain.entity.PartyItem
import ru.navodnikov.denis.domain.usecases.GetPartyItemUseCase

class PartyViewModel(private val getPartyItemUseCase: GetPartyItemUseCase) : ViewModel(), PartyContract.ViewModel {

    private val partyLiveData: MutableLiveData<PartyItem> = MutableLiveData()
    private var massageLiveData: MutableLiveData<Int> = MutableLiveData()

    init {
        viewModelScope.launch {
            withContext(Dispatchers.Main) {
                try {
                    getPartyItemUseCase.execute()
                        .flowOn(Dispatchers.IO)
                        .collect {
                            partyLiveData.value = it
                        }
                } catch (e: Exception) {
                    massageLiveData.value = R.string.error_loading
                }
            }
        }
    }

    override fun getPartyLiveData(): LiveData<PartyItem> = partyLiveData
    override fun getMassageLiveData(): LiveData<Int> = massageLiveData

}