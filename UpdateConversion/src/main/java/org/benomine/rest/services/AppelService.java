package org.benomine.rest.services;

import org.benomine.rest.models.Appel;

import java.util.List;
import java.util.Optional;

public interface AppelService {
    List<Appel> getAll();
    Optional<Appel> getAppelById(String id);
    void updateAppel(Appel appel);
}
