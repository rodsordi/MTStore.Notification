package br.com.mt.store.notif.app.mapper;

import br.com.mt.store.notif.app.dto.EmailDTO;
import br.com.mt.store.notif.domain.Email;
import org.mapstruct.Mapper;

@Mapper
public interface EmailDTOMapper {

    EmailDTO.Response convert(Email email);

}
