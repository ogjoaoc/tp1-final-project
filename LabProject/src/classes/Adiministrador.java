package classes;

public class Adiministrador extends Pessoa {
    private String login;
    private String senha;

    public Adiministrador(String login, String senha, String nome, String cpf, String sexo, String dataNascimento, String email) {
        super(nome, cpf, sexo, dataNascimento, email);
        this.login = login;
        this.senha = senha;
    }
}
