package br.com.mt.store.notif.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.Instant;

@Getter
@Setter
@ToString
public class Email {

    private String from;
    private String to;
    private String cc;
    private String bcc;
    private String subject;
    private String content;
    private Instant createdAt;
    private Instant sentAt;

}
