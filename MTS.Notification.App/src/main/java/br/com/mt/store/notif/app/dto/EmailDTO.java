package br.com.mt.store.notif.app.dto;

import java.time.Instant;

public class EmailDTO {

    public record Response (
            String to,
            String subject,
            Instant sentAt
    ) {}

}
