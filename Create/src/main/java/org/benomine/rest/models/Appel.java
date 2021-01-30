package org.benomine.rest.models;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Getter@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "appels")
public class Appel {
    @Id
    @Generated
    private String id;
    private String nom;
    private String nomUser;
    private double valeur;
    private Date dateAppel;
}
