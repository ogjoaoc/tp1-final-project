package classes;
/**
 *
 * @author analuisa
 */
public class Exame {
    private String data, tipo, patologia, alvo, resultado;
    private Paciente paciente;
    private Enfermeiro enfermeiro;
    
    public Exame(String d, String t, Paciente p, Enfermeiro e){
        this.data = d;
        this.tipo = t;
        this.paciente = p;
        this.enfermeiro = e;
    }
    
    // métodos getters
    public String getData(){
        return this.data;
    }
    public String getTipo(){
        return this.tipo;
    }
    public String getPatologia(){
        return this.patologia;
    }
    public String getAlvo(){
        return this.alvo;
    }
    public String getResultado(){
        return this.resultado;
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
    public void setTipo(String t){
        this.tipo = t;
    }
    public void setPatologia(String pt){
        this.patologia = pt;
    }
    public void setAlvo(String a){
        this.alvo = a;
    }
    public void setResultado(String r){
        this.resultado = r;
    }
    public void setPaciente(Paciente p){
        this.paciente = p;
    }
    public void setEnfermeiro(Enfermeiro e){
        this.enfermeiro = e;
    } 
    
}
