package com.example.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Model.Foto;


public interface FotoRepository extends JpaRepository<Foto, Long>  {
    
}
