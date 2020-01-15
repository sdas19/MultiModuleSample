package com.example.core.di

import android.app.Application
import android.content.Context
import com.example.core.ApiClient
import com.example.core.di.module.ApiModule
import com.example.core.di.module.AppModule
import com.google.gson.Gson
import dagger.Component
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import javax.inject.Singleton

@Singleton
@Component(modules = [ApiModule::class, AppModule::class])
interface CoreComponent {

    /*
     * The methods below are sort of a 'promise' that this Component can provide these objects to dependent Components.
     * This is done because we cannot use the sub-components (hard coded connection) with our (dynamic) feature modules.
     */

    fun application(): Application
    fun httpCache(): Cache
    fun gson(): Gson
    fun okHtppClient(): OkHttpClient
    fun retrofit(): Retrofit
    fun apiClient(): ApiClient
}