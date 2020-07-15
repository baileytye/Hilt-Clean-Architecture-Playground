package com.baileytye.domain.repository

import com.baileytye.dataresource.model.Result
import kotlinx.coroutines.flow.Flow

interface StringRepository {

    fun getString() : Flow<Result<String>>
}