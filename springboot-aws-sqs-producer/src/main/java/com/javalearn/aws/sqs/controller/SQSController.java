package com.javalearn.aws.sqs.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.javalearn.aws.sqs.dto.MessageDto;
import com.javalearn.aws.sqs.service.MessageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Log4j2
public class SQSController {

    private final MessageService messageService;


    @PostMapping("/send")
    public MessageDto sendMessageToQueue(@RequestBody MessageDto messageDto) throws JsonProcessingException {
        log.info("message sent: {}", messageDto);
        return messageService.sentMessage(messageDto);
    }


}
