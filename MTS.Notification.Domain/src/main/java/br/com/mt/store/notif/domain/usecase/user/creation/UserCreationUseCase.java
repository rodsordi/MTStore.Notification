package br.com.mt.store.notif.domain.usecase.user.creation;

import br.com.mt.store.notif.domain.Email;
import br.com.mt.store.notif.domain.User;
import br.com.mt.store.notif.domain.outputport.SendEmailOutputPort;
import br.com.mt.store.notif.domain.outputport.SaveEmailOutputPort;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class UserCreationUseCase {

    private final SendEmailOutputPort sendEmailOutputPort;

    private final SaveEmailOutputPort userCreationOutputPort;

    public Optional<Email> execute(User user) {
        var email = buildEmail(user);
        var emailSent = sendEmailOutputPort.execute(email);
        var savedEmail = userCreationOutputPort.execute(emailSent.get());
        return savedEmail;
    }

    private Email buildEmail(User user) {
        Email email = new Email();

        email.setFrom("sender@email.com");

        email.setTo(user.getEmail());
        email.setSubject("Subject xpto");
        email.setContent("Layout load");
        return email;
    }

}
