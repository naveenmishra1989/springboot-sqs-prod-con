package com.javalearn.aws.sqs.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.javalearn.aws.sqs.dto.MessageDto;
import com.javalearn.aws.sqs.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MessageServiceImpl implements MessageService {

    private final QueueMessagingTemplate queueMessagingTemplate;

    @Value("${cloud.aws.end-point.uri}")
    private String endpoint;

    @Override
    public MessageDto sentMessage(MessageDto messageDto) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        String asString = objectMapper.writeValueAsString(messageDto);
        queueMessagingTemplate.send(endpoint, MessageBuilder.withPayload(asString).build());
        return messageDto;
    }
}
