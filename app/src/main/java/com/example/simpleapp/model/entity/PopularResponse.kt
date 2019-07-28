package com.example.simpleapp.model.entity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



data class  PopularResponse<T>(val page:Int,
                               val total_results: Int,
                               val total_pages: Int,
                               val results: T)
/**
class PopularResponse<T> {
    @SerializedName("page")
    @Expose
    private var page: Int = 0
    @SerializedName("total_results")
    @Expose
    private var totalResults: Int = 0
    @SerializedName("total_pages")
    @Expose
    private var totalPages: Int = 0
    @SerializedName("results")
    @Expose
    private var results: T? = null
    fun getPage():Int {
        return page
    }

    fun setPage(page: Int) {
        this.page = page
    }

    fun getTotalResults(): Int {
        return totalResults
    }

    fun setTotalResults(totalResults: Int) {
        this.totalResults = totalResults
    }

    fun getTotalPages(): Int {
        return totalPages
    }

    fun setTotalPages(totalPages: Int) {
        this.totalPages = totalPages
    }

    fun getResults(): T? {
        return results
    }

    fun setResults(results: T) {
        this.results = results
    }

}

        **/