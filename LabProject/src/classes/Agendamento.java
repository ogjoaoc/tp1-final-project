// Classe: Agendamento
// Objeto instanciado por um usuário do tipo Atendente ao final da interface de pagamento.
// Fito de de armazenar o conjunto de exames e vacinas de um Paciente no sistema. 
// Também é utilizado na logística de realização de exames dos usuários do tipo Enfermeiro.

package classes;

import java.util.ArrayList;
import java.util.Date;

public class Agendamento {
    
    
//    Atributos de um agendamento;
//    - Identificação.
//    - Vetor de Exames associados aquele agendamento.
//    - Vetor de vacinas associadas aquele agendamento.
//    - Data de criação.
//    - Valor total $.

    private int id; 
    private ArrayList<Exame> listaExames;
    private ArrayList<Vacina> listaVacinas;
    private Date dataCriado;
    private double valorTotal = 0f;
    
//     Um agendamento é salvo na database no arquivo dadosAgendamento.csv
//     no formato id,dataCriacao,valorTotal,subtipoExame(Vacina),tipoExame(Vacina),dataRealizacao,cpfPacienteAssociado,cpfEnfermeiroAssociado,status(Realizado ou não)

    
//    Construtores
    
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
    
//    Getters e setters
    
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
