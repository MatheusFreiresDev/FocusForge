package com.FocusForge.Controller.Request;

import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;

@Builder
public record UserRequest(@NotEmpty(message = "Nome invalido.") String name,@NotEmpty(message = "Email invalido.") String email,@NotEmpty(message = "Senha invalido.") String password) {
}
