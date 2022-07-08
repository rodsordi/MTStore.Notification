package br.com.mt.store.notif.service.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserResetPasswordDTO {
    private String id;
    private String name;
    private String username;
}

