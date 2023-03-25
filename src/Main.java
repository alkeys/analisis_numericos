import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import analisis.funciones.funcionMuller;
import analisis.funciones.funcionesexponecial1;
import analisis.metodos.*;

/**
 * ▄▀▀█▄▄   ▄▀▀▄ ▀▀▄      ▄▀▀█▄   ▄▀▀▄ ▄▀▀▄  ▄▀▀█▀▄   ▄▀▀▀▀▄     ▄▀▀█▄▄▄▄  ▄▀▀▀▀▄
 * ▐ ▄▀   █ █   ▀▄ ▄▀     ▐ ▄▀ ▀▄ █   █    █ █   █  █ █    █     ▐  ▄▀   ▐ █ █   ▐
 * █▄▄▄▀  ▐     █         █▄▄▄█ ▐  █    █  ▐   █  ▐ ▐    █       █▄▄▄▄▄     ▀▄
 * █   █        █        ▄▀   █    █   ▄▀      █        █        █    ▌  ▀▄   █
 * ▄▀▄▄▄▀      ▄▀        █   ▄▀      ▀▄▀     ▄▀▀▀▀▀▄   ▄▀▄▄▄▄▄▄▀ ▄▀▄▄▄▄    █▀▀▀
 * █    ▐       █         ▐   ▐              █       █  █         █    ▐    ▐
 * ▐            ▐                            ▐       ▐  ▐         ▐
 * ▄▀▀▄ ▄▀▄  ▄▀▀▀▀▄   ▄▀▀▄▀▀▀▄  ▄▀▀█▄   ▄▀▀▄ ▀▄
 * █  █ ▀  █ █      █ █   █   █ ▐ ▄▀ ▀▄ █  █ █ █
 * ▐  █    █ █      █ ▐  █▀▀█▀    █▄▄▄█ ▐  █  ▀█
 * █    █  ▀▄    ▄▀  ▄▀    █   ▄▀   █   █   █
 * ▄▀   ▄▀     ▀▀▀▀   █     █   █   ▄▀  ▄▀   █
 * █    █             ▐     ▐   ▐   ▐   █    ▐
 * ▐    ▐                               ▐
 */

public class Main {
    public static void main(String[] args) {
        Map datosbiseccion, datosfa;
        metodoimprimir imprimir = new metodoimprimir();
        horner xd = new horner();
        funcionMuller muller = new funcionMuller();
        muller funcionMuller = new muller();
        Map<String, Double> mapa;
        //funcion por parametros
        BAIRSTOW bairstow = new BAIRSTOW();
        double datoss[] = new double[5];
        datoss[4] = 1;
        datoss[3] = 1;
        datoss[2] =-7;
        datoss[1] = -1;
        datoss[0] = 6;

         bairstow.bairstow(datoss,1.5,1.5,0.05);



      /*
        funcionesexponecial1 exp = new funcionesexponecial1();
        funcionMuller.muller(4.5, 5, 5.5, muller, 0.05);
        imprimir.imprimirTabla4(funcionMuller.getDatos(),"muller");

         funcionpuntofijo funcionpunto = new funcionpuntofijo();
        mapa = funcionpunto.metodopuntofijo(exp, 1, 0.05);
        imprimir.imprimirTabla2(mapa, "punto fijo");

        funcionesexponecial1 dd = new funcionesexponecial1();
        falsaposicion falsa = new falsaposicion();
        mapa = falsa.metodofasaposi(dd, 1, 2, 0.05);
        imprimir.imprimirTabla1(mapa, "falsa");
        List<Double> dat = new ArrayList<>();
        dat.add(8.0);
        dat.add(5.0);
        dat.add(-4.0);
        xd.horner(dat, -2, 0.05);
        xd.mostrarDatoshorner();*/


    }
}