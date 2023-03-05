package analisis.metodos;


import analisis.funciones.funcionesexponecial1;
import analisis.funciones.funcionpadre;

import java.util.HashMap;
import java.util.Map;

public class funcionpuntofijo {

    public Map metodopuntofijo(funcionesexponecial1 f, double a, double Es){
        Map<String,Double> datosBiseccion= new HashMap<>();
        int iterador= 1;
        double Ea, gx;
        do {
            gx =xrFun(a,f);
            if(iterador==1){
            Ea=Eaf(gx,a);
            }
            else{
                Ea=Eaf(gx,datosBiseccion.get("Gx"+(iterador-1)));
            }
            datosBiseccion.put("X1"+iterador,a);
            datosBiseccion.put("Gx"+iterador, gx);
            datosBiseccion.put("Ea"+iterador,Ea);
             a= gx;
            iterador++;
        }while (Ea>Es);
        datosBiseccion.put("cant", (double) iterador);
        return datosBiseccion;
    }
    private double xrFun(double a , funcionpadre f){
        return f.f(a);
    }
    /**
     *
     * @param xr nuevo
     * @param xr0 anterio
     * @return Ea en porcentaje
     */
    private double Eaf(double xr,double xr0){
        return Math.abs((xr-xr0)/xr)*100;
    }


}
