package com.baileytye.domain.interaction

import com.baileytye.dataresource.model.Result
import kotlinx.coroutines.flow.Flow

interface GetStringUseCase {
    operator fun invoke() : Flow<Result<String>>
}