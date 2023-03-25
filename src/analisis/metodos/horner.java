package analisis.metodos;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * by aviles moran
 */
/**
 * metodo que tiene un metodo para mostrar datos xd
 */
public class horner {
    private List<Double> baseData = new ArrayList<>();
    private List<Double> R = new ArrayList<>();
    private List<Double> S = new ArrayList<>();
    private List<Double> x = new ArrayList<>();
    private int contItRec = 0, contDehoner = 0;
    private double  error;


    /**
     * @param datos seria la secuencia de
     *              a ,b , c,d etc de las ecuaciones polinomicas
     */
    public void horner(List<Double> datos, double x1, double Es) {
        double aux, aux2 = 0;
        List<Double> listaDatos = new ArrayList<>();
        aux = datos.get(0) * x1;
        listaDatos.add(datos.get(0));
        if (contDehoner == 0 && contItRec == 0) {
            baseData = datos;
        }
        for (int i = 1; i < datos.size() - 1; i++) {
            aux2 = aux + datos.get(i);
            aux = aux2 * x1;
            listaDatos.add(aux2);
        }
        if (contItRec == 0) {
            R.add(aux + datos.get(datos.size() - 1));
            contItRec++;
            horner(listaDatos, x1, Es);
        } else {
            contDehoner++;
            contItRec = 0;
            S.add(aux + datos.get(datos.size() - 1));
            x.add(x1);
            x1 = x1 - R.get(contDehoner - 1) / S.get(contDehoner - 1);
            if (contDehoner > 1) {
                error = Math.abs((x.get(contDehoner - 1) - x.get(contDehoner - 2)) / x.get(contDehoner - 1)) * 100;
                if (error < Es) {
                    //calculo de error y se detiene la recursividad
                    return;
                } else {
                    horner(baseData, x1, Es);//llama a la funcion con los datos antiguos para reaser el siclo de nuevo
                }
            } else {
                horner(listaDatos, x1, Es);
            }
        }
    }

    public void mostrarDatoshorner() {
        JOptionPane.showMessageDialog(null, "datos de las cifras del polinomio\n"
                        + baseData
                        + "\nCantidad de iteraciones " + (contDehoner)
                        + "\nR=" + R
                        + "\nS ="+ S
                        +"\nX1+1 ="+x
                        +"\nEs ="+error
                        +"\nx1+1 mas sercano es "+x.get(x.size()-1)
                , "Horner", JOptionPane.WARNING_MESSAGE);
    }




}



