package com.sergiocrespotoubes.splash

import app.cash.turbine.test
import com.sergiocrespotoubes.domain.model.AuthInfoModel
import com.sergiocrespotoubes.domain.usecase.user.GetAuthInfoUseCase
import com.sergiocrespotoubes.preferences.PreferencesManager
import com.sergiocrespotoubes.testing.MainCoroutineRule
import io.mockk.coEvery
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
    private val preferencesManager = mockk<PreferencesManager>()

    @Test
    fun `Given count down timer When is finished Then NavigateToArtistSearch`() =
        runTest {
            val authInfoModel = AuthInfoModel(accessToken = "123456")
            coEvery { getAuthInfoUseCase.execute() } returns Result.success(authInfoModel)

            val viewModel = SplashViewModel(getAuthInfoUseCase, preferencesManager)
            viewModel.event.test {
                advanceTimeBy(2000)
                assertTrue { awaitItem() is SplashViewModel.Event.NavigateToArtistSearch }
            }
        }

    @Test
    fun `Given count down timer When get auth error Then show error state`() =
        runTest {
            coEvery { getAuthInfoUseCase.execute() } returns Result.failure(Throwable())

            val viewModel = SplashViewModel(getAuthInfoUseCase, preferencesManager)
            viewModel.event.test {
                assertTrue { awaitItem() is SplashViewModel.Event.ShowError }
            }
            viewModel.state.test {
                assertTrue { awaitItem() is SplashViewModel.State.Error }
            }
        }
}
