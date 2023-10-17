package com.example.ferret;

public class Project {

    private static final String TAG = "Project";

    private int id;

    private String titulo;
    private int quant_membros;
    private String descricao;
    private String data_inicio;
    private String data_fim;
    private String status_projeto;
    private Long foto_projeto;
    private int usuario_id;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getQuant_membros() {
        return quant_membros;
    }

    public void setQuant_membros(int quant_membros) {
        this.quant_membros = quant_membros;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getData_inicio() {
        return data_inicio;
    }

    public void setData_inicio(String data_inicio) {
        this.data_inicio = data_inicio;
    }

    public String getData_fim() {
        return data_fim;
    }

    public void setData_fim(String data_fim) {
        this.data_fim = data_fim;
    }

    public String getStatus_projeto() {
        return status_projeto;
    }

    public void setStatus_projeto(String status_projeto) {
        this.status_projeto = status_projeto;
    }

    public Long getFoto_projeto() {
        return foto_projeto;
    }

    public void setFoto_projeto(Long foto_projeto) {
        this.foto_projeto = foto_projeto;
    }

    public int getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(int usuario_id) {
        this.usuario_id = usuario_id;
    }

    public Project(int id, String titulo, int quant_membros, String descricao, String data_inicio, String data_fim, String status_projeto, Long foto_projeto, int usuario_id) {
        this.id = id;
        this.titulo = titulo;
        this.quant_membros = quant_membros;
        this.descricao = descricao;
        this.data_inicio = data_inicio;
        this.data_fim = data_fim;
        this.status_projeto = status_projeto;
        this.foto_projeto = foto_projeto;
        this.usuario_id = usuario_id;
    }

    public Project(String titulo, int quant_membros, String descricao, String data_inicio, String data_fim, String status_projeto, Long foto_projeto, int usuario_id) {
        this.titulo = titulo;
        this.quant_membros = quant_membros;
        this.descricao = descricao;
        this.data_inicio = data_inicio;
        this.data_fim = data_fim;
        this.status_projeto = status_projeto;
        this.foto_projeto = foto_projeto;
        this.usuario_id = usuario_id;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", quant_membros='" + quant_membros + '\'' +
                ", descricao='" + descricao + '\'' +
                ", data_inicio='" + data_inicio + '\'' +
                ", data_fim=" + data_fim +
                ", status_projeto='" + status_projeto + '\'' +
                ", foto_projeto='" + foto_projeto + '\'' +
                ", usuario_id='" + usuario_id + '\'' +
                '}';
    }

}