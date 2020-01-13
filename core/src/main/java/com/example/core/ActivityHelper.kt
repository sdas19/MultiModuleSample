@file:JvmName("ActivityHelper")

package com.example.core

import android.content.Context
import android.content.Intent

private const val PACKAGE_NAME = "com.example"

fun intentTo(context: Context,addressableActivity: AddressableActivity): Intent {
    return Intent().setClassName(
        context,
        addressableActivity.className)
}

/**
 * An [android.app.Activity] that can be addressed by an intent.
 */
interface AddressableActivity {
    /**
     * The activity class name.
     */
    val className: String
}

object Activities {

    object Profile : AddressableActivity {
        override val className = "$PACKAGE_NAME.profile_feature.ProfileActivity"
    }

    object RepoList : AddressableActivity {
        override val className = "$PACKAGE_NAME.repo_feature.RepoListActivity"
    }

}
