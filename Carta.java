public class Carta
{
    // valor de la carta de 1 a 7 y de 10 a 12
    private int valorCarta;
    // valor del palo de; 0 es oros, 1 es copas, 2 es espadas, 3 es bastos
    private int paloCarta;

    public Carta(int valorCarta, int paloCarta)
    {
        this.valorCarta = valorCarta;
        this.paloCarta = paloCarta;
    }

    public int getValor()
    {
        return valorCarta;
    }

    public int getPalo()
    {
        return paloCarta;
    }

    public String toString()
    {
        String palo = "";
        String valor = Integer.toString(valorCarta);

        String carta = "";

        switch (paloCarta){
            case 0:
            palo = "oros";
            break;
            case 1:
            palo = "copas";
            break;
            case 2:
            palo = "espadas";
            break;
            case 3:
            palo = "bastos";
            break;
        }
        switch (valorCarta){
            case 1:
            valor = "as";
            break;
            case 10:
            valor = "sota";
            break;
            case 11:
            valor = "caballo";
            break;
            case 12:
            valor = "rey";
            break;
        }
        carta = valor + " de " + palo;
        return carta;
    }

    public boolean ganaA(Carta cartaAComparar, int paloQuePinta)
    {
        boolean gana = false;

        if(paloCarta == cartaAComparar.getPalo()){
           if(getPosicionGanadora() > cartaAComparar.getPosicionGanadora()){
               gana = true;
            }
        }
        else{
            if(cartaAComparar.getPalo() != paloQuePinta){
                gana = true;
            }
        }

        return gana;
    }
    
    public int getPosicionGanadora()
    {
        int posicion = valorCarta;
        if(valorCarta == 3){
            posicion = 13;
        }
        else if(valorCarta == 1){
            posicion = 14;
        }
        
        return posicion;
    }
}
