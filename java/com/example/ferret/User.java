package com.example.ferret;

public class User {


    private static final String TAG = "User";
    private int id;
    private String nome_usuario;
    private String email;
    private String senha;
    private String nivel_acesso;
    private String telefone;
    private String status_usuario;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome_usuario() {
        return nome_usuario;
    }

    public void setNome_usuario(String nome_usuario) {
        this.nome_usuario = nome_usuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNivel_acesso() {
        return nivel_acesso;
    }

    public void setNivel_acesso(String nivel_acesso) {
        this.nivel_acesso = nivel_acesso;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getStatus_usuario() {
        return status_usuario;
    }

    public void setStatus_usuario(String status_usuario) {
        this.status_usuario = status_usuario;
    }


    public User(int id, String nome_usuario, String email, String senha, String nivel_acesso, String telefone, String status_usuario) {
        this.id = id;
        this.nome_usuario = nome_usuario;
        this.email = email;
        this.senha = senha;
        this.nivel_acesso = nivel_acesso;
        this.telefone = telefone;
        this.status_usuario = status_usuario;
    }


    public User(String email, String senha){

        this.senha = senha;
        this.email = email;
    }


    public User(String nome_usuario, String email, String senha, String nivel_acesso, String telefone, String status_usuario) {
        this.nome_usuario = nome_usuario;
        this.email = email;
        this.senha = senha;
        this.nivel_acesso = nivel_acesso;
        this.telefone = telefone;
        this.status_usuario = status_usuario;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", nome_usuario='" + nome_usuario + '\'' +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                ", nivel_acesso='" + nivel_acesso + '\'' +
                ", telefone=" + telefone +
                ", status_usuario='" + status_usuario + '\'' +
                '}';
    }

}