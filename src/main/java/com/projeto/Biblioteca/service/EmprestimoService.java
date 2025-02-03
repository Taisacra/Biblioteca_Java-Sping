/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projeto.Biblioteca.service;

import com.projeto.Biblioteca.exceptionHandler.CamposObrigatoriosException;
import com.projeto.Biblioteca.exceptionHandler.IdNotFoundException;
import com.projeto.Biblioteca.models.Emprestimo;
import com.projeto.Biblioteca.models.Livro;
import com.projeto.Biblioteca.models.Usuario;
import com.projeto.Biblioteca.repository.EmprestimoRepository;
import com.projeto.Biblioteca.repository.LivroRepository;
import com.projeto.Biblioteca.repository.UsuarioRepository;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

/**
 *
 * @author TainaSilva
 */
@Service
public class EmprestimoService {
    private final EmprestimoRepository emprestimoRepository;
    private final LivroRepository livroRepository;
    private final UsuarioRepository usuarioRepository;
    
    public EmprestimoService(EmprestimoRepository emprestimoRepository, LivroRepository livroRepository,UsuarioRepository usuarioRepository){
        this.emprestimoRepository = emprestimoRepository;
        this.livroRepository = livroRepository;
        this.usuarioRepository = usuarioRepository;
    }
    
    public List<Emprestimo> listarTodosEmprestimos(){
        return this.emprestimoRepository.findAll();
    }
    
    public Emprestimo inserir (Long id_usuario, Long id_livro){
        LocalDate data_emprestimo = LocalDate.now();
       
        //Verifica se o campo é nulo
        if(id_usuario == null || id_livro == null){
            System.out.println("Lançando CamposObrigatoriosException: Usuario -> " + id_usuario + ", Livro -> " + id_livro);
            throw new CamposObrigatoriosException(); 
        }
        //Retorna um Optional<Usuario>, que pode conter o usuário encontrado ou estar vazio (Optional.empty())
        //caso não exista nenhum usuário com esse ID.
        //verifica se o usuario existe 
        Optional<Usuario> usuarioOpt = usuarioRepository.findById(id_usuario);
        if(usuarioOpt.isEmpty()){
            throw new IdNotFoundException();
        } 
        
        //verificar se o livro existe
        Optional<Livro> livroOpt = livroRepository.findById(id_livro);
        if(livroOpt.isEmpty()){
            throw new IdNotFoundException();
        }
        
        Emprestimo ep = new Emprestimo();
        ep.setId_usuario(id_usuario);
        ep.setId_livro(id_livro);
        ep.setData_emprestimo(data_emprestimo);
        ep.setData_devolucao(data_emprestimo.plusDays(15));
        return this.emprestimoRepository.save(ep);  
    }
    
    public Emprestimo atualizar(Long id){
        Emprestimo emp = this.emprestimoRepository.findById(id).orElseThrow(()-> new IdNotFoundException());
        emp.setData_devolucao(emp.getData_devolucao().plusDays(15));
        return this.emprestimoRepository.save(emp);
    }
    
    public void deletar(Long id){
        Optional<Emprestimo> emprestimo = emprestimoRepository.findById(id);
        if(emprestimo.isEmpty()){
            throw new IdNotFoundException();
        }
        this.emprestimoRepository.deleteById(id);
    }
    
}

