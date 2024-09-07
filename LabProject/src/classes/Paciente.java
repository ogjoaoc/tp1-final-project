// Classe: Paciente
// Objeto instanciado no cadastro de um Paciente por um usuário do tipo Atendente.
// Armazena informações de um Paciente que pode participar de Exames e receber Vacinas.
// Possuí múltiplos construtores, e um método auxiliar isPreferencial().

package classes;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Paciente extends Pessoa {
    
//    Atributos específicos do Paciente;
//    - tipoSanguineo: classifica o tipo sanguíneo do Paciente (ex: O+, A-).
//    - convenio: referente ao convênio que aquele Paciente possuí, podendo não ter nenhum ("Sem convênio").
    
    private String tipoSanguineo;
    private String convenio;

    
//    Construtores
    
    public Paciente(String nome, String cpf, String sexo, String dataNascimento, String email, String tipoSanguineo) {
        super(nome, cpf, sexo, dataNascimento, email);
        this.tipoSanguineo = tipoSanguineo;
        this.convenio = "Sem convênio.";
    }
    
    public Paciente(String nome, String cpf, String sexo, String dataNascimento, String email, String tipoSanguineo, String convenio) {
        super(nome, cpf, sexo, dataNascimento, email);
        this.tipoSanguineo = tipoSanguineo;
        this.convenio = convenio;
    }
    
//    Getters e setters
    
    public String getTipoSanguineo() {
        return tipoSanguineo;
    }

    public void setTipoSanguineo(String tipoSanguineo) {
        this.tipoSanguineo = tipoSanguineo;
    }

    public String getConvenio() {
        return convenio;
    }

    public void setConvenio(String convenio) {
        this.convenio = convenio;
    }
    
//    Método auxiliar para verificar se o paciente se enquadra como idoso ou não (Regra de negócio).
    
    public boolean isPreferencial(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        LocalDate dataNasc = LocalDate.parse(dataNascimento, formatter);
        LocalDate dataAtual = LocalDate.now();
        
        Period periodo = Period.between(dataNasc, dataAtual);
        
        return periodo.getYears() >= 65;
    }
}
