package com.mhl.rxjaba.model

import com.mhl.rxjaba.model.imdb.RatingImdb
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class ImdbRepository @Inject constructor(private val service: MainService,private val apiKey : String) {
    fun getTopData() : Observable<RatingImdb>{
        return service.getMovies(apiKey)
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
    }
}