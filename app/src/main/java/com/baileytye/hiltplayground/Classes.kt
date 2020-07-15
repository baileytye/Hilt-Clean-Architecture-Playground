package com.baileytye.hiltplayground

import dagger.hilt.android.scopes.ActivityRetainedScoped
import dagger.hilt.android.scopes.FragmentScoped
import javax.inject.Inject
import javax.inject.Singleton

//TODO: Step 6: Constructor injection
@ActivityRetainedScoped
class SomeClass @Inject constructor(private val someOtherClass: SomeOtherClass){

    fun doSomething() = "Something"
    fun doSomethingElse() = someOtherClass.doSomethingElse()
}


class SomeOtherClass @Inject constructor(){

    fun doSomethingElse () = "Something else"
}