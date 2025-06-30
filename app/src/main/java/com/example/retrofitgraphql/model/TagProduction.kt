package com.example.retrofitgraphql.model

// Request class
data class TagGraphQLRequest(
    val query: String
)

// Generic GraphQL response wrapper
data class TagGraphQLResponse<T>(
    val data: T?
)

// Response data class matching JSON "data" content
data class TagProductionResponse(
    val getProductTags: TagResultList
)

// Wrapper for the "results" list
data class TagResultList(
    val results: List<TagProduction>
)

// Each Tag item
data class TagProduction(
    val id: Int,
    val tagName: String
)
