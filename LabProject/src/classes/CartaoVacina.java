// Classe: CartaoDeVacina
// Objeto gerado após aplicação de Vacina em um Paciente, por um usuário do tipo Enfermeiro.
// Armazena informações básicas das Vacinas aplicadas em um determinado Paciente.


package classes;

public class CartaoVacina {
    

//    Atributos específicos do Cartão de Vacina;
//    - data: data em que o cartão de vacina foi gerado.
//    - dose: dose aplicada no Paciente da Vacina associada.
//    - paciente: paciente associado ao Cartão de Vacina.
//    - enfermeiro: enfermeiro associado ao Cartão de Vacina.
    
    private String data;
    private String dose;
    private Paciente paciente;
    private Enfermeiro enfermeiro;

    
//    Construtor
    
    public CartaoVacina(String data, String dose, Paciente paciente, Enfermeiro enfermeiro) {
        this.data = data;
        this.dose = dose;
        this.paciente = paciente;
        this.enfermeiro = enfermeiro;
    }

//    Getters e setters
    
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
