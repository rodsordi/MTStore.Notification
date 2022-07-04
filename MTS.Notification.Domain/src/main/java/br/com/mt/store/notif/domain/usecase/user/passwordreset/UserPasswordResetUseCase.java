package br.com.mt.store.notif.domain.usecase.user.passwordreset;

import br.com.mt.store.commons.domain.BusinessException;
import br.com.mt.store.notif.domain.Email;
import br.com.mt.store.notif.domain.User;
import br.com.mt.store.notif.domain.outputport.SaveEmailOutputPort;
import br.com.mt.store.notif.domain.outputport.SendEmailOutputPort;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class UserPasswordResetUseCase {

    private final SendEmailOutputPort sendEmailOutputPort;

    private final SaveEmailOutputPort saveEmailOutputPort;

    public Optional<Email> execute(User user) {
        var emailSent = sendEmailOutputPort.execute(buildEmail(user));
        var savedEmail = emailSent
                .map(email -> saveEmailOutputPort.execute(email))
                .orElseThrow(() -> new BusinessException("email.internal_error"));
        return savedEmail;
    }

    private Email buildEmail(User user) {
        Email email = new Email();

        email.setFrom("sender@email.com");

        email.setTo(user.getEmail());
        email.setSubject("notif.user.password_reset.subject");
        email.setContent("Layout load");
        return email;
    }

}
