package classes;

public class CartaoVacina {
    private String data;
    private String dose;
    private Paciente paciente;
    private Enfermeiro enfermeiro;

    public CartaoVacina(String data, String dose, Paciente paciente, Enfermeiro enfermeiro) {
        this.data = data;
        this.dose = dose;
        this.paciente = paciente;
        this.enfermeiro = enfermeiro;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getDose() {
        return dose;
    }

    public void setDose(String dose) {
        this.dose = dose;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Enfermeiro getEnfermeiro() {
        return enfermeiro;
    }

    public void setEnfermeiro(Enfermeiro enfermeiro) {
        this.enfermeiro = enfermeiro;
    }
    
    
    
}
