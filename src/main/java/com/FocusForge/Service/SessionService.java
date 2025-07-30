package com.FocusForge.Service;

import com.FocusForge.Entity.Session;
import com.FocusForge.Repository.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class SessionService {

    @Autowired
    private SessionRepository sessionRepository;

    public Session save(Session entity, Long intervalo) {
        entity.setStartTime(LocalDateTime.now());
        entity.setIntervalo(intervalo);
        entity.setEndTime(entity.getStartTime().plusMinutes(entity.getIntervalo()));
        return sessionRepository.save(entity);
    }

    public List<Session> findAllByUserId(Long userId) {
        return sessionRepository.findByUserId(userId);
    }

    public Optional<Session> findById(Long id) {
        return sessionRepository.findById(id);
    }

    public void deleteById(Long id) {
        sessionRepository.deleteById(id);
    }
}
