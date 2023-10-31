package com.ms.user.producer;

import com.ms.user.dtos.EmailRecordDTO;
import com.ms.user.models.UserModel;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserProducer {

    final RabbitTemplate rabbitTemplate;

    @Value(value = "${broker.queue.email.name}")
    private String routingKey;

    public void publishMessageEmail(UserModel userModel){
        var emailDto = new EmailRecordDTO(
                userModel.getUserId(),
                userModel.getEmail(),
                "Castro realizado com sucesso!",
                userModel.getName() + ", seja bem vindo(a)!");
        rabbitTemplate.convertAndSend("", routingKey, emailDto);
    }
}
