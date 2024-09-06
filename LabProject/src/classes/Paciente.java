package classes;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Paciente extends Pessoa {
    private String tipoSanguineo;
    private String convenio;

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

    public boolean isPreferencial(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        LocalDate dataNasc = LocalDate.parse(dataNascimento, formatter);
        LocalDate dataAtual = LocalDate.now();
        
        Period periodo = Period.between(dataNasc, dataAtual);
        
        return periodo.getYears() >= 65;
    }
}
