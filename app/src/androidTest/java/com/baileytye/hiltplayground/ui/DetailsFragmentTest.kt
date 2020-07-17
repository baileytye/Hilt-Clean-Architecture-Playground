package com.baileytye.hiltplayground.ui

import android.os.Bundle
import androidx.navigation.Navigation
import androidx.navigation.testing.TestNavHostController
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.baileytye.hiltplayground.R
import com.baileytye.hiltplayground.launchFragmentInHiltContainer
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.UninstallModules
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@HiltAndroidTest
@UninstallModules(com.baileytye.dataandroid.di.StringModule::class)
class DetailsFragmentTest {

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    private lateinit var navController: TestNavHostController

    @Before
    fun setup() {
        navController = TestNavHostController(
            ApplicationProvider.getApplicationContext()
        )
        navController.setGraph(R.navigation.nav_graph)

        launchFragmentInHiltContainer<com.baileytye.home.DetailsFragment>(
            fragmentArgs = Bundle().apply {
                putString("string", "value")
            },
            themeResId = R.style.AppTheme
        ) {
            Navigation.setViewNavController(requireView(), navController)
        }
    }

    @Test
    fun testFragmentVisible() {
        onView(withId(R.id.fragmentDetailsContainer)).check(matches(isDisplayed()))

    }
}