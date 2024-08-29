package classes;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class Agendamento {
    
    private int id; 
    private ArrayList<Exame> listaExames;
    private ArrayList<Vacina> listaVacinas;
    private SimpleDateFormat dataCriado;
    private double valorTotal;
    
    // gerar csv no formato id, tipo, cpfPaciente, cpfEnfermeiro, dataCriado, dataAgendado, { info exame ou info vacina }
    
    public Agendamento () {
        
    }

    public Agendamento(int id, ArrayList<Exame> listaExames, ArrayList<Vacina> listaVacinas, SimpleDateFormat dataCriado, double valorTotal) {
        this.id = id;
        this.listaExames = listaExames;
        this.listaVacinas = listaVacinas;
        this.dataCriado = dataCriado;
        this.valorTotal = valorTotal;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Exame> getListaExames() {
        return listaExames;
    }

    public void setListaExames(ArrayList<Exame> listaExames) {
        this.listaExames = listaExames;
    }

    public ArrayList<Vacina> getListaVacinas() {
        return listaVacinas;
    }

    public void setListaVacinas(ArrayList<Vacina> listaVacinas) {
        this.listaVacinas = listaVacinas;
    }

    public SimpleDateFormat getDataCriado() {
        return dataCriado;
    }

    public void setDataCriado(SimpleDateFormat dataCriado) {
        this.dataCriado = dataCriado;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }
    
    
    
}
