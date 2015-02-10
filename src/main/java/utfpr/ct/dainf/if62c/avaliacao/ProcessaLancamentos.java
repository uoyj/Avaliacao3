package utfpr.ct.dainf.if62c.avaliacao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * IF62C Fundamentos de Programação 2
 * Avaliação parcial.
 * @author 
 */
public class ProcessaLancamentos {
    private BufferedReader reader;

    public ProcessaLancamentos(File arquivo) throws FileNotFoundException {
        if(arquivo.isFile())
        {
            reader = new BufferedReader(new FileReader(arquivo));
        }
        else throw new FileNotFoundException();
    }

    public ProcessaLancamentos(String path) throws FileNotFoundException {
        if(new File(path).exists())
        {
            reader = new BufferedReader(new FileReader(path));
        }
        else throw new FileNotFoundException();
    }
    
    private String getNextLine() throws IOException {
        return reader.readLine();
    }
    
    private Lancamento processaLinha(String linha) throws ParseException {
        Integer conta = new Integer(linha.substring(0,6));
        Date data = new SimpleDateFormat("yyyyMMdd").parse(linha.substring(7,13));
        String desc = linha.substring(14, 73);
        Double valor = new Double(linha.substring(74,85));
        
        return new Lancamento(conta, data, desc, valor);
                
    }
    
    private Lancamento getNextLancamento() throws IOException, ParseException {
        if(this.getNextLine()!=null)
                return this.processaLinha(this.getNextLine());
        else return null;
    }
    
    public List<Lancamento> getLancamentos() throws IOException, ParseException {
        List<Lancamento> lista = new LinkedList<>();
        
        while(this.getNextLancamento()!=null)
        {
            lista.add(this.getNextLancamento());
        }
        
        return lista;
    }
    
}
