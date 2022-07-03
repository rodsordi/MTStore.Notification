package br.com.mt.store.notif.app.config;

import br.com.mt.store.notif.domain.outputport.SaveEmailOutputPort;
import br.com.mt.store.notif.domain.outputport.SendEmailOutputPort;
import br.com.mt.store.notif.domain.usecase.user.creation.UserCreationUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InjectionConfig {

    @Autowired
    @Bean
    public UserCreationUseCase userCreationUseCase(
            SendEmailOutputPort emailDispatchOutputPort,
            SaveEmailOutputPort emailSendOutputPort) {
        return new UserCreationUseCase(
                emailDispatchOutputPort,
                emailSendOutputPort);
    }

}
