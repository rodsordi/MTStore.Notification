package br.com.mt.store.notif.infra.outputadapter;

import br.com.mt.store.notif.domain.Email;
import br.com.mt.store.notif.domain.outputport.SendEmailOutputPort;
import br.com.mt.store.notif.infra.repository.EmailSender;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class SendEmailOutputAdapter implements SendEmailOutputPort {

    //private final EmailSender emailSender;

    @Override
    public Optional<Email> execute(Email email) {
        return Optional.of(email);//emailSender.execute(email);
    }

}
