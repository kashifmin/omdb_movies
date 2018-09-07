package me.kashifminhaj.omdbmovies

import io.reactivex.Observable
import me.kashifminhaj.omdbmovies.models.Response
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query


interface RestService {
    @GET("/")
    fun getMovies(@Query("s") queryText: String) : Observable<Response>
}

fun createRetrofitInstance() = Retrofit.Builder()
        .baseUrl("http://www.omdbapi.com")
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .client(buildClient())
        .build()

fun createRestService() : RestService {
    val retrofit = createRetrofitInstance()
    return retrofit.create(RestService::class.java)
}

fun buildClient(): OkHttpClient {
    val httpClient = OkHttpClient().newBuilder()
    val interceptor = Interceptor { chain ->
        val original = chain?.request()
        val originalUrl = original?.url()
        val url = originalUrl?.newBuilder()?.addQueryParameter("apikey", "9cfa95f8")?.build()
        val newReq = original?.newBuilder()?.url(url)?.build()
        chain.proceed(newReq)

    }
    httpClient.addInterceptor(interceptor)
    return httpClient.build()
}