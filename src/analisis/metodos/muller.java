package analisis.metodos;

import java.util.HashMap;
import java.util.Map;

import analisis.funciones.funcionpadre;


public class muller extends funcionpadre {
    private Map<String, Double> datos = new HashMap<>();
    private int  cont=1;

    public void muller(double x0, double x1, double x2, funcionpadre f, double Es) {
        double fx0, fx1, fx2, h0, h1, alfa0, alfa1, a, b, c, D, Xr, Ea;
        fx0 = f.f(x0);
        fx1 = f.f(x1);
        fx2 = f.f(x2);
        h0 = x1 - x0;
        h1 = x2 - x1;
        alfa0 = (fx1 - fx0) / h0;
        alfa1 = (fx2 - fx1) / h1;
        a = (alfa1 - alfa0) / (h1 + h0);
        b = a * h1 + alfa1;
        c = fx2;
        D = Math.sqrt((b * b) - (4 * a * c));
        datos.put("x0" + cont, x0);
        datos.put("x1" + cont, x1);
        datos.put("x2" + cont, x2);
        if ((b + D) > (b - D)) {//se quito el valor abs se supone que no es eso xd
            Xr = x2 + ((-2 * c) / ((b * b) + D));
        } else {
            Xr = x2 + ((-2 * c) / ((b * b) - D));
        }
        Ea = Math.abs((Xr - x2) / Xr) * 100;
        datos.put("xr"+cont,Xr);
        datos.put("h0" + cont, h0);
        datos.put("h1" + cont, h1);
        datos.put("alfa0" + cont, alfa0);
        datos.put("alfa1" + cont, alfa1);
        datos.put("f(x0)" + cont, fx0);
        datos.put("f(x1)" + cont, fx1);
        datos.put("f(x2)" + cont, fx2);
        datos.put("a"+cont,a);
        datos.put("B"+cont,b);
        datos.put("c"+cont,c);
        datos.put("d"+cont,D);
        datos.put("Ea"+cont,Ea);

        if (Ea < Es) {
            datos.put("cant",(double) cont);
            return;
        }
        cont++;
        muller(x1,x2,Xr,f,Es);

    }

    public Map<String, Double> getDatos() {
        return datos;
    }
}
