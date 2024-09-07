// Classe: Enfermeiro
// Objeto instanciado no cadastro por parte de um administrador
// Usuários do tipo Enfermeiro são responsáveis pela geração de resultados dos Exames e aplicações de Vacinas.

package classes;

public class Enfermeiro extends Funcionario {
    
//    Atributos de um enfermeiro;
//    - disponivel: representa a disponibilidade de um enfermeiro, a depender do número de demandas do mesmo (true) ou (false).
//    - demandas: número de demandas associadas ao enfermeiro (int).
    
    private boolean disponivel;
    private int demandas;
    

//    Construtor
    
    public Enfermeiro(String nome, String cpf, String sexo, String dataNascimento, String email, String senha, String salario, boolean disponivel) {
        super(nome, cpf, sexo, dataNascimento, email, senha, salario);
        this.disponivel = disponivel;
        this.demandas = 0;
    }
    
//    Getters e setters
    
    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }
    
}
