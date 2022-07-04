package br.com.mt.store.notif.domain.usecase.user.creation;

import br.com.mt.store.notif.domain.Email;
import br.com.mt.store.notif.domain.User;
import lombok.RequiredArgsConstructor;

import java.util.Locale;
import java.util.Optional;

@RequiredArgsConstructor
public abstract class UserCreationInputPort<INPUT, OUTPUT> {

    protected final UserCreationUseCase userCreationUseCase;

    public Optional<OUTPUT> execute(INPUT input) {
        return execute(input, null);
    }

    public Optional<OUTPUT> execute(INPUT input, Locale locale) {
        return userCreationUseCase.execute(convert(input))
                .map(email -> convert(email));
    }

    protected abstract User convert(INPUT dto);

    protected abstract OUTPUT convert(Email email);

}
