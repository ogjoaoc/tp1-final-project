package classes;

public class Paciente extends Pessoa {
    private String tipoSanguineo;
    private String convenio;
    private boolean preferencial;

    public Paciente(String tipoSanguineo, String convenio, boolean preferencial, String nome, String cpf, String sexo, String dataNascimento, String email) {
        super(nome, cpf, sexo, dataNascimento, email);
        this.tipoSanguineo = tipoSanguineo;
        this.convenio = convenio;
        this.preferencial = preferencial;
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

    public boolean isPreferencial() {
        return preferencial;
    }

    public void setPreferencial(boolean preferencial) {
        this.preferencial = preferencial;
    }
    
    
    
}
