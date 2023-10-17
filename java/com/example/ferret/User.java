package com.example.ferret;

public class
User {


    private static final String TAG = "User";

    private int id;
    private String nome_usuario;
    private String email;
    private String senha;
    private String nivel_acesso;
    private String telefone;
    private String status_usuario;
    private String reset_password_otp;
    private long reset_password_created_at;
    private String token;

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

    public String getReset_password_otp() {
        return reset_password_otp;
    }

    public void setReset_password_otp(String resetPasswordOtp) {
        reset_password_otp = resetPasswordOtp;
    }

    public long getReset_password_created_at() {
        return 	reset_password_created_at;
    }

    public void setReset_password_created_at(long 	reset_password_created_at) {
        reset_password_created_at = 	reset_password_created_at;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        token = token;
    }

    public User(String email , String senha){
        this.email = email;
        this.senha = senha;
    }

    public User (String email){
        this.email
    }
    public User(int id, String nome_usuario, String email, String senha, String nivel_acesso, String telefone, String status_usuario, String reset_password_otp, long 	reset_password_created_at, String token) {
        this.id = id;
        this.nome_usuario = nome_usuario;
        this.email = email;
        this.senha = senha;
        this.nivel_acesso = nivel_acesso;
        this.telefone = telefone;
        this.status_usuario = status_usuario;
        this.reset_password_otp = reset_password_otp;
        this.reset_password_created_at = reset_password_created_at;
        this.token = token;
    }

    public User(String nome_usuario, String email, String senha, String nivel_acesso, String telefone, String status_usuario, String reset_password_otp, long 	reset_password_created_at, String token) {
        this.nome_usuario = nome_usuario;
        this.email = email;
        this.senha = senha;
        this.nivel_acesso = nivel_acesso;
        this.telefone = telefone;
        this.status_usuario = status_usuario;
        this.reset_password_otp = reset_password_otp;
        this.reset_password_created_at = 	reset_password_created_at;
        this.token = token;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", nome_usuario='" + nome_usuario + '\'' +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                ", nivel_acesso='" + nivel_acesso + '\'' +
                ", telefone='" + telefone + '\'' +
                ", status_usuario='" + status_usuario + '\'' +
                ", reset_password_otp='" + reset_password_otp + '\'' +
                ", reset_password_created_at=" + 	reset_password_created_at +
                ", token='" + token + '\'' +
                '}';
    }
}