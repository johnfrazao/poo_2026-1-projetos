import br.ufpb.john.Filme;
import br.ufpb.john.SistemaFilmes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

public class SistemaFIlmesTest {
    private SistemaFilmes sistema;

    @BeforeEach
    public void setUp() {
        sistema = new SistemaFilmes();
    }

    @Test
    public void testeCadastroPesquisaERemocaoDeFilme() throws Exception {

        // 1. Cadastro
        sistema.cadastrarFilme("Matrix", "Ficção", 1999);
        sistema.cadastrarFilme("Interestelar", "Ficção", 2014);

        // 2. Pesquisa por gênero
        Collection<Filme> filmesFiccao = sistema.pesquisarPorGenero("Ficção");

        assertEquals(2, filmesFiccao.size());

        boolean encontrouMatrix = filmesFiccao.stream()
                .anyMatch(f -> f.getNome().equals("Matrix"));

        assertTrue(encontrouMatrix);

        // 3. Remoção
        sistema.removerFilme("Matrix");

        Collection<Filme> filmesAposRemocao = sistema.pesquisarPorGenero("Ficção");

        assertEquals(1, filmesAposRemocao.size());

        boolean aindaExisteMatrix = filmesAposRemocao.stream()
                .anyMatch(f -> f.getNome().equals("Matrix"));

        assertFalse(aindaExisteMatrix);
    }
}

