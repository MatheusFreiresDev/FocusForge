package com.FocusForge.Controller.authDTO;

import com.FocusForge.Entity.UserRoles;
import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;

@Builder
public record RegisterDTO(@NotEmpty(message = "Nome invalido.") String name, @NotEmpty(message = "Email invalido.") String email, @NotEmpty(message = "Senha invalido.") String password, UserRoles role) {
}
