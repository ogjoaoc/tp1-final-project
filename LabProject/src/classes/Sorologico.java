package classes;

public class Sorologico extends Exame{
    private String patologia;
    
    // Construtores
    public Sorologico(){};

    public Sorologico(String patologia, double preco) {
        super(preco);
        this.patologia = patologia;
    }

    public Sorologico(String patologia, String dataRealizacao, Paciente pacienteAssociado, Enfermeiro enfermeiroAssociado, double preco, boolean status) {
        super(dataRealizacao, pacienteAssociado, enfermeiroAssociado, preco, status);
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
