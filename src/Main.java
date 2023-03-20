import java.util.Map;

import analisis.metodos.*;
import analisis.funciones.*;

/**
 *  ▄▀▀█▄▄   ▄▀▀▄ ▀▀▄      ▄▀▀█▄   ▄▀▀▄ ▄▀▀▄  ▄▀▀█▀▄   ▄▀▀▀▀▄     ▄▀▀█▄▄▄▄  ▄▀▀▀▀▄
 ▐ ▄▀   █ █   ▀▄ ▄▀     ▐ ▄▀ ▀▄ █   █    █ █   █  █ █    █     ▐  ▄▀   ▐ █ █   ▐
 █▄▄▄▀  ▐     █         █▄▄▄█ ▐  █    █  ▐   █  ▐ ▐    █       █▄▄▄▄▄     ▀▄
 █   █        █        ▄▀   █    █   ▄▀      █        █        █    ▌  ▀▄   █
 ▄▀▄▄▄▀      ▄▀        █   ▄▀      ▀▄▀     ▄▀▀▀▀▀▄   ▄▀▄▄▄▄▄▄▀ ▄▀▄▄▄▄    █▀▀▀
 █    ▐       █         ▐   ▐              █       █  █         █    ▐    ▐
 ▐            ▐                            ▐       ▐  ▐         ▐
 ▄▀▀▄ ▄▀▄  ▄▀▀▀▀▄   ▄▀▀▄▀▀▀▄  ▄▀▀█▄   ▄▀▀▄ ▀▄
 █  █ ▀  █ █      █ █   █   █ ▐ ▄▀ ▀▄ █  █ █ █
 ▐  █    █ █      █ ▐  █▀▀█▀    █▄▄▄█ ▐  █  ▀█
 █    █  ▀▄    ▄▀  ▄▀    █   ▄▀   █   █   █
 ▄▀   ▄▀     ▀▀▀▀   █     █   █   ▄▀  ▄▀   █
 █    █             ▐     ▐   ▐   ▐   █    ▐
 ▐    ▐                               ▐
 */

public class Main {
    public static void main(String[] args) {
        Map datosbiseccion, datosfa;
        metodoimprimir imprimir = new metodoimprimir();
        RAICES_DE_POLINOMIOS ra=new RAICES_DE_POLINOMIOS();
      double datos[]=ra.ferrari(0,-2,8,-3);
        System.out.println(datos[0]);

    }


}