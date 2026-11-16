package com.example.nesterenko.lab_1ml

import android.app.Application
import com.example.nesterenko.lab_1ml.data.AppContainer

class BookTrackerApplication : Application() {
    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()

        container = AppContainer(applicationContext)
    }
}
