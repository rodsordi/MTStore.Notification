package br.com.mt.store.notif.app.inputadapter;

import br.com.mt.store.notif.app.dto.EmailDTO;
import br.com.mt.store.notif.app.dto.UserDTO;
import br.com.mt.store.notif.app.mapper.EmailDTOMapper;
import br.com.mt.store.notif.app.mapper.UserDTOMapper;
import br.com.mt.store.notif.domain.Email;
import br.com.mt.store.notif.domain.User;
import br.com.mt.store.notif.domain.usecase.user.passwordreset.UserPasswordResetInputPort;
import br.com.mt.store.notif.domain.usecase.user.passwordreset.UserPasswordResetUseCase;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Component
public class UserPasswordResetInputAdapter extends UserPasswordResetInputPort<UserDTO.Request, EmailDTO.Response> {

    private final UserDTOMapper userDTOMapper = Mappers.getMapper(UserDTOMapper.class);
    private final EmailDTOMapper emailDTOMapper = Mappers.getMapper(EmailDTOMapper.class);

    public UserPasswordResetInputAdapter(UserPasswordResetUseCase passwordResetUseCase) {
        super(passwordResetUseCase);
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
