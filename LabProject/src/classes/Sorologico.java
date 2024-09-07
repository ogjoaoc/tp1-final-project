// Classe: Hemograma
// Classe com alta especialização para classificar um Exame do tipo Sorológico.

package classes;

public class Sorologico extends Exame{
    
//    Atributo de um exame do tipo Sorológico;
//    patologia: tipo de agente requisitado para teste ou diagnóstico dado o Paciente (ex: Dengue, Zika Vírus, Aids).
    
    private String patologia;
    
//      Construtores
    
    public Sorologico(){};

    public Sorologico(String patologia, double preco) {
        super(preco);
        this.patologia = patologia;
    }

    public Sorologico(String patologia, String dataRealizacao, Paciente pacienteAssociado, Enfermeiro enfermeiroAssociado, double preco, boolean status) {
        super(dataRealizacao, pacienteAssociado, enfermeiroAssociado, preco, status);
        this.patologia = patologia;
    }

//    Getters e setters
    
    public String getPatologia(){
        return this.patologia;
    }
    
    public void setPatologia(String p){
        this.patologia = p;
    }
    
}
