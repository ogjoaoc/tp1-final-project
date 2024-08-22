package database;
import classes.*;
import java.io.*;
import java.util.ArrayList;
import java.nio.file.Paths;
import java.util.HashMap;

public class BancoDeDados {
    
    private final ArrayList<Enfermeiro> enfermeiros;
    private final ArrayList<Atendente> atendentes;
    private final ArrayList<Paciente> pacientes;
    private final ArrayList<Funcionario> funcionarios;
    private final ArrayList<Vacina> vacinas;
    private final HashMap<String, String> filePathHash; 

    public BancoDeDados() {
        
        this.enfermeiros = new ArrayList<>();
        this.atendentes = new ArrayList<>();
        this.pacientes = new ArrayList<>();
        this.funcionarios = new ArrayList<>();
        this.vacinas = new ArrayList<>();
        this.filePathHash = new HashMap<>();
        
        filePathHash.put("enfermeiro", Paths.get(System.getProperty("user.dir"), "src", "database", "dadosEnfermeiro.csv").toString());
        filePathHash.put("atendente", Paths.get(System.getProperty("user.dir"), "src", "database", "dadosAtendente.csv").toString());
        filePathHash.put("paciente", Paths.get(System.getProperty("user.dir"), "src", "database", "dadosPaciente.csv").toString());
        filePathHash.put("vacina", Paths.get(System.getProperty("user.dir"),"src", "database","dadosVacinas.csv").toString());
        
    }
    
    public StringBuilder escreverDadosBase(Vacina vacina){
        StringBuilder sb = new StringBuilder(); sb.append(vacina.getTipoVacina()).append(","); sb.append(vacina.getValidade()).append(",");
        sb.append(String.valueOf(vacina.isDisponivel())).append(","); sb.append(vacina.getQtd()).append(","); sb.append(vacina.getPreco()).append(",");
        return sb;
    }

    public StringBuilder escreverDadosBase(Pessoa pessoa) {
        
        StringBuilder sb = new StringBuilder(); sb.append(pessoa.getNome()).append(","); sb.append(pessoa.getCpf()).append(","); 
        sb.append(pessoa.getSexo()).append(","); sb.append(pessoa.getDataNascimento()).append(","); sb.append(pessoa.getEmail()).append(",");
        
        if(pessoa instanceof Enfermeiro) {
            sb.append(((Enfermeiro) pessoa).getSenha()).append(",");
        } else if(pessoa instanceof Atendente) {
            sb.append(((Atendente) pessoa).getSenha()).append(",");
        }
        
        return sb;
        
    }
    
    public void ApagarLinha() {
        // Implementar em breve...
    }
    
