package com.example.javaopenai.controller;

import java.io.IOException;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import com.example.javaopenai.network.ApiClient;
import com.example.javaopenai.network.ApiInterface;
import com.example.javaopenai.request.ChatRequest;
import com.example.javaopenai.response.ChatResponse;
import com.example.javaopenai.utils.AppConstants;

public class ApiController implements Callback<ChatResponse> {

    public void start(ChatRequest chatRequest) {
        String contentType = "application/json";
        String authorization = "Bearer " + AppConstants.OPENAI_API_KEY;

        ApiInterface api = ApiClient.getInstance();
        Call<ChatResponse> call = api.generateText(
            chatRequest, contentType, authorization);

        call.enqueue(this);
    }

    @Override
    public void onResponse(Call<ChatResponse> call, Response<ChatResponse> response) {
        if (response.isSuccessful()) {
            System.out.println("Success");
            ChatResponse chatResponse = response.body();
            System.out.println(chatResponse.choices.get(0).message.content);
        }
        else {
            System.out.println("Error");
            try {
                System.out.println(response.errorBody().string());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onFailure(Call<ChatResponse> call, Throwable t) {
        System.out.println("Failure.");
        t.printStackTrace();
    }    
}
