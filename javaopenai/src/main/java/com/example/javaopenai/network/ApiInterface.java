package com.example.javaopenai.network;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;

import com.example.javaopenai.request.ChatRequest;
import com.example.javaopenai.response.ChatResponse;


public interface ApiInterface {
    @POST("chat/completions")
    public Call<ChatResponse> generateText(
        @Body ChatRequest request,
        @Header("Content-Type") String contentType,
        @Header("Authorization") String authorization
    );

    // add method for image generation




}
