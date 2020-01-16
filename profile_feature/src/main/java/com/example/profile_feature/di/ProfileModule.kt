package com.example.profile_feature.di

import dagger.Module
import dagger.Provides

@Module
class ProfileModule {

    @Provides
    fun providesString() = "String from Profile Module"
}