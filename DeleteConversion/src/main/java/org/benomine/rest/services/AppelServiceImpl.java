package org.benomine.rest.services;

import org.benomine.rest.models.Appel;
import org.benomine.rest.repositories.AppelRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppelServiceImpl implements AppelService {

    private final AppelRepository _repository;

    public AppelServiceImpl(AppelRepository repository) {
        _repository = repository;
    }

    @Override
    public List<Appel> getAll() {
        return _repository.findAll();
    }

    @Override
    public Optional<Appel> getAppelById(String id) {
        return _repository.findById(id);
    }

    @Override
    public void removeAppelById(String id) {
        _repository.deleteById(id);
    }

    @Override
    public boolean appelExists(Appel appel) {
        return _repository.existsById(appel.getId());
    }
}
