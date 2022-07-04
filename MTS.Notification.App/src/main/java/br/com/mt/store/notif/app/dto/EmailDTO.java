package br.com.mt.store.notif.app.dto;

import br.com.mt.store.commons.app.dto.Localizable;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.support.ResourceBundleMessageSource;

import java.time.Instant;
import java.util.Locale;

public class EmailDTO {

    @Getter
    @Setter
    public static class Response implements Localizable<Response> {
        private String to;
        private String subject;
        private Instant sentAt;

        public Response localize(ResourceBundleMessageSource source, Locale locale) {
            subject = source.getMessage(subject, null, locale);
            return this;
        }
    }

}
