package com.example.modularizationsample.di

import com.example.core.di.CoreComponent
import com.example.core.di.scope.ActivityScope
import com.example.modularizationsample.MainActivity
import dagger.Component

@ActivityScope // add scope, because we cannot use the same scope as the component we depend upon (CoreComponent).
@Component(
    modules = [MainActivityModule::class],
    dependencies = [CoreComponent::class] // so we can use all objects that CoreComponent provides
)
interface MainActivityComponent {
    fun inject(mainActivity: MainActivity)
}