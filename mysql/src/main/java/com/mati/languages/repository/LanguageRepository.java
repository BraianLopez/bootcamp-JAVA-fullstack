package com.mati.languages.repository;

import com.mati.languages.entity.Language;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LanguageRepository extends CrudRepository<Language, Long> {
    List<Language> findAll();
    boolean existsById(Long id);
    Optional<Language> findById(Long id);
    void deleteById(Long id);
}
