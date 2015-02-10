
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import utfpr.ct.dainf.if62c.avaliacao.Lancamento;
import utfpr.ct.dainf.if62c.avaliacao.ProcessaLancamentos;

/**
 * IF62C Fundamentos de Programação 2
 * Avaliação parcial.
 * @author 
 */
public class Avaliacao3 {
 
    public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
            Scanner sc = new Scanner(System.in);
            
            System.out.println("Digite o caminho: ");
            String path = sc.nextLine();
            ProcessaLancamentos PL;
            Integer conta = 1;
            
            if(new File(path).exists()) PL = new ProcessaLancamentos(new File(path));
            else throw new FileNotFoundException();
            
            List<Lancamento> lista = PL.getLancamentos();
            
            while(!conta.equals(0))
            {
                while(!sc.hasNextInt()) System.out.println("Por favor, informe um valor numérico");                    
                conta = sc.nextInt();
                exibeLancamentosConta(lista, conta);
            }
            
    }
    
    public static void exibeLancamentosConta(List<Lancamento> lancamentos, Integer conta) {            
            //List<Lancamento> lista = new LinkedList<>();
            boolean achou = false;
            for(Lancamento l : lancamentos)
            {
                if(l.getConta().equals(conta))
                {
                    achou = true;
                    System.out.println(l);
                    //lista.add(l);
                }
                if(!achou) System.out.println("Conta inexistente");
            }
            //if(lista.isEmpty()) return null;
            //else return lista;
    }
 
}