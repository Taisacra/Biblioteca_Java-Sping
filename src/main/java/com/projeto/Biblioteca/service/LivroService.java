/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projeto.Biblioteca.service;

import com.projeto.Biblioteca.exceptionHandler.CamposObrigatoriosException;
import com.projeto.Biblioteca.exceptionHandler.IdNotFoundException;
import com.projeto.Biblioteca.models.Livro;
import com.projeto.Biblioteca.repository.LivroRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

/**
 *
 * @author TainaSilva
 */
@Service
public class LivroService {
     private final LivroRepository livroRepository;

    public LivroService(LivroRepository livroRepository){
        this.livroRepository = livroRepository;
    }
    
    public List<Livro> listarTodos(){
        return this.livroRepository.findAll();
    }
    
    public Livro inserir(String nome, String autor){
        if(nome.isBlank() || autor.isBlank()){
            System.out.println("Lançando CamposObrigatoriosException: Nome -> " + nome + ", Autor -> " + autor);
             throw new CamposObrigatoriosException(); 
        }
        Livro l = new Livro();
        l.setNome(nome);
        l.setAutor(autor);
        return this.livroRepository.save(l);
    }
    
    public Livro atualizar(Long id,String nome,String autor){
         if(nome.isBlank() || autor.isBlank()){
            System.out.println("Lançando CamposObrigatoriosException: Nome -> " + nome + ", Autor -> " + autor);
             throw new CamposObrigatoriosException(); 
        }
        Livro livro = this.livroRepository.findById(id).orElseThrow(()-> new IdNotFoundException());
        livro.setNome(nome);
        livro.setAutor(autor);
        return this.livroRepository.save(livro);
    }
    
    public void deletar(Long id){
        Optional<Livro> livro = livroRepository.findById(id);
        if(livro.isEmpty()){
            throw new IdNotFoundException();
        }
        this.livroRepository.deleteById(id);
    }
}
