import java.util.Random;
import java.util.ArrayList;

public class Juego
{
    private Jugador[] jugadores;
    private Mazo mazo;
    private Carta cartaQuePinta;
    private int paloQuePinta;
    
    public Juego(int numeroJugadores, String nombreHumano)
    {
        mazo = new Mazo();
        jugadores = new Jugador[numeroJugadores];
        
        ArrayList<String> posiblesNombres = new ArrayList<String>();
        posiblesNombres.add("Pepe");
        posiblesNombres.add("María");
        posiblesNombres.add("Juan");
        posiblesNombres.add("Luis");
        posiblesNombres.add("Marcos");
        posiblesNombres.add("Omar");
        posiblesNombres.add("Aitor");
        posiblesNombres.add("Carlos");
        
        Jugador jugador = new Jugador(nombreHumano);
        jugadores[0] = jugador;
        System.out.println("Bienvenido/a a la partida, " + nombreHumano);
        System.out.println("Estos son tus rivales: ");
        
        Random aleatorio = new Random();
        for(int i = 1; i < numeroJugadores; i++)
        {
            int posicionNombreElegido = aleatorio.nextInt(posiblesNombres.size());
            String nombreAleatorioElegido = posiblesNombres.get(posicionNombreElegido);
            posiblesNombres.remove(posicionNombreElegido);
            jugador = new Jugador(nombreAleatorioElegido);
            jugadores[i] = jugador;
            System.out.println(nombreAleatorioElegido);
        }
        
    }

    public int repartir()
    {
        mazo.barajar();
        
        Carta nuevaCarta = null;
        for (int cartaARepartir = 0; cartaARepartir < 5; cartaARepartir++)
        {
            for (int jugadorActual = 0; jugadorActual < jugadores.length; jugadorActual++)
            {
                nuevaCarta = mazo.sacarCarta();
                jugadores[jugadorActual].recibirCarta(nuevaCarta);
            }
        }
        
        paloQuePinta = nuevaCarta.getPalo();
        switch(paloQuePinta)
        {
            case 0:
            System.out.println("Pintan oros");
            break;
            case 1:
            System.out.println("Pintan copas");
            break;
            case 2:
            System.out.println("Pintan espadas");
            break;
            case 3:
            System.out.println("Pintan bastos");
            break;
        }
        jugadores[0].verCartasJugador();
        
        return paloQuePinta;
    }
    
    public void hacerTrampasYVerCartasDeJugador(String nombreJugador)
    {
        int jugadorActual = 0;
        boolean buscando = true;
        
        while (jugadorActual < jugadores.length && buscando)
        {
            if(nombreJugador.equals(jugadores[jugadorActual].getNombre()))
            {
                jugadores[jugadorActual].verCartasJugador();
                buscando = false;
            }
            jugadorActual++;
        }
    }
    
    public void verCartasJugadorHumano()
    {
        jugadores[0].verCartasJugador();
    }
}