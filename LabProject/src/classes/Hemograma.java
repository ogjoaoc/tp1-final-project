// Classe: Hemograma
// Classe com alta especialização para classificar um Exame do tipo Hemograma.

package classes;

public class Hemograma extends Exame {
    
//    Atributo de um exame do tipo Hemograma;
//    alvo: tipo de agente requisitado para análise no sangue do Paciente.
    
    private String alvo;
    
//    Construtores
    
    public Hemograma(){};

    public Hemograma(String alvo, double preco) {
        super(preco);
        this.alvo = alvo;
    }

    public Hemograma(String alvo, String dataRealizacao, Paciente pacienteAssociado, Enfermeiro enfermeiroAssociado, double preco, boolean status) {
        super(dataRealizacao, pacienteAssociado, enfermeiroAssociado, preco, status);
        this.alvo = alvo;
    }


//    Getters e setters
    
    public String getAlvo(){
        return this.alvo;
    }
    
    public void setAlvo(String alvo){
        this.alvo = alvo;
    }

    @Override
    public String toString() {
        return "Hemograma{" + "alvo=" + alvo + '}';
    }
    
    
    
}
