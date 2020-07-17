package com.baileytye.dataandroid.di

import com.baileytye.data.repository.StringRepositoryImpl
import com.baileytye.domain.repository.StringRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

@Module
@InstallIn(ApplicationComponent::class)
object StringModule {

    @Provides
    fun providesStringRepository(): StringRepository =
        StringRepositoryImpl()
}