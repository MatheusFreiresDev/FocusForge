package com.FocusForge.Controller.authDTO;

import lombok.Builder;

@Builder
public record LoginDTO(String email, String password) {
}
