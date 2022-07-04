package br.com.mt.store.notif.infra.mapper;

import br.com.mt.store.notif.domain.Email;
import br.com.mt.store.notif.infra.entity.EmailEntity;
import org.mapstruct.Mapper;

@Mapper
public interface EmailEntityMapper {

    EmailEntity convert(Email email);

    Email convert(EmailEntity emailEntity);

}
