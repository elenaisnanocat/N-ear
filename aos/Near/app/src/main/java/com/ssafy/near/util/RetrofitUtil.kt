package com.ssafy.near.util

import com.ssafy.near.api.SampleApi
import com.ssafy.near.config.ApplicationClass

class RetrofitUtil {
    companion object {
        val sampleService = ApplicationClass.retrofit.create(SampleApi::class.java) // TODO 샘플보고 필요한 service 작성할 것
    }
}