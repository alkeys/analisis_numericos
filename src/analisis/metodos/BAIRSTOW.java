package analisis.metodos;

import analisis.funciones.utilfuncion;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BAIRSTOW {
    private Map<String, Double> datos = new HashMap<>();
   private  int cont=1;

    public void bairstow(double[] a, double r, double s, double Es) {
        utilfuncion util=new utilfuncion();
        int n = a.length - 1;
        double[] b = new double[n + 1];
        double[] c = new double[n + 1];
        int iter = 0;
        double deltaR,deltaS,Ear,Eas,X1,X2;
        double raices[]=new double[2];
        //paso 2
        b[n] = a[n];
        b[n - 1] = a[n - 1] + r * b[n];
        for (int i = n - 2; i >= 0; i--) {
            b[i] = a[i] + r * b[i + 1] + s * b[i + 2];

        }
        ///paso 3
        c[n] = b[n];
        c[n - 1] = b[n - 1] + r * c[n];
        for (int i = n - 2; i >=0; i--) {
            c[i] = b[i] + r * c[i + 1] + s * c[i + 2];

        }
        //paso 4

        double[] datosa={c[2],c[3],-b[1]};
        double[] datosb={c[1],c[2],-b[0]};
        deltaR=util.ecuacionlineal2(datosb,datosa);
        deltaS=-(b[0]+c[1]*deltaR)/c[2];
        //paso 5
        r=r+deltaR;
        s=s+deltaS;
        //paso 6
        Ear=Math.abs(deltaR/r)*100;
        Eas=Math.abs(deltaS/s)*100;
        //paso 7
        if(Ear<Es && Eas<Es){
            X1=(r+Math.sqrt(r*r+4*s))/2;
            X2=(r-Math.sqrt(r*r+4*s))/2;

            horner datosraices=new horner();
            RAICES_DE_POLINOMIOS raiz=new RAICES_DE_POLINOMIOS();
             divisionSintetica(a,X1,X2);

            double raicesCuadradas[]=raiz.cuadratica(datosDivision.get(0),datosDivision.get(1),datosDivision.get(2));
            JOptionPane.showMessageDialog(null,"las raices son n " +
                    ""+X1+"   "+X2+" "+raicesCuadradas[0]+" "+raicesCuadradas[1]);

            return;
        }else {


            bairstow(a,r,s,Es);
        }

    }

    public Map<String, Double> getDatos() {
        return datos;
    }

    private List<Double> datosDivision=new ArrayList<>();
    int contador=0;
    public void  divisionSintetica(double[] coefficients, Double X1,double x2) {
        utilfuncion util=new utilfuncion();
        if (contador==0){
            //se agregara proque si no el vector lo ordena otra vez
            coefficients=util.invertirManual(coefficients);
            contador++;
        }
        int n = coefficients.length - 1;
        double[] result = new double[(int) n];
        result[0] = coefficients[0];
        for (int i = 1; i < n; i++) {
            result[i] = Math.round((result[i - 1] * X1) + coefficients[i]);
        }
        if(result.length<4){
            for (double datos:result) {
                System.out.println(datos);
                datosDivision.add(datos);
            }
            return;
        }else {
            divisionSintetica(result,x2,X1);
        }

    }


}
