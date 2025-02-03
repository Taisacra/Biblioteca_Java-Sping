/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projeto.Biblioteca.exceptionHandler;

/**
 *
 * @author TainaSilva
 */
public class CamposObrigatoriosException extends RuntimeException {
    public CamposObrigatoriosException() {
        super("Preenchimento dos campos é obrigatório.");
    }

    public CamposObrigatoriosException(String message) {
        super(message);
    }
}
