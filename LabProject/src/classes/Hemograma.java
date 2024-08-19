package classes;

public class Hemograma extends Exame {
    private String alvo, resultado;
    
    // Construtores
    public Hemograma(){};
    
    public Hemograma(String d, Paciente p, Enfermeiro e, String alvo){
        super(d,p,e);
        this.alvo = alvo;
    }
    
    // métodos getters e setters
    public String getAlvo(){
        return this.alvo;
    }
    
    public void setAlvo(String alvo){
        this.alvo = alvo;
    }
    
    public String getResultado(){
        return this.resultado;
    }
    
    public void setResultado(String resultado){
        this.resultado = resultado;
    }
    
}
