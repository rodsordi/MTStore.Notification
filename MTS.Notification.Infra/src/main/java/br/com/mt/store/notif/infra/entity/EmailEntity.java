package br.com.mt.store.notif.infra.entity;

import br.com.mt.store.commons.infra.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.Instant;

@Getter
@Setter
@Entity(name = "EMAIL")
public class EmailEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name = "SENDER", nullable = false)
    private String from;

    @Column(nullable = false)
    private String to;

    @Column
    private String cc;

    @Column
    private String bcc;

    @Column(nullable = false)
    private String subject;

    @Column(nullable = false)
    private String content;

    @LastModifiedDate
    @Column
    protected Instant sentAt;

}
