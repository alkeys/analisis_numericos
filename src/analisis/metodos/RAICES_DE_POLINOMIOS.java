package analisis.metodos;

public class RAICES_DE_POLINOMIOS {

    public double[] cuadratica(float a, float b, float c) {
        double[] temp = new double[2];
        temp[0] = (-b + Math.sqrt(Math.pow(b, 2) - 4 * a * c)) / 2 * a;
        temp[1] = (-b - Math.sqrt(Math.pow(b, 2) - 4 * a * c)) / 2 * a;
        return temp;
    }

    public double[] tartalia(double a, double b, double c) {
        double datos[] = new double[4];
        ///q y p
        double p = (3 * b - Math.pow(a, 2)) / 3;
        double q = (2 * Math.pow(a, 3) - 9 * a * b + 27 * c) / 27;
        //discriminate
        double alfa = Math.pow(q / 2, 2) + Math.pow(p / 3, 3);


        if (alfa == 0) {

            datos[0] = -((3 * q) / 2 * p) - a / 3;
            datos[1] = -((3 * q) / 2 * p) - a / 3;
            datos[2] = -((4 * Math.pow(p, 2)) / p * q) - a / 3;
        } else if (alfa > 0) {

            double u, v;
            u = Math.cbrt((-q / 2) + Math.sqrt(alfa));
            v = Math.cbrt((-q / 2) - Math.sqrt(alfa));
            datos[0] = (u + v) - (a / 3);
            datos[1] = ((u + v) / 2) - (a / 3);
            datos[2] = (Math.sqrt(3) / 2) * (u - v);
            datos[3] = -(Math.sqrt(3) / 2) * (u - v);
        } else if (alfa < 0) {
            int k = 0;
            double angulo = Math.acos((-q / 2) / Math.sqrt(-Math.pow((p / 3), 3)));
            datos[0] = 2 * Math.sqrt(-(p / 3)) * Math.cos((angulo + 2 * k * Math.PI) / 3) - a / 3;
            k++;
            datos[1] = 2 * Math.sqrt(-(p / 3)) * Math.cos((angulo + 2 * k * Math.PI) / 3) - a / 3;
            k++;
            datos[2] = 2 * Math.sqrt(-(p / 3)) * Math.cos((angulo + 2 * k * Math.PI) / 3) - a / 3;
        }
        return datos;
    }


    public double[] ferrari(double a, double b, double c, double d) {
        double p, q, r;
        double u, v, w;
        double raices[] = new double[4];
        p = (8 * b - 3 * Math.pow(a, 2)) / 8;
        q = (8 * c - 4 * a * b - Math.pow(a, 3)) / 8;
        r = (256 * d - 64 * a * c + 16 * Math.pow(a, 2) * b - 3 * Math.pow(a, 4)) / 256;
        double a2, b2, c2;
        a2 = -(p / 2);
        b2 = -r;
        c2 = (4 * p * r - Math.pow(q, 2)) / 8;
        double datosTartalia[] = tartalia(a2, b2, c2);
        u = datosTartalia[0];
        v = Math.sqrt(2 * u - p);
        w = q / (-2 * v);
        double datoRaiz=Math.pow(v, 2) - 4 * (u - w);
        double datoRaiz2=Math.pow(v, 2) - 4 * (u + w);
        if (datoRaiz<0){
            datoRaiz*=-1;
        }
        if (datoRaiz2<0){
            datoRaiz2*=-1;
        }
        raices[0] = ((v + Math.sqrt(datoRaiz)) / 2) - a / 4;
        raices[1] = ((v - Math.sqrt(datoRaiz)) / 2) - a / 4;
        raices[2] = ((v + Math.sqrt(datoRaiz2)) / 2) - a / 4;
        raices[3] = ((v - Math.sqrt(datoRaiz2)) / 2) - a / 4;
        return raices;
    }


}
