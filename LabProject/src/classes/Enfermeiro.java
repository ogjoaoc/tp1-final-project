package classes;

public class Enfermeiro extends Pessoa {    
    private boolean disponivel;

    public Enfermeiro(boolean disponivel, String nome, String cpf, String sexo, String dataNascimento, String email) {
        super(nome, cpf, sexo, dataNascimento, email);
        this.disponivel = disponivel;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }
}
