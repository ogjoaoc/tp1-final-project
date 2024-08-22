package classes;

import interfaces.UserLogado;
import java.time.LocalDateTime;

public class Funcionario extends Pessoa implements UserLogado {
    
    String senha;
    protected String salario;
    private LocalDateTime dataHoraLogin;

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
    
    @Override
    public LocalDateTime getDataHoraLogin() {
        return dataHoraLogin;
    }

    @Override
    public Funcionario getFuncionario() {
        return this;
    }

    
    
}
