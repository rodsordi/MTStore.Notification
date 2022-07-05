package br.com.mt.store.notif.service.inputadapter;

import br.com.mt.store.notif.service.dto.EmailDTO;
import br.com.mt.store.notif.service.dto.UserDTO;
import br.com.mt.store.notif.service.mapper.EmailDTOMapper;
import br.com.mt.store.notif.service.mapper.UserDTOMapper;
import br.com.mt.store.notif.domain.Email;
import br.com.mt.store.notif.domain.User;
import br.com.mt.store.notif.domain.usecase.user.creation.UserCreationInputPort;
import br.com.mt.store.notif.domain.usecase.user.creation.UserCreationUseCase;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Component
public class UserCreationInputAdapter extends UserCreationInputPort<UserDTO.Request, EmailDTO.Response> {
    private final UserDTOMapper userDTOMapper = Mappers.getMapper(UserDTOMapper.class);
    private final EmailDTOMapper emailDTOMapper = Mappers.getMapper(EmailDTOMapper.class);

    public UserCreationInputAdapter(UserCreationUseCase userCreationUseCase) {
        super(userCreationUseCase);
    }

    @Override
    protected User convert(UserDTO.Request dto) {
        return userDTOMapper.convert(dto);
    }

    @Override
    protected EmailDTO.Response convert(Email email) {
        return emailDTOMapper.convert(email);
    }

}
