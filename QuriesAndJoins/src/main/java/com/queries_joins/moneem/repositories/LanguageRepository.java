package com.queries_joins.moneem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.queries_joins.moneem.models.Language;

@Repository
public interface LanguageRepository extends JpaRepository<Language, Long> {

}
