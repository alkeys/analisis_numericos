package analisis.metodos;

import analisis.funciones.funcionesexponecial1;
import analisis.funciones.funcionpadre;
import analisis.funciones.utilfuncion;

import java.util.HashMap;
import java.util.Map;

public class NewtonRaphson {


    public Map metodonewton(funcionesexponecial1 f, double a, double Es){
        Map<String,Double> datosBiseccion= new HashMap<>();
        utilfuncion df=new utilfuncion();
        int iterador= 1;
        double Ea = 100, x1,fx,dfx;
        do {
            x1 =xFun(a,f,df);
            fx=f.f(a);
            dfx=df.derivada(f,a);
            datosBiseccion.put("X1"+iterador,a);
            datosBiseccion.put("F(x1)"+iterador,fx);
            datosBiseccion.put("DF(x1)"+iterador,dfx);
            datosBiseccion.put("x+1"+iterador,x1);
            a= x1;
            if(iterador>1){
                Ea=Eaf(a,datosBiseccion.get("x+1"+(iterador-1)));
            }
            datosBiseccion.put("Ea"+iterador,Ea);

            iterador++;
        }while (Ea>Es);
        datosBiseccion.put("cant", (double) iterador);
        return datosBiseccion;
    }
    private double xFun(double a , funcionpadre f,utilfuncion df){

        return a-((f.f(a)/df.derivada(f,a)));
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
