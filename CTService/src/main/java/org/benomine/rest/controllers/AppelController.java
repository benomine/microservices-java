package org.benomine.rest.controllers;

import org.benomine.rest.models.Appel;
import org.benomine.rest.utils.Calculs;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@RestController
@RequestMapping("/api/conversiontemperature")
public class AppelController {

    @Value("${create.uri}")
    private String url;

    @PostMapping
    public HttpEntity<?> GetAppel(@RequestBody Appel appel) throws JSONException {
        double result = appel.getSens() == 1 ?
                Calculs.ConvertCToF(appel.getValeur()) : Calculs.ConvertFToC(appel.getValeur());
        JSONObject jsonObject = parseAppelToJson(appel);
        var client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(jsonObject.toString()))
                .build();

        client.sendAsync(request, HttpResponse.BodyHandlers.ofString());

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
