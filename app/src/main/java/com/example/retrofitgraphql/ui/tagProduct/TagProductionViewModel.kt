package com.example.retrofitgraphql.ui.tagProduct

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.retrofitgraphql.api.RetrofitClient
import com.example.retrofitgraphql.model.*

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TagProductionViewModel : ViewModel() {

    private val _tagProduction = MutableLiveData<List<TagProduction>>()
    val tagProduction: LiveData<List<TagProduction>> = _tagProduction

    fun getProductionTag() {
        val strQuery = """
        query {
        getProductTags {
        results {
          id
          tagName
                 }
                     }
                }
        """.trimIndent()


        val request = TagGraphQLRequest(strQuery)

        RetrofitClient.api.fetchProductionTag(request)
            .enqueue(object : Callback<TagGraphQLResponse<TagProductionResponse>> {
                override fun onResponse(
                    call: Call<TagGraphQLResponse<TagProductionResponse>>,
                    response: Response<TagGraphQLResponse<TagProductionResponse>>
                ) {
                    if (response.isSuccessful) {
                        val tag = response.body()?.data?.getProductTags?.results
                        _tagProduction.postValue(tag)
                    } else {
                        Log.e("TagViewModel", "Response error: ${response.errorBody()?.string()}")
                    }
                }

                override fun onFailure(
                    call: Call<TagGraphQLResponse<TagProductionResponse>>,
                    t: Throwable
                ) {
                    Log.e("TagViewModel", "API failure: ${t.message}")
                }
            })
    }
}
