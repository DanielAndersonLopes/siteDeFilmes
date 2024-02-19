package com.daniel.assistemundo.model;

public class Analise {
       
    private Integer id;
    private String comentario;
    private double nota;
    private String nome;
    private Filme filme;

    public Analise() {
    }

    public Analise(Integer id, String comentario, double nota, String nome, Filme filme) {
        this.id = id;
        this.comentario = comentario;
        this.nota = nota;
        this.nome = nome;
        this.filme = filme;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Filme getFilme() {
        return filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }

    
    
    
}
