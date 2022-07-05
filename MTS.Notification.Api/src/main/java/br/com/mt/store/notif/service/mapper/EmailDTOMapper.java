package br.com.mt.store.notif.service.mapper;

import br.com.mt.store.notif.service.dto.EmailDTO;
import br.com.mt.store.notif.domain.Email;
import org.mapstruct.Mapper;

@Mapper
public interface EmailDTOMapper {

    EmailDTO.Response convert(Email email);

}

