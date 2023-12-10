package com.example.javaopenai;

import java.util.LinkedList;
import java.util.List;

import com.example.javaopenai.utils.AppConstants;
import com.example.javaopenai.controller.ApiController;
import com.example.javaopenai.request.ChatRequest;
import com.example.javaopenai.request.Message;

public class App 
{
    public static void main( String[] args )
    {
        Message systemMessage = 
            new Message("system", "You are a helpful assistant");

        Message userMessage = new Message("user", 
            "What is Java?");

        List<Message> messageList = new LinkedList<Message>();
        messageList.add(systemMessage);
        messageList.add(userMessage);

        ChatRequest chatRequest = 
            new ChatRequest(messageList, 
                AppConstants.CHAT_GPT_MODEL);

        ApiController controller = new ApiController();
        controller.start(chatRequest);
    }
}
