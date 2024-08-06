package org.integracao.controller;

import org.integracao.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/webhook")
public class WebhookController {

    @Autowired
    private AttendanceService attendanceService;

    @PostMapping("/receive")
    public ResponseEntity<String> receiveBundle(@RequestBody String bundle) {
        try {
            attendanceService.processBundle(bundle);
            return ResponseEntity.ok("Bundle received and processed successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error processing bundle: " + e.getMessage());
        }
    }
}
