package com.rk.riggle_retailer.utils.event

import androidx.annotation.MainThread

class SingleActionEvent<T> : SingleLiveEvent<T>() {
    @MainThread
    override fun call() {
        value = null
    }
}