package com.bxz.eye.app

import android.app.Application
import coil3.ImageLoader
import coil3.SingletonImageLoader
import coil3.request.crossfade
import com.tencent.mmkv.MMKV

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        MMKV.initialize(this)
        SingletonImageLoader.setSafe { context ->
            ImageLoader.Builder(context)
                .crossfade(true)
                .build()
        }
    }

}