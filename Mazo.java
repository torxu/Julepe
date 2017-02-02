import java.util.*;
public class Mazo
{
    // instance variables - replace the example below with your own
    private ArrayList<Carta> mazo;

    public Mazo()
    {
        mazo = new ArrayList<Carta>();
        
        for(int palo = 0; palo < 4; palo++){            
            for(int valor = 1; valor <= 12; valor++){
                if (valor != 8 && valor != 9){
                    mazo.add(new Carta(valor, palo));
                }
            }
        }
    }
    
    public void verCartasDelMazo()
    {
        for(int i = 0; i < mazo.size(); i++){
            System.out.println(mazo.get(i));
        }
    }
    
    public void barajar()
    {
        for(int posicionActual = 0; posicionActual < mazo.size(); posicionActual++){
            Carta carta1 = mazo.get(posicionActual);
            Random rnd = new Random();
            int posicionAleatoria = rnd.nextInt(mazo.size());
            mazo.set(posicionActual, mazo.get(posicionAleatoria));
            mazo.set(posicionAleatoria, carta1);
        }
    }
    
    public Carta sacarCarta()
    {
       Carta cartaADevolver = null;
       if (mazo.size() > 0){
           cartaADevolver = mazo.remove(0);
       }
       return cartaADevolver;
       
    }
}
