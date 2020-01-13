package com.example.modularizationsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.core.Activities
import com.example.core.intentTo

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun openRepoListActivity(view: View) {
        val intent = intentTo(this, Activities.RepoList)
        startActivity(intent)
    }

    fun openProfileActivity(view: View) {
        val intent = intentTo(this, Activities.Profile)
        startActivity(intent)
    }
}
