package com.javalearn.aws.sqs.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.javalearn.aws.sqs.dto.MessageDto;

public interface MessageService {
    MessageDto sentMessage(MessageDto messageDto) throws JsonProcessingException;
}
