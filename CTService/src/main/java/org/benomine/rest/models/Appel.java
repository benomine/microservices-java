package org.benomine.rest.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Appel {
    private String nom;
    private String nomUser;
    private double valeur;
    private String dateAppel;
    private int sens;
}
