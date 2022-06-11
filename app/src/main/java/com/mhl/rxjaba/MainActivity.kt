package com.mhl.rxjaba

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.mhl.rxjaba.model.ImdbRepository
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var repository: ImdbRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val dataObs = repository.getTopData()
        val data = dataObs.map{
            "data = $it"
        }.subscribe{
            Log.d("TAG", it)
        }


    }
}