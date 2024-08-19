package classes;

public abstract class Exame {
    private String data;
    private Paciente paciente;
    private Enfermeiro enfermeiro;
    
    // construtores
    public Exame(){};
    
    public Exame(String d, Paciente p, Enfermeiro e){
        this.data = d;
        this.paciente = p;
        this.enfermeiro = e;
    }
    
    // métodos getters
    public String getData(){
        return this.data;
    }
    
    public Paciente getPaciente(){
        return this.paciente;
    }
    
    public Enfermeiro getEnfermeiro(){
        return this.enfermeiro;
    }
    
    //métodos setters
    public void setData(String d){
        this.data = d;
    }
        
    public void setPaciente(Paciente p){
        this.paciente = p;
    }
    
    public void setEnfermeiro(Enfermeiro e){
        this.enfermeiro = e;
    } 
    
}
