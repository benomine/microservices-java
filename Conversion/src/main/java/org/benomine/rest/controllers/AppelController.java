package org.benomine.rest.controllers;

import org.benomine.rest.models.Appel;
import org.benomine.rest.utils.Calculs;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/conversion/temperature")
public class AppelController {

    @Value("${create.uri}")
    private String url;

    final RestTemplate _restTemplate;

    public AppelController(RestTemplate restTemplate) {
        this._restTemplate = restTemplate;
    }

    @PostMapping
    public HttpEntity<?> GetConversion(@RequestBody Appel appel) throws JSONException {
        double result = appel.getSens() == 1 ?
                Calculs.ConvertCToF(appel.getValeur()) : Calculs.ConvertFToC(appel.getValeur());
        JSONObject jsonObject = parseAppelToJson(appel);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> request = new HttpEntity<>(jsonObject.toString(), httpHeaders);
        _restTemplate.postForObject(url, request, String.class);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    private JSONObject parseAppelToJson(Appel appel) throws JSONException {
        JSONObject jsonObject = new JSONObject();

        jsonObject.accumulate("nom", appel.getNom());
        jsonObject.accumulate("nomUser", appel.getNomUser());
        jsonObject.accumulate("dateAppel", appel.getDateAppel());
        jsonObject.accumulate("valeur", appel.getValeur());
        System.out.println(jsonObject);
        return jsonObject;
    }

}
