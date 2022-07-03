package br.com.mt.store.notif.app.dto;

import javax.validation.constraints.NotBlank;

public class UserDTO {
    public record Request(
            @NotBlank(message = "{user.name}")
            String name,
            @NotBlank(message = "Username must be filled!")
            String username,
            @NotBlank(message = "Email must be filled!")
            String email
    ) {}
}
