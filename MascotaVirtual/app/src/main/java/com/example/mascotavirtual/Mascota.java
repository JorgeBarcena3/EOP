package com.example.mascotavirtual;

import java.util.Random;

//Si es null no tengo ninguna necesidad
enum Estado {
    Hambre,
    Sueño,
    Baño
}

public class Mascota {

    //Numero de posibles estados
    final int numeroEstados = 3;

    //Estado actual
    Estado estadoActual = null;

    //Cogemos un estado aleatorio
    public void cambiarEstadoAleatorio(){

        //Generamos nu numero random
        Random r = new Random();
        int necesidad = r.nextInt((this.numeroEstados - 1) + 1) + 1;

        //Determinamos la necesidad
        switch (necesidad){
            case 1:
                this.estadoActual = Estado.Hambre;
                break;
            case 2:
                this.estadoActual = Estado.Baño;
                break;
            default:
                this.estadoActual = Estado.Sueño;
                break;
        }

    }

    //Chekeamos que se satisface la necesidad
    public boolean necesidadSatisfecha(Estado _estado){
        return _estado.equals(this.estadoActual);
    }

    //Elimina todas las necesidades
    public void noTieneNecesidad(){
        this.estadoActual = null;
    }

}
