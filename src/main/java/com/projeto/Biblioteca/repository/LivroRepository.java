/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.projeto.Biblioteca.repository;

import com.projeto.Biblioteca.models.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author TainaSilva
 */
public interface LivroRepository extends JpaRepository<Livro, Long> {
    
}
