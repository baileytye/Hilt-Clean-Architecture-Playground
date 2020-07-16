package com.baileytye.hiltplayground.di

import com.baileytye.data.repository.StringRepositoryImpl
import com.baileytye.dataresource.model.Result
import com.baileytye.domain.interaction.GetStringUseCase
import com.baileytye.domain.repository.StringRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import kotlinx.coroutines.flow.flowOf
import org.mockito.Mockito
import org.mockito.Mockito.`when`

@Module
@InstallIn(ApplicationComponent::class)
object StringModuleTest {

    @Provides
    fun providesStringUseCase(stringRepository: StringRepository): GetStringUseCase =
        Mockito.mock(GetStringUseCase::class.java).apply {
            `when`(this.invoke()).thenReturn(flowOf(Result.Success("mocked")))
        }

    @Provides
    fun providesStringRepository(): StringRepository = StringRepositoryImpl()
}