    public void lerArquivo(String tipo) {
        
        try (BufferedReader br = new BufferedReader(new FileReader(filePathHash.get(tipo)))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(",");
                switch (tipo) {
                    case "vacina" -> {
                        Vacina vac = new Vacina(dados[0], dados[1], Boolean.parseBoolean(dados[2]), Integer.parseInt(dados[3]), Double.parseDouble(dados[4]));
                        vacinas.add(vac);
                    }

                    case "enfermeiro" -> {
                        Enfermeiro enf = new Enfermeiro(dados[0], dados[1], dados[2], dados[3], dados[4], dados[5], dados[6], Boolean.parseBoolean(dados[7]));
                        enfermeiros.add(enf);
                        funcionarios.add(enf);
                    }
                    case "atendente" -> {
                        Atendente atend = new Atendente(dados[0], dados[1], dados[2], dados[3], dados[4], dados[5], dados[6], dados[7], Integer.parseInt(dados[8]), Integer.parseInt(dados[9]));
                        atendentes.add(atend);
                        funcionarios.add(atend);
                    }
                    case "paciente" ->{ //boolean preferencial = Boolean.parseBoolean(dados[3]);
                        // Paciente(String nome, String cpf, String sexo, String dataNascimento, String email, String tipoSanguineo, String convenio /*boolean preferencial,*/)
                        // A+,,true,ana,132.424.234-24,Feminino,11/23/4123,fajslfjalks@gmail
                        pacientes.add(new Paciente(dados[3], dados[4], dados[5], dados[6], dados[7], dados[0], dados[1] /*preferencial,*/));
                    }
                }
            }
        } catch (IOException e) {
        }
        
    }
    
    public void adicionarVacina(Vacina vacina) throws IOException{
        String filePath = filePathHash.get("vacina");
        
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath, true))) {
            
                StringBuilder sb = escreverDadosBase(vacina);
                bw.write(sb.toString()); bw.newLine(); vacinas.add(vacina); // Adiciona a vacina ao arquivo e à lista em memória
                
        } catch (IOException e) {}
        
    }

    public void adicionarPessoa(Pessoa pessoa) {
        
        String filePath;
        
        if (pessoa instanceof Enfermeiro) {
            
            filePath = filePathHash.get("enfermeiro");
            Enfermeiro enfermeiro = (Enfermeiro) pessoa;
            
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath, true))) {
            
                StringBuilder sb = escreverDadosBase(pessoa);
                sb.append(enfermeiro.getSalario()).append(","); sb.append(String.valueOf(enfermeiro.isDisponivel())); 
                bw.write(sb.toString()); bw.newLine();
            
            } catch (IOException e) {
            }
            
        } else if (pessoa instanceof Atendente) {
            
            filePath = filePathHash.get("atendente");
            Atendente atendente = (Atendente) pessoa;
            
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath, true))) {
                
                StringBuilder sb = escreverDadosBase(pessoa);
                sb.append(atendente.getSalario()).append(","); sb.append(atendente.getTurno()).append(",");
                sb.append(atendente.getCredencial()).append(","); sb.append(String.valueOf(atendente.getQtdAgendamentos()));
                bw.write(sb.toString()); bw.newLine();
            
            } catch (IOException e) {
            }

        } else if (pessoa instanceof Paciente) {
            
            filePath = filePathHash.get("paciente");
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath, true))) {
                
                Paciente paciente = (Paciente) pessoa;
                StringBuilder sb = escreverDadosBase(pessoa);
                sb.append(paciente.getTipoSanguineo()).append(","); sb.append(paciente.getConvenio());
                
                bw.write(sb.toString()); bw.newLine();
            } catch (IOException e) {
            }
        }
    }

    public void removerVacina(String tipoVacina){
       
        vacinas.removeIf(v -> v.getTipoVacina().equals(tipoVacina));
        reescreverArquivo("vacina");
        
    }
    
    public void removerPessoa(String cargo, String cpf) {
        
        if (cargo.equals("enfermeiro")) {
            enfermeiros.removeIf(e -> e.getCpf().equals(cpf));
            reescreverArquivo("enfermeiro");
        } 
        
        else if (cargo.equals("atendente")) {
            atendentes.removeIf(a -> a.getCpf().equals(cpf));
            reescreverArquivo("atendente");
        }
        
        else if (cargo.equals("paciente")) {
            pacientes.removeIf(p -> p.getCpf().equals(cpf));
            reescreverArquivo("paciente");
        }
        
        funcionarios.removeIf(f -> f.getCpf().equals(cpf));
        
    }
    
    public void atualizarVacina(Vacina vacina) {
        String tipoVacina = vacina.getTipoVacina();

        // Atualiza a vacina na lista em memória
        for (int i = 0; i < vacinas.size(); i++) {
            if (vacinas.get(i).getTipoVacina().equals(tipoVacina)) {
                vacinas.set(i, vacina);
                break; // Opcional: Se houver várias vacinas com o mesmo tipo, você pode remover isso.
            }
        }
        
        // Reescreve o arquivo atualizado
        reescreverArquivo("vacina");
    }

    public void reescreverArquivo(String nomeArquivo){
        String filePath = filePathHash.get(nomeArquivo);
        
        if(nomeArquivo.equals("vacina")){
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
                for (Vacina v : vacinas) {
                    StringBuilder sb = escreverDadosBase(v);
                    bw.write(sb.toString());
                    bw.newLine();
                }
            } catch (IOException e) {}
        } 
        
        else if(nomeArquivo.equals("enfermeiro")){
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
                for (Enfermeiro e : enfermeiros) {
                    StringBuilder sb = escreverDadosBase(e);
                    bw.write(sb.toString());
                    bw.newLine();
                }
            } catch (IOException e) {}
        }
        
        else if(nomeArquivo.equals("atendente")){
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
                for (Atendente a : atendentes) {
                    StringBuilder sb = escreverDadosBase(a);
                    bw.write(sb.toString());
                    bw.newLine();
                }
            } catch (IOException e) {}
        }
        
        else if(nomeArquivo.equals("paciente")){
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
                for (Paciente p : pacientes) {
                    StringBuilder sb = escreverDadosBase(p);
                    bw.write(sb.toString());
                    bw.newLine();
                }
            } catch (IOException e) {}
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
    
    public ArrayList<Vacina> getVacinas(){
        return vacinas;
    }
    
}
