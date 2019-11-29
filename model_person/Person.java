package model_person;

public class Person {
    private int id;
    private String nome;
    private String data_nasc;
    private String cpf;
    private String login;
    private String senha;

    public Person() { }

    public Person(int id, String nome, String data_nasc, String cpf, String login, String senha) {
        this.id = id;
        this.nome = nome;
        this.data_nasc = data_nasc;
        this.login = login;
        this.senha = senha;
        this.cpf = cpf;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getData_nasc() {
        return data_nasc;
    }

    public void setData_nasc(String data_nasc) {
        this.data_nasc = data_nasc;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

}
