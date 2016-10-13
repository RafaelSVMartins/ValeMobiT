package com.rafael.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rafael.domain.Mercadoria;

public interface Mercadorias extends JpaRepository<Mercadoria,Long> {

}
