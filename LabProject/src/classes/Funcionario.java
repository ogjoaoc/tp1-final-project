package classes;

public class Funcionario extends Pessoa {
    String senha;
    protected String salario;

    public Funcionario(String nome, String cpf, String sexo, String dataNascimento, String email, String senha, String salario) {
        super(nome, cpf, sexo, dataNascimento, email);
        this.senha = senha;
        this.salario = salario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getSalario() {
        return salario;
    }

    public void setSalario(String salario) {
        this.salario = salario;
    }
    
}
