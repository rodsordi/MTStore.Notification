package br.com.mt.store.notif.infra.sender;

import br.com.mt.store.notif.domain.Email;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.Optional;

@Component
@Slf4j
public class EmailSender {

    public Optional<Email> execute(Email email) {
        log.info("Email sended.");
        email.setSentAt(Instant.now());
        return Optional.of(email);
    }

}
