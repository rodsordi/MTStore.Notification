package br.com.mt.store.notif.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class User {

    private String username;
    private String password;
    private String name;
    private String email;

}
