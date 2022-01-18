package com.ssafy.near.src

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.ssafy.near.R
import com.ssafy.near.config.BaseActivity
import com.ssafy.near.databinding.ActivityMainBinding
import com.ssafy.near.repository.SampleRepository

class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {
    lateinit var sampleViewModel: SampleViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val sampleRepository = SampleRepository()
        sampleViewModel = ViewModelProvider(this, SampleViewModelFactory(sampleRepository)).get(SampleViewModel::class.java)

        initEvent()
    }

    private fun initEvent() {

        // 버튼 클릭시 HTTP 요청하는 샘플
//        binding.XXX.setOnClickListener {
//            sampleViewModel.selectselectSamples(1)
//        }

        // 응답받은 데이터를 LiveData가 Observe 한다.
        // it에 데이터가 저장된다. 원하는 뷰에 뿌려주면 끝
//        sampleViewModel.getSampleResponse().observe(this, {
//            it.items
//        })
    }
}