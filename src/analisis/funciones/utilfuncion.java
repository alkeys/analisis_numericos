package analisis.funciones;

import java.util.Arrays;
import java.util.Collections;

public class utilfuncion extends funcionpadre {
    double h = 0.001;

    public double derivada(funcionpadre f, double x) {
        return (f.f(x + h) - f.f(x)) / h;
    }

    public double ecuacionlineal2(double[] a, double[] b) {
        //esta ecuacion es de 3 valores ose ade la ecuacion ax+by=c
        //                                                  0   1  2
        return (a[2] - (a[1] / b[1]) * b[2]) / (a[0] - ((a[1] * b[0]) / b[1]));
    }

    public double[] invertirManual(double[] arreglo) {
        double temporal; // El elemento temporal del arreglo que vamos a intercambiar
        int longitudDeArreglo = arreglo.length;
        // Nota: al dividir entre 2, si es flotante, se pasa al entero anterior. P. ej.
        // 5 / 2 = 2
        for (int x = 0; x < longitudDeArreglo / 2; x++) {
            // Guardar el actual
            temporal = arreglo[x];
            // El índice de la otra mitad
            int indiceContrario = longitudDeArreglo - x - 1;
            // El valor actual es el valor contrario, el de la otra mitad
            arreglo[x] = arreglo[indiceContrario];
            // Y el de la otra mitad, es el que había en el actual originalmente
            arreglo[indiceContrario] = temporal;
        }
        return arreglo;
    }




}
