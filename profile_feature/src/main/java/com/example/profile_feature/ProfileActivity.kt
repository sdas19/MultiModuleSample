package com.example.profile_feature

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.core.Activities
import com.example.core.ApiClient
import com.example.core.coreComponent
import com.example.core.intentTo
import com.example.profile_feature.di.DaggerProfileComponent
import javax.inject.Inject

class ProfileActivity : AppCompatActivity() {

    @Inject
    lateinit var apiClient: ApiClient
    @Inject
    lateinit var profileString: String
    val TAG = ProfileActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        injectDependency()
        Log.i(TAG,profileString)
        Log.i(TAG,apiClient.toString())
    }

    private fun injectDependency() {
        DaggerProfileComponent
            .builder()
            .coreComponent(coreComponent())
            .build()
            .inject(this)
    }

    fun openRepoActivity(view: View) {
        val intent = intentTo(this, Activities.RepoList)
        startActivity(intent)
    }
}
