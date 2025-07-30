package com.FocusForge.Controller;

import com.FocusForge.Controller.Request.SessionRequest;
import com.FocusForge.Entity.Session;
import com.FocusForge.Mappers.SessionMapper;
import com.FocusForge.Service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/sessions")  // Pra seguir padrão plural
public class SessionController {

    @Autowired
    private SessionService sessionService;

    // Criar nova sessão
    @PostMapping("/{intervalo}")
    public ResponseEntity<?> criar(@RequestBody SessionRequest sessionRequest, @PathVariable Long intervalo){
        Session saved = sessionService.save(SessionMapper.toEntity(sessionRequest), intervalo);
        return ResponseEntity.status(HttpStatus.CREATED).body(SessionMapper.toResponse(saved));
    }

    // Listar sessões do usuário
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Session>> listarPorUsuario(@PathVariable Long userId) {
        List<Session> sessions = sessionService.findAllByUserId(userId);
        return ResponseEntity.ok(sessions);
    }

    // Buscar sessão por id
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id) {
        Optional<Session> sessionOpt = sessionService.findById(id);
        if(sessionOpt.isPresent()) {
            return ResponseEntity.ok(sessionOpt.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Sessão não encontrada");
        }
    }

    // Deletar sessão por id
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarPorId(@PathVariable Long id) {
        sessionService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
