package analisis.funciones;

public class utilfuncion extends funcionpadre{
    double h = 0.001;
    public double derivada(funcionpadre  f,double x){
    return (f.f(x+h)-f.f(x))/h;
    }
}
