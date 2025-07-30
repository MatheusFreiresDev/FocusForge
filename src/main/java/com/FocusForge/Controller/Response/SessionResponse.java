package com.FocusForge.Controller.Response;

import com.FocusForge.Entity.Category;
import com.FocusForge.Entity.User;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.experimental.UtilityClass;

import java.time.LocalDateTime;
import java.util.List;

@Builder
public record SessionResponse (String name,
                              List<Category> categories,
                              User user,
                              @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
                              LocalDateTime startTime,
                              @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
                              LocalDateTime endTime,long intervalo){
}
