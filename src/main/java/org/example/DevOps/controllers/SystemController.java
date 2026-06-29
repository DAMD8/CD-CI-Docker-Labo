package org.example.DevOps.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class SystemController {
    @GetMapping("/status")
    public Map<String, String> getStatus() {
        return Map.of("system", "ONLINE", "database", "CONNECTED");
    }
}