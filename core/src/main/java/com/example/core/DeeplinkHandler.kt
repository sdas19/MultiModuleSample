package com.example.core

import android.app.Activity
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class DeeplinkHandler : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_deeplink_handler)
        parseIntent()
    }

    // deeplink from emulator
    //adb shell am start -a android.intent.action.VIEW -d "https://www.example.com/demo?userid=100&client=android"

    private fun parseIntent() {
        val intent = intent
        val uri = intent.data
        if (uri != null) {
            if ("https" == uri.scheme && "www.example.com" == uri.host) {
                // Cool, we have a URI addressed to this activity!
                val userid = uri.getQueryParameter("userid")
                val client = uri.getQueryParameter("client")
                if(userid.equals("100",true)){
                    val intent = intentTo(this, Activities.RepoList)
                    startActivity(intent)
                }else{
                    val intent = intentTo(this, Activities.Profile)
                    startActivity(intent)
                }
            }
        }

    }
}
