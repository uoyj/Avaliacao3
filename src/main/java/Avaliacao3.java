
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import utfpr.ct.dainf.if62c.avaliacao.Lancamento;

/**
 * IF62C Fundamentos de Programação 2
 * Avaliação parcial.
 * @author 
 */
public class Avaliacao3 {
 
    public static void main(String[] args) throws FileNotFoundException, IOException {

    }
    
    public static void exibeLancamentosConta(List<Lancamento> lancamentos, Integer conta) {            
            for(Lancamento l : lancamentos)
            {
                if(l.getConta().equals(conta))
                    System.out.println(l.toString());
            }

    }
 
}