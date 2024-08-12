package database;

import classes.Atendente;
import classes.Enfermeiro;
import classes.Paciente;
import classes.Pessoa;

import java.io.*;
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
                        if (dados.length == 7) { // Enfermeiro
                            boolean disponivel = Boolean.parseBoolean(dados[0]);
                            String nome = dados[1];
                            String cpf = dados[2];
                            String sexo = dados[3];
                            String dataNascimento = dados[4];
                            String email = dados[5];
                            String senha = dados[6];
                            enfermeiros.add(new Enfermeiro(disponivel, nome, cpf, sexo, dataNascimento, email, senha));
                        }
                        break;
                    case "atendente":
                        if (dados.length == 9) { // Atendente
                            String turno = dados[0];
                            int credencial = Integer.parseInt(dados[1]);
                            int qtdAgendamentos = Integer.parseInt(dados[2]);
                            String nome = dados[3];
                            String cpf = dados[4];
                            String sexo = dados[5];
                            String dataNascimento = dados[6];
                            String email = dados[7];
                            String senha = dados[8];
                            atendentes.add(new Atendente(turno, credencial, qtdAgendamentos, nome, cpf, sexo, dataNascimento, email, senha));
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
                            pacientes.add(new Paciente(tipoSanguineo, convenio, preferencial, nome, cpf, sexo, dataNascimento, email));
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
                sb.append(enfermeiro.isDisponivel()).append(",");
                sb.append(enfermeiro.getNome()).append(",");
                sb.append(enfermeiro.getCpf()).append(",");
                sb.append(enfermeiro.getSexo()).append(",");
                sb.append(enfermeiro.getDataNascimento()).append(",");
                sb.append(enfermeiro.getEmail()).append(",");
                sb.append(enfermeiro.getSenha());
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
                sb.append(atendente.getTurno()).append(",");
                sb.append(atendente.getCredencial()).append(",");
                sb.append(atendente.getQtdAgendamentos()).append(",");
                sb.append(atendente.getNome()).append(",");
                sb.append(atendente.getCpf()).append(",");
                sb.append(atendente.getSexo()).append(",");
                sb.append(atendente.getDataNascimento()).append(",");
                sb.append(atendente.getEmail()).append(",");
                sb.append(atendente.getSenha());
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
                sb.append(paciente.isPreferencial()).append(",");
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
            enfermeiros.remove(pessoa);
        } else if (pessoa instanceof Atendente) {
            atendentes.remove(pessoa);
        } else if (pessoa instanceof Paciente) {
            pacientes.remove(pessoa);
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
}
