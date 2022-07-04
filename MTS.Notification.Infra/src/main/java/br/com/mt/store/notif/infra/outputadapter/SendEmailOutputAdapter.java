package br.com.mt.store.notif.infra.outputadapter;

import br.com.mt.store.notif.domain.Email;
import br.com.mt.store.notif.domain.outputport.SendEmailOutputPort;
import br.com.mt.store.notif.infra.sender.EmailSender;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Slf4j
@Component
@RequiredArgsConstructor
public class SendEmailOutputAdapter implements SendEmailOutputPort {

    private final EmailSender emailSender;

    @Override
    public Optional<Email> execute(Email email) {
        return emailSender.execute(email);
    }

}
