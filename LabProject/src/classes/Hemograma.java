package classes;

public class Hemograma extends Exame {
    private String alvo;
    
    // Construtores
    public Hemograma(){};

    public Hemograma(String alvo, double preco) {
        super(preco);
        this.alvo = alvo;
    }

    public Hemograma(String alvo, String dataRealizacao, Paciente pacienteAssociado, Enfermeiro enfermeiroAssociado, double preco) {
        super(dataRealizacao, pacienteAssociado, enfermeiroAssociado, preco);
        this.alvo = alvo;
    }

    // métodos getters e setters
    public String getAlvo(){
        return this.alvo;
    }
    
    public void setAlvo(String alvo){
        this.alvo = alvo;
    }
    
}
