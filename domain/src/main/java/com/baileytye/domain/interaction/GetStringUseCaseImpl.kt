package com.baileytye.domain.interaction

import com.baileytye.dataresource.model.Result
import com.baileytye.domain.repository.StringRepository
import kotlinx.coroutines.flow.Flow

class GetStringUseCaseImpl(private val stringRepository: StringRepository) : GetStringUseCase {
    override fun invoke(): Flow<Result<String>> {
        return stringRepository.getString()
    }
}