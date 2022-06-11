package com.mhl.rxjaba.model

import com.mhl.rxjaba.model.imdb.RatingImdb
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET
import retrofit2.http.Path

interface MainService {
    @GET("Top250Movies/{apiKey}")
    fun getMovies(@Path("apiKey") key : String) : Observable<RatingImdb>
}