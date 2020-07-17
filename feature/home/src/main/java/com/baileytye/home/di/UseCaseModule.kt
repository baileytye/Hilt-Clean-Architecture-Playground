package com.baileytye.home.di

import com.baileytye.domain.interaction.GetStringUseCase
import com.baileytye.domain.interaction.GetStringUseCaseImpl
import com.baileytye.domain.repository.StringRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

@Module
@InstallIn(ApplicationComponent::class)
object UseCaseModule {
    @Provides
    fun providesStringUseCase(stringRepository: StringRepository): GetStringUseCase =
        GetStringUseCaseImpl(stringRepository)
}