/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.projeto.Biblioteca.repository;

import com.projeto.Biblioteca.models.Emprestimo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author TainaSilva
 */
public interface EmprestimoRepository extends JpaRepository<Emprestimo, Long> {
    
}
