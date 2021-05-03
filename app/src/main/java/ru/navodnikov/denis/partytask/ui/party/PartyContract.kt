package ru.navodnikov.denis.partytask.ui.party

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ru.navodnikov.denis.domain.entity.PartyItem
import ru.navodnikov.denis.partytask.ui.BaseContract

class PartyContract {
    interface ViewModel : BaseContract.ViewModel {
        fun getPartyLiveData(): LiveData<PartyItem>
        fun getMassageLiveData(): LiveData<Int>
    }
}