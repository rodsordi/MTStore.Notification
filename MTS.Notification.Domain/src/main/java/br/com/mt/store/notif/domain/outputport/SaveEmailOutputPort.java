package br.com.mt.store.notif.domain.outputport;

import br.com.mt.store.notif.domain.Email;

import java.util.Optional;

public interface SaveEmailOutputPort {

    Optional<Email> execute(Email email);

}
