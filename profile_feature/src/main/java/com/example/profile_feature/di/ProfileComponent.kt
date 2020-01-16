package com.example.profile_feature.di

import com.example.core.di.CoreComponent
import com.example.core.di.scope.ActivityScope
import com.example.profile_feature.ProfileActivity
import dagger.Component

@ActivityScope
@Component(
    modules = [ProfileModule::class],
    dependencies = [CoreComponent::class] // so we can use all objects that CoreComponent provides
)
interface ProfileComponent {
    fun inject(profileActivity: ProfileActivity)
}