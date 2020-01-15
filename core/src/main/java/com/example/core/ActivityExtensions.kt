package com.example.core

import android.app.Activity
import com.example.core.di.CoreComponentProvider

fun Activity.coreComponent() =
    (applicationContext as? CoreComponentProvider)?.provideCoreComponent()
        ?: throw IllegalStateException("CoreComponentProvider not implemented: $applicationContext")

