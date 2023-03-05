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
        metodobiseccion metodobiseccionObj = new metodobiseccion();
        falsaposicion falsaPosicion = new falsaposicion();
        funcionesexponecial1 funcionesObj = new funcionesexponecial1();
        funcionpuntofijo funcionpuntofijoobj=new funcionpuntofijo();
        NewtonRaphson newton=new NewtonRaphson();
        secantemetodo secante=new secantemetodo();
        datosfa=secante.metodobiseccion(funcionesObj,0,1,0.005);
        imprimir.imprimirTabla1(datosfa,"secante");


        //datosfa=newton.metodonewton(funcionesObj,0,0.05);
        //imprimir.imprimirTabla3(datosfa,"newton");
        //datosbiseccion=funcionpuntofijoobj.metodopuntofijo(funcionesObj,4,0.05);
        //imprimir.imprimirTabla2(datosbiseccion,"punto fijo");
        //datosbiseccion= metodobiseccionObj.metodobiseccion(funcionesObj, 0, 1, 0.05);
        //datosfa = falsaPosicion.metodofasaposi(funcionesObj, 0, 1, 0.05);
        //imprimir.imprimirTabla1(datosbiseccion, "biseccion");
        //imprimir.imprimirTabla1(datosfa, "falsa posicion");
    }


}