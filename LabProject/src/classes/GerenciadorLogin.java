// Classe: GerenciadorLogin
// Classe responsável pela gestão do login do usuário no sistema.
// Implementa o padrão Singleton para garantir que exista apenas uma instância de login durante a execução do programa.
// Esta classe armazena informações do usuário logado e a data/hora do login.
// Facilita o acesso global à instância do usuário logado, e também permite fazer logout.


package classes;
import interfaces.UserLogado;
import java.time.LocalDateTime;

public class GerenciadorLogin {
    
//     Atributos:
//     - Instância única da classe GerenciadorLogin.
//     - Objeto do tipo UserLogado, que representa o usuário autenticado.
//     - Data e hora em que o login foi realizado.
    
    private static GerenciadorLogin instance;
    private UserLogado userLogado;
    private LocalDateTime dataHoraLogin;

    private GerenciadorLogin() {
        this.userLogado = null;
    }

//     Instância única pro programa todo.
//     Método estático pertencente a classe, e não somente a uma instância dela.
//     synchronized garante a execução única em um sistema multi-thread.

    public static synchronized GerenciadorLogin getInstance() {
        if (instance == null) {
            instance = new GerenciadorLogin();
        }
        return instance;
    }
    
//   Getters e Setters
    
    public void setUserLogado(UserLogado userLogado) {
        this.userLogado = userLogado;
        this.dataHoraLogin = LocalDateTime.now(); 
    }

    public UserLogado getFuncionario() {
        return this.userLogado;
    }

    public boolean isUserLogado() {
        return this.userLogado != null;
    }

    public LocalDateTime getDataHoraLogin() {
        return this.dataHoraLogin;
    }

    public void logout() {
        this.userLogado = null;
        this.dataHoraLogin = null; 
    }
}
