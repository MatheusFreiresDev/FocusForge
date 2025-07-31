package com.FocusForge.Config;

import com.FocusForge.Exceptions.EmailOrPasswordInvalid;
import org.hibernate.mapping.Map;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;

@RestControllerAdvice

public class FocusControllerAdvice {

@ExceptionHandler(MethodArgumentNotValidException.class)
@ResponseStatus(HttpStatus.BAD_REQUEST)
public HashMap<String,String> notvalid(MethodArgumentNotValidException exception){
    HashMap<String,String> erros = new HashMap<>();
    exception.getBindingResult().getAllErrors().forEach((error) ->{
        erros.put(((FieldError) error).getField(),error.getDefaultMessage());
    });
    return erros;
}

}
