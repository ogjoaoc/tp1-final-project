package classes;

public class Paciente extends Pessoa {
    private String tipoSanguineo;
    private String convenio;
    private int idade;
    private boolean preferencial;

    public Paciente(String tipoSanguineo, String convenio, int idade, boolean preferencial, String nome, String cpf, String sexo, String dataNascimento, String email) {
        super(nome, cpf, sexo, dataNascimento, email);
        this.tipoSanguineo = tipoSanguineo;
        this.convenio = convenio;
        this.idade = idade;
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

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public boolean isPreferencial() {
        return preferencial;
    }

    public void setPreferencial(boolean preferencial) {
        this.preferencial = preferencial;
    }
    
    
    
}
