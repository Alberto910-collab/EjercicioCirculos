package base;

import circulo.Circulo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ActividadCirculos {
    
    List<Circulo> circulos = new ArrayList<>();
    Scanner leerTeclado = new Scanner(System.in);

    public static void main(String[] args) {
        ActividadCirculos app = new ActividadCirculos();
        app.start();
    }
    
    public void start() {
        int respuesta = 0;
        
        generarCirculos();
        respuesta = preguntarUsuario();
        if (respuesta == 1) {
            ordenarAscendente();
        } else if (respuesta == 2) {
            ordenarDescendente();
        }
        imprimirLista();
    }
    
    //Esta función genera números aleatorios entre 0 y 1
    public double randomRadio() {
        return Math.random();
    }
    
    //Esta función crea la lista de objetos Circulo
    public void generarCirculos() {
        double radio;
        
        do{
            radio = randomRadio();
            if (radio >= 0.01) {
                circulos.add(new Circulo(radio));
            }
        } while(radio >= 0.01);
    }
    
    //Esta función se encarga de preguntar al usuario el orden que desea y verificar los posibles errores de la respuesta
    public int preguntarUsuario() {
        int respuesta = 0;
        boolean respuestaOK = false;
        
        System.out.println("¿Cómo desea ordenar la lista?");
        
        do {
            System.out.println("Pulse: 1 - Ascendente / 2 - Descendente");
            if (leerTeclado.hasNextInt()) {
                respuesta = leerTeclado.nextInt();
                if (respuesta == 1 || respuesta == 2) {
                    respuestaOK = true;
                } else {
                    System.out.println("Inserte un número válido");
                }
            } else {
                System.out.println("Por favor inserte 1 o 2");
                leerTeclado.next();
            }
        } while (!respuestaOK);
        
        return respuesta;
        
    }
    
    //Esta función se encarga de ordenar la lista de forma ascendente
    public void ordenarAscendente() {
        Collections.sort(circulos);
    }
    
    //Esta función se encarga de ordenar la lista de forma descendente
    public void ordenarDescendente() {
        Collections.sort(circulos, Collections.reverseOrder());
    }
    
    //Esta función imprime la lista en el formato definido en el método toString de la clase Circulo
    public void imprimirLista() {
        for (Circulo circulo : circulos) {
            System.out.println(circulo);
        }
    }
    
}
