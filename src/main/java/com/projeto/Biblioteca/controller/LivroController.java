/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projeto.Biblioteca.controller;

import com.projeto.Biblioteca.models.Livro;
import com.projeto.Biblioteca.service.LivroService;
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
@RequestMapping("/livro")
public class LivroController {
     private final LivroService livroService; 
    
    public LivroController(LivroService livroService){
        this.livroService = livroService;
    }
    
    @GetMapping
    public List<Livro> listarTodos(){
        return this.livroService.listarTodos();
    }
    
    
    @PostMapping
    public Livro inserir(@RequestParam String nome, @RequestParam String autor){
        return this.livroService.inserir(nome, autor);
    } 
    
    @PutMapping("/{id}")
    public Livro atualizar(@PathVariable Long id, @RequestParam String nome, @RequestParam String autor){
        return this.livroService.atualizar(id, nome, autor);
    }
    
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){
        this.livroService.deletar(id);
    }

}
