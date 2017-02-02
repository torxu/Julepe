import java.util.*;
public class Jugador
{
    private Carta[] cartasJugador;
    private String nombreJugador;
    private int numeroDeCartasEnMano;

    public Jugador(String nombre)
    {
        cartasJugador = new Carta[5];
        nombreJugador = nombre;
        numeroDeCartasEnMano = 0;
    }
        
    public void recibirCarta(Carta cartaRecibida)
    {
        if (numeroDeCartasEnMano < 5){
            cartasJugador[numeroDeCartasEnMano] = cartaRecibida;
            numeroDeCartasEnMano++;
        }
    }
    
    public String getNombre()
    {
        return nombreJugador;
    }
    
    public void verCartasJugador()
    {
        for(Carta cartaActual : cartasJugador)
        {
            if(cartaActual != null){
                System.out.println(cartaActual);
            }
        }
    }
    
    public Carta tirarCarta(String nombreCarta)
    {
        Carta cartaTirada = null;
        
        if(numeroDeCartasEnMano > 0){
            int cartaActual = 0;
            boolean buscando = true;
            while(cartaActual < cartasJugador.length && buscando){
                if(cartasJugador[cartaActual] != null){
                    if(nombreCarta.equals(cartasJugador[cartaActual].toString())){
                        buscando = false;
                        cartaTirada = cartasJugador[cartaActual];
                        cartasJugador[cartaActual] = null;
                        numeroDeCartasEnMano--;
                        System.out.println(nombreJugador + " ha tirado " + cartaTirada);
                    }
                }
                cartaActual++;
            }
        }
        
        return cartaTirada;
    }
    
    public Carta tirarCartaAleatoria()
    {
        Carta cartaTirada = null;
        
        if(numeroDeCartasEnMano > 0){
            Random aleatorio = new Random();
            boolean jugadorTiraCarta = false;
            while(jugadorTiraCarta == false){
                int posicionAleatoria = aleatorio.nextInt(5);
                if(cartasJugador[posicionAleatoria] != null){
                    cartaTirada = cartasJugador[posicionAleatoria];
                    cartasJugador[posicionAleatoria] = null;
                    numeroDeCartasEnMano--;
                    System.out.println(nombreJugador + " ha tirado " + cartaTirada);
                    jugadorTiraCarta = true;
                }
            }
        }
        return cartaTirada;
    } 
}