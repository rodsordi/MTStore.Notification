package br.com.mt.store.notif.service.mapper;

import br.com.mt.store.notif.service.dto.UserDTO;
import br.com.mt.store.notif.domain.User;
import org.mapstruct.Mapper;

@Mapper
public interface UserDTOMapper {

    User convert(UserDTO.Request request);

}
