package org.benomine.rest.controllers;

import org.benomine.rest.models.Appel;
import org.benomine.rest.services.AppelServiceImpl;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/conversion")
public class AppelController {

    private final AppelServiceImpl _appelService;

    public AppelController(AppelServiceImpl appelService) {
        _appelService = appelService;
    }

    @DeleteMapping("{id}")
    public HttpEntity<String> DeleteAppelById(@PathVariable("id") String id) {
        _appelService.removeAppelById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping
    public HttpEntity<?> DeleteAppel(@RequestBody Appel appel) {
        _appelService.removeAppelById(appel.getId());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
