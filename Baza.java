import java.util.*;
public class Baza
{
    private int numeroJugadoresQueTiran;
    private int paloQuePinta;
    private ArrayList<Carta> baza;
    
    public Baza(int numeroJugadoresQueTiran, int paloQuePinta)
    {
        numeroJugadoresQueTiran = 0;
        baza = new ArrayList<Carta>();
    }
    
    public void addCarta(Carta cartaTirada, String nombreJugador)
    {
        baza.add(cartaTirada);
    }
    
    public int getPaloPrimeraCartaDeLaBaza()
    {
        int primeraBaza = -1;        
        if(baza.size() > 0){
           primeraBaza = baza.get(0).getPalo();
           paloQuePinta = primeraBaza;
        }
        return primeraBaza;
    }
    
    public Carta cartaQueVaGanandoLaBaza()
    {
        Carta cartaGanando = null;
        int comparada = 1;
        if(!baza.isEmpty()){
            cartaGanando = baza.get(comparada);
            for(Carta carta : baza){
                if(carta.ganaA(cartaGanando, paloQuePinta)){
                        cartaGanando = carta;
                        comparada++;
                }
            }
        }
        return cartaGanando;
    }
    
    
}
