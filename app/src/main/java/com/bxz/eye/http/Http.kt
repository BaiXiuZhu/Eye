package com.bxz.eye.http

import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.converter.kotlinx.serialization.asConverterFactory

object Http {

    private const val BASEURL = "https://baobab.kaiyanapp.com/api"
    private val mediaType = "application/json".toMediaType()
    private val json = Json {
        ignoreUnknownKeys = true
    }

    // 初始化 OkHttpClient 并添加拦截器
    private fun okHttpClient(): OkHttpClient {
        val loggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY // 可以根据需要调整日志级别
        }

        return OkHttpClient.Builder()
            .connectTimeout(3, TimeUnit.SECONDS) // 连接超时
            .readTimeout(3, TimeUnit.SECONDS) // 读取超时
            .writeTimeout(3, TimeUnit.SECONDS) // 写入超时
            .addInterceptor(loggingInterceptor) // 添加日志拦截器
            .build()
    }

    private val instance: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASEURL)
            .client(okHttpClient())
            .addConverterFactory(json.asConverterFactory(mediaType))
            .build()
    }

    fun api(): Api {
        return instance.create(Api::class.java)
    }

}