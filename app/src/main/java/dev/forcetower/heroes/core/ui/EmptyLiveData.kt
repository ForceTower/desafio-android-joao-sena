package dev.forcetower.heroes.core.ui

import androidx.lifecycle.LiveData

class EmptyLiveData<T> private constructor() : LiveData<T>() {
    init { postValue(null) }

    companion object {
        fun <T> create(): LiveData<T> {
            return EmptyLiveData()
        }
    }
}