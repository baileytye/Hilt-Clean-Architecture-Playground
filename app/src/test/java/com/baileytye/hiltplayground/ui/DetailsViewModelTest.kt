package com.baileytye.hiltplayground.ui

import androidx.lifecycle.SavedStateHandle
import com.baileytye.dataresource.model.Result
import com.baileytye.domain.interaction.GetStringUseCase
import com.google.common.truth.Truth.assertThat
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.flow.flowOf
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal class DetailsViewModelTest {

    private val useCase = mockk<GetStringUseCase>()
    private lateinit var detailsViewModel: DetailsViewModel

    @BeforeAll
    internal fun setUp() {
        every { useCase() } returns (flowOf(Result.Success("use case")))
        detailsViewModel = DetailsViewModel(SavedStateHandle(mapOf("string" to "test")), useCase)
    }

    @Test
    internal fun `check saved state is received`() {
        assertThat(detailsViewModel.text.value).isEqualTo("test")
    }
}