package br.com.mt.store.notif.app.controller;

import br.com.mt.commons.exception.RestException;
import br.com.mt.store.notif.app.dto.EmailDTO;
import br.com.mt.store.notif.app.dto.UserDTO;
import br.com.mt.store.notif.app.inputadapter.UserPasswordResetInputAdapter;
import br.com.mt.store.notif.app.inputadapter.UserCreationInputAdapter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Locale;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private ResourceBundleMessageSource source;

    @Autowired
    private UserCreationInputAdapter userCreationInputAdapter;

    @Autowired
    private UserPasswordResetInputAdapter userPasswordResetInputAdapter;

    @PostMapping(
            value = "/creation",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<EmailDTO.Response> creation(
            @RequestHeader(name = "Accept-Language", required = false) Locale locale,
            @Valid @RequestBody UserDTO.Request user) {
        var response = userCreationInputAdapter.execute(user);
        return response
                .map(res -> res.localize(source, locale))
                .map(res -> ResponseEntity.ok().body(res))
                .orElseThrow(() -> new RestException(HttpStatus.INTERNAL_SERVER_ERROR));
    }

    @PostMapping(
            value = "/password-reset",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<EmailDTO.Response> passwordReset(
            @RequestHeader(name = "Accept-Language", required = false) Locale locale,
            @Valid @RequestBody UserDTO.Request user) {
        var response = userPasswordResetInputAdapter.execute(user);
        return response
                .map(res -> res.localize(source, locale))
                .map(res -> ResponseEntity.ok().body(res))
                .orElseThrow(() -> new RestException(HttpStatus.INTERNAL_SERVER_ERROR));
    }

}