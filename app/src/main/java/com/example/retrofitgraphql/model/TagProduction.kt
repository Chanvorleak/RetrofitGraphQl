package com.example.retrofitgraphql.model

data class TagGraphQLRequest(
    val query: String
)

data class TagGraphQLResponse<T>(
    val data: T?
)

data class TagProductionResponse(
    val getProductTags: TagResultList
)

data class TagResultList(
    val results: List<TagProduction>
)

data class TagProduction(
    val id: Int,
    val tagName: String
)
