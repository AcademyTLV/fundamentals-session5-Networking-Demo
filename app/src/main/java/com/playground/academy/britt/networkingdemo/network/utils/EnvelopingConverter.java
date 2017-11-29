package com.playground.academy.britt.networkingdemo.network.utils;

import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;

/**
 * Created by britt on 11/22/17.
 */

public class EnvelopingConverter extends Converter.Factory {

    @Override
    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations, Retrofit retrofit) {

        Type envelopedType = TypeToken.getParameterized(Envelope.class, type).getType();
        final Converter<ResponseBody, Envelope<?>> delegate = retrofit.nextResponseBodyConverter(this, envelopedType, annotations);
        return new Converter<ResponseBody, Object>() {
            @Override
            public Object convert(ResponseBody body) throws IOException {
                Envelope<?> envelope = delegate.convert(body);
                return envelope.response;
            }
        };
    }
}
