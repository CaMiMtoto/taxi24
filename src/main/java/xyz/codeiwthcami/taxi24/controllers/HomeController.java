package xyz.codeiwthcami.taxi24.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HomeController {
    @GetMapping("/")
    public ResponseEntity<?> home() {
        Map<String, String> response = new HashMap<>();
        response.put("message", "Welcome to Taxi24");
        response.put("version", "1.0");
        return ResponseEntity.ok(response);
    }
}
