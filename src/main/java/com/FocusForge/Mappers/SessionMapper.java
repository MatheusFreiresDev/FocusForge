package com.FocusForge.Mappers;

import com.FocusForge.Controller.Request.SessionRequest;
import com.FocusForge.Controller.Response.SessionResponse;
import com.FocusForge.Entity.Session;
import lombok.experimental.UtilityClass;

@UtilityClass
public class SessionMapper {

    public static Session toEntity(SessionRequest request) {
        if (request == null) return null;
        return Session.builder()
                .name(request.name())
                .categories(request.categories())
                .user(request.user())
                .startTime(request.startTime())
                .endTime(request.endTime())
                .intervalo(request.intervalo())
                .build();
    }

    public static SessionResponse toResponse(Session session) {
        if (session == null) return null;
        return SessionResponse.builder()
                .name(session.getName())
                .categories(session.getCategories())
                .user(session.getUser())
                .startTime(session.getStartTime())
                .endTime(session.getEndTime())
                .intervalo(session.getIntervalo())
                .build();
    }
}
