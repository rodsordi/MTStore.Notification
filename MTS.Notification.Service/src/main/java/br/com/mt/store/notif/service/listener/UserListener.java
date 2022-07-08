package br.com.mt.store.notif.service.listener;

import br.com.mt.store.commons.infra.kafka.Topic;
import br.com.mt.store.notif.service.config.KafkaConsumerConfig;
import br.com.mt.store.notif.service.dto.UserCreationDTO;
import br.com.mt.store.notif.service.dto.UserResetPasswordDTO;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class UserListener {
    @KafkaListener(
            topics = Topic.MTS_USER_CREATION,
            groupId = KafkaConsumerConfig.MTS_NOTIFICATION)
    public void userCreation(ConsumerRecord<String, UserCreationDTO> payload) {
        log.info("UserCreationDTO: " + payload);
    }

    @KafkaListener(
            topics = Topic.MTS_USER_PASSWORD_RESET,
            groupId = KafkaConsumerConfig.MTS_NOTIFICATION)
    public void userResetPassword(ConsumerRecord<String, UserResetPasswordDTO> payload) {
        log.info("UserResetPasswordDTO: " + payload);
    }

}
