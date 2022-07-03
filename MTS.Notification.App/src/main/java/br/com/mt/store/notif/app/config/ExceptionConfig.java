package br.com.mt.store.notif.app.config;

import br.com.mt.commons.exception.RestException;
import br.com.mt.store.notif.app.dto.ResponseErrorDTO;
import br.com.mt.store.notif.app.exception.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Slf4j
//@ControllerAdvice
public class ExceptionConfig extends ResponseEntityExceptionHandler {

    private static final String ERRO_INTERNO = "Erro interno";

    @ExceptionHandler(RestException.class)
    public ResponseEntity restException(RestException e, WebRequest request){
        log.warn(e.getMessage());
        var builder = new ResponseErrorDTO.Builder()
                .addErro(e.getMessage());
        return new ResponseEntity(builder.build(), e.getHttpStatus());
    }

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity businessException(BusinessException e, WebRequest request){
        log.warn(e.getMessage());
        var builder = new ResponseErrorDTO.Builder();
        e.getMensagensDeErro()
                .forEach(mensagemDeErro -> builder.addErro(mensagemDeErro));
        return new ResponseEntity(builder.build(), HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        var builder = new ResponseErrorDTO.Builder();
        ex.getBindingResult().getAllErrors()
                .forEach(erro -> builder.addErro(erro.getDefaultMessage()));
        var response = builder.build();
        log.warn(response.getErro());
        return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity runtimeException(RuntimeException e, WebRequest request){
        log.error(e.getMessage(), e);
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(ERRO_INTERNO);
    }

}