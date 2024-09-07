// Classe: Funcionario
// Superclasse responsável pelas ramificações Atendente e Enfermeiro.
// Para fins de organização e gerenciamento do sistema de login.

package classes;

import interfaces.UserLogado;
import java.time.LocalDateTime;

public class Funcionario extends Pessoa implements UserLogado {
    
//    Atributos de um Funcionário;
//    - senha: String utilizada para login no sistema por parte de um funcionário.
//    - salario: valor que identifica o salário de um funcionário.
//    - dataHoraLogin: atributo responsável por armazenar o último momento em que o Funcionário logou no sistema.

    String senha;
    protected String salario;
    private LocalDateTime dataHoraLogin;
    
//    Construtor
    
    public Funcionario(String nome, String cpf, String sexo, String dataNascimento, String email, String senha, String salario) {
        super(nome, cpf, sexo, dataNascimento, email);
        this.senha = senha;
        this.salario = salario;
    }
    
//    Getters e setters
    
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
