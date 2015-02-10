package utfpr.ct.dainf.if62c.avaliacao;

import java.util.Comparator;

/**
 * IF62C Fundamentos de Programação 2
 * Avaliação parcial.
 * @author 
 */
public class LancamentoComparator implements Comparator<Lancamento>{

    @Override
    public int compare(Lancamento o1, Lancamento o2) {
        if(o1.getConta() > o2.getConta()) return 1;
        else if(o1.getConta() < o2.getConta()) return -1;
        else if(o1.getConta().equals(o2.getConta()))
        {
            if(o2.getData().after(o1.getData()))return 1;
            else if(o2.getData().before(o1.getData())) return -1;
            else return 0;
        }
        return 0;            
    }
    
}
