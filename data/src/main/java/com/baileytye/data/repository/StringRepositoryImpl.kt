package com.baileytye.data.repository

import com.baileytye.dataresource.model.Result
import com.baileytye.dataresource.networkBoundResource.Mapper
import com.baileytye.dataresource.networkBoundResource.NetworkBoundResource
import com.baileytye.domain.repository.StringRepository
import kotlinx.coroutines.flow.Flow

class StringRepositoryImpl : StringRepository {

    init {
        println("StringRepo Initialized")
    }

    private val dataResourceOptions = NetworkBoundResource.Options()
    private val mapper = object : Mapper<String, String> {
        override fun localToNetwork(local: String) = local
        override fun networkToLocal(network: String) = network
    }

    private fun createGetStringResource() = NetworkBoundResource.Builder(mapper)
        .options(dataResourceOptions)
        .networkFetchBlock {"A string from repo" }
        .build()

    val result = createGetStringResource().getFlowResult()

    override fun getString(): Flow<Result<String>> {
        return createGetStringResource().getFlowResult()
    }
}