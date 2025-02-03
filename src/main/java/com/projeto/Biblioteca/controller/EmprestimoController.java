/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projeto.Biblioteca.controller;

import com.projeto.Biblioteca.models.Emprestimo;
import com.projeto.Biblioteca.service.EmprestimoService;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author TainaSilva
 */
@RestController
@RequestMapping("/emprestimo")
public class EmprestimoController {
    
    private final EmprestimoService emprestimoService; 
    
    public EmprestimoController(EmprestimoService emprestimoService){
        this.emprestimoService = emprestimoService;
    }
    
    @GetMapping
    public List<Emprestimo> listarTodos(){
        return this.emprestimoService.listarTodosEmprestimos();
    }
    
    
    @PostMapping
    public Emprestimo inserir(@RequestParam Long id_usuario, @RequestParam Long id_livro){
        return this.emprestimoService.inserir(id_usuario, id_livro);
    } 
    
    @PutMapping("/{id}")
    public Emprestimo atualizar(@PathVariable Long id){
        return this.emprestimoService.atualizar(id);
    }
    
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){
        this.emprestimoService.deletar(id);
    }
            
}

