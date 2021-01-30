package org.benomine.rest.controllers;

import org.benomine.rest.models.Appel;
import org.benomine.rest.services.AppelServiceImpl;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/conversion/create")
public class AppelController {

    private final AppelServiceImpl _appelService;

    public AppelController(AppelServiceImpl appelService) {
        _appelService = appelService;
    }

    @PostMapping
    public HttpEntity<?> CreateAppel(@RequestBody Appel appel) {
        if (appel.getId() != null && _appelService.appelExists(appel)) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        } else {
            Appel newAppel = _appelService.createAppel(appel);
            return new ResponseEntity<>(newAppel, HttpStatus.CREATED);
        }
    }
}
