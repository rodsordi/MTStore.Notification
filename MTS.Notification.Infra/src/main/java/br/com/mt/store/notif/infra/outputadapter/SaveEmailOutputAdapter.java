package br.com.mt.store.notif.infra.outputadapter;

import br.com.mt.store.notif.domain.Email;
import br.com.mt.store.notif.domain.outputport.SaveEmailOutputPort;
import br.com.mt.store.notif.infra.mapper.EmailEntityMapper;
import br.com.mt.store.notif.infra.repository.EmailRepository;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class SaveEmailOutputAdapter implements SaveEmailOutputPort {
    private final EmailEntityMapper mapper = Mappers.getMapper(EmailEntityMapper.class);

    private final EmailRepository emailRepository;

    @Override
    public Optional<Email> execute(Email email) {
        var savedEmail = emailRepository.save(mapper.convert(email));
        return Optional.of(mapper.convert(savedEmail));
    }

}
