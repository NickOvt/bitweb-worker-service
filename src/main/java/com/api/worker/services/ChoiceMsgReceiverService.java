package com.api.worker.services;

import com.api.worker.dao.ChoiceDao;
import com.api.worker.models.Choice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.annotation.RabbitListenerConfigurer;
import org.springframework.amqp.rabbit.listener.RabbitListenerEndpointRegistrar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;


@Service
public class ChoiceMsgReceiverService implements RabbitListenerConfigurer {

    private final ChoiceDao choiceDao;

    @Autowired
    public ChoiceMsgReceiverService(ChoiceDao choiceDao) {
        this.choiceDao = choiceDao;
    }

    private static final Logger logger = LoggerFactory.getLogger(ChoiceMsgReceiverService.class);

    @Override
    public void configureRabbitListeners(RabbitListenerEndpointRegistrar rabbitListenerEndpointRegistrar) {
    }

    @RabbitListener(queues = "${spring.rabbitmq.queue}")
    public void receivedMessage(Choice choice) {
        Instant instant = Instant.now();
        long timeStampMillis = instant.toEpochMilli();
        logger.info("Choice details received is.. " + "> " + choice.getChoice() +  " < - timestamp: " + timeStampMillis);
        choiceDao.insertChoice(choice);
    }
}
