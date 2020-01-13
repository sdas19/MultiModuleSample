package com.example.profile_feature

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.core.Activities
import com.example.core.intentTo

class ProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
    }

    fun openRepoActivity(view: View) {
        val intent = intentTo(this, Activities.RepoList)
        startActivity(intent)
    }
}
