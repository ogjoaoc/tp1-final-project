package classes;

public class Sorologico extends Exame{
    private String patologia, resultado;
    
    // Construtores
    public Sorologico(){};
    
    public Sorologico(String d, Paciente p, Enfermeiro e, String patologia){
        super(d,p,e);
        this.patologia = patologia;
    }
    
    // métodos getters e setters
    public String getPatologia(){
        return this.patologia;
    }
    
    public void setPatologia(String p){
        this.patologia = p;
    }
    
    public String getResultado(){
        return this.resultado;
    }
    
    public void setResultado(String resultado){
        this.resultado = resultado;
    }
    
}
