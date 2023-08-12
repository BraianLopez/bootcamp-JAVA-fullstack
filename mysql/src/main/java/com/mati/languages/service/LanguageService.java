package com.mati.languages.service;

import com.mati.languages.entity.Language;
import com.mati.languages.repository.LanguageRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LanguageService {
    private final LanguageRepository languageRepository;

    public LanguageService(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }

    public List<Language> findAll() {
        return languageRepository.findAll();
    }

    public Language save(Language language){
        return languageRepository.save(language);
    }

    public boolean existsById(Long id){
        return id != null && languageRepository.existsById(id);
    }

    public Optional<Language> findById(Long id) {
        return id != null ? languageRepository.findById(id) : Optional.empty();
    }

    public void deleteById(Long id) {
        languageRepository.deleteById(id);
    }
}
