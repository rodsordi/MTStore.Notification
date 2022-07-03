package br.com.mt.store.notif.infra.repository;

import br.com.mt.store.notif.infra.entity.EmailEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailRepository extends CrudRepository<EmailEntity, Long> {

}
