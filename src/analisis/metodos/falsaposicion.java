package analisis.metodos;


import analisis.funciones.funcionesexponecial1;
import analisis.funciones.funcionpadre;

import java.util.HashMap;
import java.util.Map;

public class falsaposicion{



    /**
     * @param
     * @param a            rango dado en funcion
     * @param b            rango dado en funcion
     * @param Es           valor de criterio de cifras cignificativas
     * @return un map con los nobre i= iteracion  a ,b ,F(x1),F(x2),F(x1) ,F(x1)F(x1r),condicional,
     */
    public Map metodofasaposi(funcionesexponecial1 f, double a, double b, double Es){

        Map<String,Double> datosBiseccion= new HashMap<>();
        int iterador= 1;
        double Ea,fx1,fx2,fxr,xr,fx1Xfxr;
        Ea=100;
        do {
            xr=xrFun(a,b,f);
            fx1=f.f(a);
            fx2=f.f(b);
            fxr=f.f(xr);
            fx1Xfxr=fx1*fxr;
            if (iterador>1)
                Ea=Eaf(xr,datosBiseccion.get("Xr"+(iterador-1)));

            datosBiseccion.put("X1"+iterador,a);
            datosBiseccion.put("X2"+iterador,b);
            datosBiseccion.put("Xr"+iterador,xr);
            datosBiseccion.put("F(x1)"+iterador,fx1);
            datosBiseccion.put("F(x2)"+iterador,fx2);
            datosBiseccion.put("F(xr)"+iterador,fxr);
            datosBiseccion.put("F(x1)*F(xr)"+iterador,fx1Xfxr);
            datosBiseccion.put("condicion"+iterador, (double) ((fx1Xfxr>0)? 1:-1));//si es negativo es -1 y positvo 1d
            datosBiseccion.put("Ea"+iterador,Ea);
            a=(fx1Xfxr>0)? xr:a;
            b=(fx1Xfxr>0)? b:xr;
            iterador++;
        }while (Ea>Es);
        datosBiseccion.put("cant", (double) iterador);
        return datosBiseccion;
    }

    private double xrFun(double a, double b, funcionpadre f){
        return b-((f.f(b)*(a-b))/(f.f(a)-f.f(b)));
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
