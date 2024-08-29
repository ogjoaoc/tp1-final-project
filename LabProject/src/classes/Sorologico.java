package classes;

public class Sorologico extends Exame{
    private String patologia;
    
    // Construtores
    public Sorologico(){};

    public Sorologico(String patologia, String resultado) {
        this.patologia = patologia;
    }

    public Sorologico(String patologia, String data, Paciente pacienteAssociado, Enfermeiro enfermeiroAssociado, String dataRealizacao, double preco) {
        super(data, pacienteAssociado, enfermeiroAssociado, dataRealizacao, preco);
        this.patologia = patologia;
    }

    // métodos getters e setters
    public String getPatologia(){
        return this.patologia;
    }
    
    public void setPatologia(String p){
        this.patologia = p;
    }
    
}
