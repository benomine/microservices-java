package org.benomine.rest.controllers;

import org.benomine.rest.models.Appel;
import org.benomine.rest.services.AppelServiceImpl;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/conversion/update")
public class AppelController {

    private final AppelServiceImpl _conversionService;

    public AppelController(AppelServiceImpl conversionService) {
        _conversionService = conversionService;
    }

    @PutMapping
    public HttpEntity<?> UpdateAppel(@RequestBody Appel appel) {
        Optional<Appel> update = _conversionService.getAppelById(appel.getId());
        if(update.isPresent()) {
            update.get().setDateAppel(appel.getDateAppel());
            update.get().setNom(appel.getNom());
            update.get().setNomUser(appel.getNomUser());
            update.get().setValeur(appel.getValeur());
            _conversionService.updateAppel(update.get());
            return new ResponseEntity<>(update.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PatchMapping
    public HttpEntity<?> PatchAppel(@RequestBody Appel appel) {
        Optional<Appel> update = _conversionService.getAppelById(appel.getId());
        if(update.isPresent()) {
            update.get().setDateAppel(appel.getDateAppel());
            update.get().setNom(appel.getNom());
            update.get().setNomUser(appel.getNomUser());
            update.get().setValeur(appel.getValeur());
            _conversionService.updateAppel(update.get());
            return new ResponseEntity<>(update.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
