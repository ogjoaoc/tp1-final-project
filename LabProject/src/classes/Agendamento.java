package classes;

import java.util.ArrayList;
import java.util.Date;

public class Agendamento {
    
    private int id; 
    private ArrayList<Exame> listaExames;
    private ArrayList<Vacina> listaVacinas;
    private Date dataCriado;
    private double valorTotal = 0f;
    
    // gerar csv no formato id, tipo, cpfPaciente, cpfEnfermeiro, dataCriado, dataAgendado, { info exame ou info vacina }
    
    public Agendamento () {
        this.listaExames = new ArrayList<>();
        this.listaVacinas = new ArrayList<>();
    }

    public Agendamento(int id, ArrayList<Exame> listaExames, ArrayList<Vacina> listaVacinas, double valorTotal) {
        this.id = id;
        this.listaExames = listaExames;
        this.listaVacinas = listaVacinas;
        this.dataCriado = new Date();
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

    public Date getDataCriado() {
        return dataCriado;
    }

    public void setDataCriado(Date dataCriado) {
        this.dataCriado = dataCriado;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }
    
    public void adicionarExame(Exame exame) {
        this.listaExames.add(exame);
    }
    
    public void adicionarVacina(Vacina vacina) {
        this.listaVacinas.add(vacina);
    }
    
}
