package br.com.mt.store.notif.service.config;

import br.com.mt.store.notif.domain.outputport.SaveEmailOutputPort;
import br.com.mt.store.notif.domain.outputport.SendEmailOutputPort;
import br.com.mt.store.notif.domain.usecase.user.creation.UserCreationUseCase;
import br.com.mt.store.notif.domain.usecase.user.passwordreset.UserPasswordResetUseCase;
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

    @Autowired
    @Bean
    public UserPasswordResetUseCase userPasswordResetUseCase(
            SendEmailOutputPort emailDispatchOutputPort,
            SaveEmailOutputPort emailSendOutputPort) {
        return new UserPasswordResetUseCase(
                emailDispatchOutputPort,
                emailSendOutputPort);
    }

}
