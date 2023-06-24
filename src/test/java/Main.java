import com.gerenciadorDeEventosAcademicos.model.*;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Organizador organizador01 = new Organizador(01, "Joao", "asd@gmail.com", "12345");
        Palestrante palestrante01 = new Palestrante(01, "Anderson", "aaa@gmail.com", "112233", new ArrayList<Atividade>());
        Participante participante01 = new Participante(01, "Afonso", "afo@gmail.com", "3333", new ArrayList<Atividade>());

        Endereco endereco01 = new Endereco("Tabeliao Santiago", "1234", "Russas", "Proximo a lagoa da caicara");
        Local local01 = new Local("Sala01", "Bloco 01", 30, "Próximo a sala dos professores");


        organizador01.criarEvento(01, "Evento01", "Primeiro Evento", endereco01, organizador01, "01/07/2023", "03/07/2023",
                "14:00", new ArrayList<Atividade>(), new ArrayList<Participante>(), new ArrayList<Palestrante>());
        organizador01.criarAtividade(01, "Atividade01", "Primeira Atividade", local01, palestrante01, "01/07/2023", "01/07/2023",
                "14:30", "15:30", new ArrayList<Participante>());

        organizador01.getEventos().get(0).addAtividade(organizador01.getAtividades().get(0));
        System.out.println(organizador01.getEventos());

    }
}
