package main.model;

public class Aluno extends BaseEntity {
    private String nome;
    private String email;
    private String cpf;
    private String endereco;
    private String telefone;

    //Construtor sem arg
    public Aluno() {}

    //Construtor principal
    public Aluno(String id, String nome, String email, String cpf, String endereco, String telefone) {
        super(id);
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.endereco = endereco;
        this.telefone = telefone;
    }

    @Override
    public void mostrarDados() {
        System.out.println("=== Aluno ===");
        System.out.println("ID: " + id);
        System.out.println("Nome: " + nome);
        System.out.println("E-mail: " + email);
        System.out.println("Endereço: " + endereco);
        System.out.println("Telefone: " + telefone);
    }

    //Getters e Setters
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    
    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }
    
    public String getEndereco() { return endereco; }
    public void setEndereco(String endereco) { this.endereco = endereco; }

    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }
}