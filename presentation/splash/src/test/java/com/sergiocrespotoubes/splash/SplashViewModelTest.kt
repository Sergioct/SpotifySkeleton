package com.sergiocrespotoubes.splash

import app.cash.turbine.test
import com.sergiocrespotoubes.testing.MainCoroutineRule
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.advanceTimeBy
import kotlinx.coroutines.test.runTest
import org.junit.Rule
import org.junit.Test
import kotlin.test.assertTrue

@ExperimentalCoroutinesApi
class SplashViewModelTest {

    @get:Rule
    val mainCoroutineRule = MainCoroutineRule()

    @Test
    fun `Given count down timer When is finished Then NavigateToArtistSearch`() = runTest {
        val viewModel = SplashViewModel()
        viewModel.event.test {
            advanceTimeBy(2000)
            assertTrue { awaitItem() is SplashViewModel.Event.NavigateToArtistSearch }
        }
    }
}