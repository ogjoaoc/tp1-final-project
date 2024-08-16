package classes;

public class Enfermeiro extends Funcionario {    
    private boolean disponivel;

    public Enfermeiro(String nome, String cpf, String sexo, String dataNascimento, String email, String senha, String salario, boolean disponivel) {
        super(nome, cpf, sexo, dataNascimento, email, senha, salario);
        this.disponivel = disponivel;
    }
    

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }
    
}
