package com.sergiocrespotoubes.splash

import app.cash.turbine.test
import com.sergiocrespotoubes.domain.usecase.user.GetAuthInfoUseCase
import com.sergiocrespotoubes.testing.MainCoroutineRule
import io.mockk.mockk
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

    private val getAuthInfoUseCase = mockk<GetAuthInfoUseCase>()

    @Test
    fun `Given count down timer When is finished Then NavigateToArtistSearch`() = runTest {
        val viewModel = SplashViewModel(getAuthInfoUseCase)
        viewModel.event.test {
            advanceTimeBy(2000)
            assertTrue { awaitItem() is SplashViewModel.Event.NavigateToArtistSearch }
        }
    }
}