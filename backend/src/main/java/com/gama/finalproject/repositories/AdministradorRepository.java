package com.gama.finalproject.repositories;

import java.util.Optional;

import com.gama.finalproject.entities.Administrador;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AdministradorRepository extends JpaRepository<Administrador, Long> {

    Optional<Administrador> findByUsuario(String usuario);

}
