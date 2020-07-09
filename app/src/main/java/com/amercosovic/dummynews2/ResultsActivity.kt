package com.amercosovic.dummynews2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_results.*
import kotlinx.android.synthetic.main.activity_results.view.*

class ResultsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_results)

        val bundle: Bundle? = intent.extras
        val apiResult = bundle!!.getString("myResult")


        textView.text = apiResult.toString()

    }
}
