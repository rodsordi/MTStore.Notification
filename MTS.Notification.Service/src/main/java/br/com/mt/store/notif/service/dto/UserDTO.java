package br.com.mt.store.notif.service.dto;

import javax.validation.constraints.NotBlank;

public class UserDTO {
    public record Request(
            @NotBlank(message = "{valid.user.name.not_blank}")
            String name,
            @NotBlank(message = "{valid.user.username.not_blank}")
            String username,
            @NotBlank(message = "{valid.user.email.not_blank}")
            String email
    ) {}
}
