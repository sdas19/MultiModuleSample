package com.example.repo_feature

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.core.Activities
import com.example.core.intentTo

class RepoListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_repo_list)
    }

    fun openProfileActivity(view: View) {
        val intent = intentTo(this, Activities.Profile)
        startActivity(intent)
    }
}
