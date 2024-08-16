package database;

import classes.Atendente;
import classes.Enfermeiro;
import classes.Funcionario;
import classes.Paciente;
import classes.Pessoa;

import java.io.*;
import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import java.util.ArrayList;
import java.nio.file.Paths;

public class BancoDeDados {
    private String filePathFuncionarios;
    private String filePathEnfermeiro;
    private String filePathAtendente;
    private String filePathPaciente;
    private ArrayList<Enfermeiro> enfermeiros;
    private ArrayList<Atendente> atendentes;
    private ArrayList<Paciente> pacientes;
    private ArrayList<Funcionario> funcionarios;

    public BancoDeDados() {
        String auxDir = System.getProperty("user.dir");
        
        this.filePathEnfermeiro = Paths.get(auxDir, "src", "database", "dadosEnfermeiro.csv").toString();
        this.filePathAtendente = Paths.get(auxDir, "src", "database", "dadosAtendente.csv").toString();
        this.filePathPaciente = Paths.get(auxDir, "src", "database", "dadosPaciente.csv").toString();
        
        
        /*this.filePathEnfermeiro = auxDir + "\\src\\database\\dadosEnfermeiro.csv";
        this.filePathEnfermeiro = auxDir + "//src//database//dadosEnfermeiro.csv";
        this.filePathAtendente = auxDir + "\\src\\database\\dadosAtendente.csv";
        this.filePathAtendente = auxDir + "//src//database//dadosAtendente.csv";
        this.filePathPaciente = auxDir + "\\src\\database\\dadosPaciente.csv";
        this.filePathPaciente = auxDir + "//src//database//dadosPaciente.csv";*/
        
        this.enfermeiros = new ArrayList<>();
        this.atendentes = new ArrayList<>();
        this.pacientes = new ArrayList<>();
        this.funcionarios = new ArrayList<>();
    }

    public void lerArquivo(String tipo) {
        String filePath = "";
        switch (tipo.toLowerCase()) {
            case "enfermeiro":
                filePath = filePathEnfermeiro;
                break;
            case "atendente":
                filePath = filePathAtendente;
                break;
            case "paciente":
                filePath = filePathPaciente;
                break;
        }
        
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(",");
                switch (tipo.toLowerCase()) {
                    case "enfermeiro":
                        if (dados.length == 8) { // Enfermeiro
                            String nome = dados[0];
                            String cpf = dados[1];
                            String sexo = dados[2];
                            String dataNascimento = dados[3];
                            String email = dados[4];
                            String senha = dados[5];
                            String salario = dados[6];
                            boolean disponivel = Boolean.parseBoolean(dados[7]);
                            Enfermeiro enf = new Enfermeiro(nome, cpf, sexo, dataNascimento, email, senha, salario, disponivel);
                            enfermeiros.add(enf);
                            funcionarios.add(enf);
                        }
                        break;
                    case "atendente":
                        if (dados.length == 10) { // Atendente
                            String nome = dados[0];
                            String cpf = dados[1];
                            String sexo = dados[2];
                            String dataNascimento = dados[3];
                            String email = dados[4];
                            String senha = dados[5];
                            String salario = dados[6];
                            String turno = dados[7];
                            int credencial = Integer.parseInt(dados[8]);
                            int qtdAgendamentos = Integer.parseInt(dados[9]);
                            Atendente atend = new Atendente(nome, cpf, sexo, dataNascimento, email, senha, salario, turno, credencial, qtdAgendamentos);
                            atendentes.add(atend);
                            funcionarios.add(atend);
                        }
                        break;
                    case "paciente":
                        if (dados.length == 8) { // Paciente
                            String tipoSanguineo = dados[0];
                            String convenio = dados[1];
                            boolean preferencial = Boolean.parseBoolean(dados[3]);
                            String nome = dados[4];
                            String cpf = dados[5];
                            String sexo = dados[6];
                            String dataNascimento = dados[7];
                            String email = dados[8];
                            pacientes.add(new Paciente(tipoSanguineo, convenio, /*preferencial,*/ nome, cpf, sexo, dataNascimento, email));
                        }
                        break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void adicionarPessoa(Pessoa pessoa) {
        if (pessoa instanceof Enfermeiro) {
            String filePath = filePathEnfermeiro;
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath, true))) {
                Enfermeiro enfermeiro = (Enfermeiro) pessoa;
                StringBuilder sb = new StringBuilder();
                sb.append(enfermeiro.getNome()).append(",");
                sb.append(enfermeiro.getCpf()).append(",");
                sb.append(enfermeiro.getSexo()).append(",");
                sb.append(enfermeiro.getDataNascimento()).append(",");
                sb.append(enfermeiro.getEmail()).append(",");
                sb.append(enfermeiro.getSenha()).append(",");
                sb.append(enfermeiro.getSalario()).append(",");
                sb.append(String.valueOf(enfermeiro.isDisponivel()));
                bw.write(sb.toString());
                bw.newLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            
        } else if (pessoa instanceof Atendente) {
            String filePath = filePathAtendente;
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath, true))) {
                Atendente atendente = (Atendente) pessoa;
                StringBuilder sb = new StringBuilder();
                sb.append(atendente.getNome()).append(",");
                sb.append(atendente.getCpf()).append(",");
                sb.append(atendente.getSexo()).append(",");
                sb.append(atendente.getDataNascimento()).append(",");
                sb.append(atendente.getEmail()).append(",");
                sb.append(atendente.getSenha()).append(",");
                sb.append(atendente.getSalario()).append(",");
                sb.append(atendente.getTurno()).append(",");
                sb.append(atendente.getCredencial()).append(",");
                sb.append(atendente.getQtdAgendamentos());
                bw.write(sb.toString());
                bw.newLine();
            } catch (IOException e) {
                e.printStackTrace();
            }

        } else if (pessoa instanceof Paciente) {
            String filePath = filePathPaciente;
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath, true))) {
                Paciente paciente = (Paciente) pessoa;
                StringBuilder sb = new StringBuilder();
                sb.append(paciente.getTipoSanguineo()).append(",");
                sb.append(paciente.getConvenio()).append(",");
                //sb.append(paciente.isPreferencial()).append(",");
                sb.append(paciente.getNome()).append(",");
                sb.append(paciente.getCpf()).append(",");
                sb.append(paciente.getSexo()).append(",");
                sb.append(paciente.getDataNascimento()).append(",");
                sb.append(paciente.getEmail());
                bw.write(sb.toString());
                bw.newLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void removerPessoa(Pessoa pessoa) {
        if (pessoa instanceof Enfermeiro) {
            enfermeiros.remove((Enfermeiro)pessoa);
        } else if (pessoa instanceof Atendente) {
            atendentes.remove((Atendente)pessoa);
        } else if (pessoa instanceof Paciente) {
            pacientes.remove((Paciente)pessoa);
        }
    }

    public ArrayList<Enfermeiro> getEnfermeiros() {
        return enfermeiros;
    }

    public ArrayList<Atendente> getAtendentes() {
        return atendentes;
    }

    public ArrayList<Paciente> getPacientes() {
        return pacientes;
    }
    
    public ArrayList<Funcionario> getFuncionarios() {
        return funcionarios;
    }
    
}
