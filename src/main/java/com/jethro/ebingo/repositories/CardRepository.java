package com.jethro.ebingo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jethro.ebingo.models.Card;

public interface CardRepository extends JpaRepository<Card, Integer> {

}
