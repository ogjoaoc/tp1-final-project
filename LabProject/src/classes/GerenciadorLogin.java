package classes;
import interfaces.UserLogado;
import java.time.LocalDateTime;

public class GerenciadorLogin {
    private static GerenciadorLogin instance;
    private UserLogado userLogado;
    private LocalDateTime dataHoraLogin;

    private GerenciadorLogin() {
        this.userLogado = null;
    }

    // Instância única pro programa todo.
    public static synchronized GerenciadorLogin getInstance() {
        if (instance == null) {
            instance = new GerenciadorLogin();
        }
        return instance;
    }

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
