package com.playground.academy.britt.networkingdemo.network;

import com.playground.academy.britt.networkingdemo.StaticParams;
import com.playground.academy.britt.networkingdemo.network.utils.EnvelopingConverter;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by britt on 11/22/17.
 */

public class ServiceGenerator {

    private static HttpLoggingInterceptor logging =
            new HttpLoggingInterceptor()
                    .setLevel(HttpLoggingInterceptor.Level.BODY);

    static String API_BASE_URL = "https://api.foursquare.com/v2/";

    static OkHttpClient.Builder httpClient =
            new OkHttpClient.Builder();

    static Retrofit.Builder builder =
            new Retrofit.Builder()
                    .baseUrl(API_BASE_URL)
                    .addConverterFactory(new EnvelopingConverter())
                    .addConverterFactory(GsonConverterFactory.create());

    private static Interceptor apiKeyInterceptor = new Interceptor() {
        @Override
        public Response intercept(Chain chain) throws IOException {
            Request original = chain.request();
            HttpUrl originalHttpUrl = original.url();

            HttpUrl url = originalHttpUrl.newBuilder()
                    .addQueryParameter("client_id", StaticParams.CLIENT_ID)
                    .addQueryParameter("client_secret", StaticParams.CLIENT_SECRET)
                    .addQueryParameter("v", "20171122")
                    .addQueryParameter("ll", "32.070080,34.794145")
                    .build();

            Request.Builder requestBuilder = original.newBuilder()
                    .url(url);

            Request request = requestBuilder.build();
            return chain.proceed(request);
        }
    };
    static Retrofit retrofit =
            builder
                    .client(
                            httpClient.addInterceptor(logging)
                                    .addInterceptor(apiKeyInterceptor)
                                    .build()

                    )
                    .build();

    static FoursquareService foursquareService = retrofit.create(FoursquareService.class);

    public static FoursquareService getFoursquareService() {
        return foursquareService;
    }
}
