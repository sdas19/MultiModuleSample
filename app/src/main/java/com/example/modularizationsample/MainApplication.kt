package com.example.modularizationsample

import android.app.Application
import com.example.core.di.CoreComponent
import com.example.core.di.CoreComponentProvider
import com.example.core.di.DaggerCoreComponent
import com.example.core.di.module.ApiModule
import com.example.core.di.module.AppModule

class MainApplication : Application(), CoreComponentProvider {

    lateinit var coreComponent: CoreComponent

    override fun onCreate() {
        super.onCreate()
        coreComponent = DaggerCoreComponent.builder()
            .appModule(AppModule(this))
            .apiModule(ApiModule("https://reqres.in/"))
            .build()
    }

    override fun provideCoreComponent(): CoreComponent = coreComponent

}