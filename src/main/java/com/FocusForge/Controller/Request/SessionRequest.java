package com.FocusForge.Controller.Request;

import com.FocusForge.Entity.Category;
import com.FocusForge.Entity.User;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotEmpty;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public record SessionRequest(String name,
                             List<Category> categories,
                             User user,
                             @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
                             LocalDateTime startTime,
                             @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
                             LocalDateTime endTime,long intervalo) {
}
