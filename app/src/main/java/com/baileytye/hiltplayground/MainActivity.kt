package com.baileytye.hiltplayground

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

//TODO: Step 4: add entry point, similar to inject method in app component for dagger
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    //TODO: Step 5: Field injection
    @Inject
    lateinit var someClass: SomeClass

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        println(someClass.doSomething())
        println(someClass.doSomethingElse())
    }
}


