package com.example.modularizationsample

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.core.Activities
import com.example.core.ApiClient
import com.example.core.coreComponent
import com.example.core.intentTo
import com.example.modularizationsample.di.DaggerMainActivityComponent
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var apiClient: ApiClient
    val TAG = MainActivity::class.java.simpleName

    @SuppressLint("CheckResult")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initDependencyInjection()
        apiClient.getData().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {result -> Log.i(TAG,result.toString())},
                {error -> Log.i(TAG,error.message)}
            )
    }

    private fun initDependencyInjection() {
        DaggerMainActivityComponent
            .builder()
            .coreComponent(coreComponent())
            .build()
            .inject(this)
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
