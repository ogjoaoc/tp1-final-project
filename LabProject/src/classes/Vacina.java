// Classe: Vacina
// Uma vacina é instanciada em diferentes momentos, tanto no cadastro de novos tipos de Vacinas, quanto
// durante o agendamento por parte de um usuário do tipo Atendente.
// Há métodos auxiliares para identificação do preço do convênio e aplicação da vacina.


package classes;

import java.util.Arrays;
import java.util.List;

public class Vacina {
    
//     Atributos de uma Vacina:
//     - tipoVacina: Tipo da vacina (ex: Covid-19, Gripe, Hepatite).
//     - validade: Data de validade da vacina.
//     - dose: Dose da vacina (ex: 1ª dose, 2ª dose, dose de reforço).
//     - disponivel: Indica se a vacina está disponível em estoque (true) ou não (false).
//     - status: Indica se a vacina foi aplicada (true) ou ainda está pendente (false).
//     - enfermeiroAssociado: Enfermeiro responsável pela aplicação da vacina.
//     - pacienteAssociado: Paciente que receberá ou recebeu a vacina.
//     - qtd: Quantidade disponível da vacina.
//     - preco: Preço da vacina.

    
    private String tipoVacina, validade, dose;
    private boolean disponivel, status;
    private Enfermeiro enfermeiroAssociado;
    private Paciente pacienteAssociado;
    private int qtd;
    private double preco;
    
//      Construtores
    
    public Vacina(){}; 
    
    public Vacina(String tipoVacina, String validade, boolean disponivel, int qtd, double preco) {
        this.tipoVacina = tipoVacina;
        this.validade = validade;
        this.disponivel = disponivel;
        this.qtd = qtd;
        this.preco = preco;
    }

    public Vacina(String tipoVacina, String validade, Enfermeiro enfermeiroAssociado, Paciente pacienteAssociado, String dose, double preco, boolean status) {
        this.tipoVacina = tipoVacina;
        this.validade = validade;
        this.enfermeiroAssociado = enfermeiroAssociado;
        this.pacienteAssociado = pacienteAssociado;
        this.dose = dose;
        this.preco = preco;
        this.status = status;
    }
    
//    Método auxiliar para saber qual o valor do desconto oferecido pelos diferentes tipos de Convênios cadastrados.
    
    public double precoConvenio(String convenio){
        List<String> vacinasCobertas;

        switch (convenio) {
            case "Sem Convênio" -> {
                return preco;
            }
            case "Unimed" -> {
                vacinasCobertas = Arrays.asList("Tríplice Viral", "Hepatite B", "Febre Amarela", "HPV");

                if (vacinasCobertas.contains(getTipoVacina())) {
                    return preco * 0.9; // 10% de desconto para vacinas
                } else {
                    return preco;
                }
            }
            case "Amil" -> {
                vacinasCobertas = Arrays.asList("Tríplice Viral", "Dupla Adulto", "Meningocócica ACWY");

                if (vacinasCobertas.contains(getTipoVacina())) {
                    return preco * 0.85; // 15% de desconto para vacinas
                } else {
                    return preco;
                }
            }
            case "Bradesco Saúde" -> {
                vacinasCobertas = Arrays.asList("Hepatite B", "Dupla Adulto", "Febre Amarela", "HPV");

                if (vacinasCobertas.contains(getTipoVacina())) {
                    return preco * 0.75; // 25% de desconto para vacinas
                } else {
                    return preco;
                }
            }
            case "Porto Seguro" -> {
                vacinasCobertas = Arrays.asList("Tríplice Viral", "Hepatite B", "Febre Amarela", "Meningocócica ACWY");

                if (vacinasCobertas.contains(getTipoVacina())) {
                    return preco * 0.7; // 30% de desconto para vacinas
                } else {
                    return preco;
                }
            }
            default -> {
                return preco;
            }
        }
    }
    
//      Getters e setters
    
    public String getTipoVacina() {
        return tipoVacina;
    }

    public void setTipoVacina(String tipoVacina) {
        this.tipoVacina = tipoVacina;
    }

    public String getValidade(){
        return this.validade;
    }
    
    public void setValidade(String data){
        this.validade = data;
    }
    
    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }
    
    public String getDose(){
        return this.dose;
    }
    
    public void setDose(String dose){
        this.dose = dose;
    }
    
    public double getPreco(){
        return this.preco;
    }
    
    public void setPreco(double preco){
        this.preco = preco;
    }
    
    public boolean getStatus(){
        return this.status;
    }
    
    public void setStatus(boolean status){
        this.status = status;
    }
    
    
//    Método auxiliar responsável por validar a aplicação de uma vacina.
    
    public boolean aplicaVacina() {
        if (disponivel && qtd > 0) {
            qtd--;
            if (qtd == 0) {
                disponivel = false;
            }
            return true;
        }
        return false;
    }

    public Enfermeiro getEnfermeiroAssociado() {
        return enfermeiroAssociado;
    }

    public void setEnfermeiroAssociado(Enfermeiro enfermeiroAssociado) {
        this.enfermeiroAssociado = enfermeiroAssociado;
    }

    public Paciente getPacienteAssociado() {
        return pacienteAssociado;
    }

    public void setPacienteAssociado(Paciente pacienteAssociado) {
        this.pacienteAssociado = pacienteAssociado;
    }
    
    public String getCpfPacienteAssociado() {
        return this.pacienteAssociado.getCpf();
    }
    
    public String getCpfEnfermeiroAssociado() {
        return this.getEnfermeiroAssociado().getCpf();
    }
    
}