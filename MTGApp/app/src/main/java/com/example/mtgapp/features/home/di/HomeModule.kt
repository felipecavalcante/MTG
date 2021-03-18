package com.example.mtgapp.features.home.di

import com.example.mtgapp.base.application.Constants.BASE_URL
import com.example.mtgapp.features.home.data.repository.MagicQueryCardsRepository
import com.example.mtgapp.features.home.data.service.MagicQueryService
import com.example.mtgapp.features.home.presentation.MainActivityViewModel
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import java.util.concurrent.TimeUnit

val homeModule = module {

    single { provideRetrofit() }
    factory { provideForecastApi(retrofit = get()) }
    single<MagicQueryCardsRepository> { MagicQueryCardsRepository.Impl(service = get()) }
    viewModel { MainActivityViewModel(repository = get()) }
}


fun provideRetrofit(): Retrofit {
    return Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create())
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .client(createHttpClient())
        .build()
}

fun createHttpClient(): OkHttpClient {
    val client = OkHttpClient.Builder()
    client.readTimeout(5 * 60, TimeUnit.SECONDS)
    return client.addInterceptor {
        val original = it.request()
        val requestBuilder = original.newBuilder()
        requestBuilder.header("Content-Type", "application/json")
        val request = requestBuilder.method(original.method, original.body).build()
        return@addInterceptor it.proceed(request)
    }.build()
}

fun provideForecastApi(retrofit: Retrofit): MagicQueryService = retrofit.create()



