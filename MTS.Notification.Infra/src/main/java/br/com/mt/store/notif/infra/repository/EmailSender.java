package br.com.mt.store.notif.infra.repository;

import br.com.mt.store.notif.domain.Email;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Slf4j
public class EmailSender {

    public Optional<Email> execute(Email email) {
        log.info("Email sended.");
        return Optional.of(email);
    }

}
