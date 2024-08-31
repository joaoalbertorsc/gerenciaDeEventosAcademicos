import com.gerenciadorDeEventosAcademicos.model.*;
import com.gerenciadorDeEventosAcademicos.view.MainView;

public class Main {
    public static void main(String[] args) {
        Model model = new Model(); // Primeiro instancia-se o modelo
        MainView view = new MainView(); // Depois cria-se a primeira view
        view.initMainView(model); // Por fim, inicializa a view passando o modelo
    }
}
