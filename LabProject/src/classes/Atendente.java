// Classe: Atendente
// Objeto instanciado no cadastro de um usuário por parte do administrador
// Tem como função o cadastro de Pacientes e criação de Agendamentos de Exames e Vacinas.
// Pode visualizar resultados de usuários a partir do cpf, pesquisar e editar dados de Pacientes cadastrados.

package classes;

public class Atendente extends Funcionario{

//    Atributos específicos do Atendente;
//    - turno: Matutino ou Vespertino, gerado no cadastro.
//    - credencial: identificador aleatório gerado no cadastro.
//    - qtdAgendamentos: quantidade de Agendamnetos criados.

    private String turno;
    private int credencial;
    private int qtdAgendamentos;
    
    
//    Construtores
    
    public Atendente(String nome, String cpf, String sexo, String dataNascimento, String email, String senha, String salario, String turno, int credencial, int qtdAgendamentos) {
        super(nome, cpf, sexo, dataNascimento, email, senha, salario);
        this.turno = turno;
        this.credencial = credencial;
        this.qtdAgendamentos = qtdAgendamentos;
    }

//    Getters e setters
    
    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public int getCredencial() {
        return credencial;
    }

    public void setCredencial(int credencial) {
        this.credencial = credencial;
    }

    public int getQtdAgendamentos() {
        return qtdAgendamentos;
    }

    public void setQtdAgendamentos(int qtdAgendamentos) {
        this.qtdAgendamentos = qtdAgendamentos;
    }
    
}
