package org.benomine.rest.controllers;

import org.benomine.rest.models.Appel;
import org.benomine.rest.services.AppelServiceImpl;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/conversion/read")
public class AppelController {

    private final AppelServiceImpl _appelService;

    public AppelController(AppelServiceImpl appelService) {
        _appelService = appelService;
    }

    @GetMapping
    public HttpEntity<List<Appel>> GetAll() {
        var appels = _appelService.getAll();
        if(appels.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(appels, HttpStatus.OK);
        }
    }

    @GetMapping("{id}")
    public HttpEntity<Appel> GetConversion(@PathVariable("id") String id) {
        if(!_appelService.appelExists(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else {
            Optional<Appel> appel = _appelService.getAppelById(id);
            if (appel.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(appel.get(), HttpStatus.OK);
            }
        }
    }
}
