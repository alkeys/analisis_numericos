import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.Map;

public class metodoimprimir {
    public int  cantFilas;
    JTable tabla = new JTable();

    /**
     * @param mapa esta fucnion solo funciona xd en tablas
     *             que contengan los datos siguientes
     *             X1 X2 Xr Fx1  Fx2 Fxr Fx1*Fxr condicon Ea
     */
    public void imprimirTabla1(Map<String, Double> mapa,String Titulo) {
        String datosTemp=String.valueOf(mapa.get("cant"));
        cantFilas=Integer.parseInt(datosTemp.replace(".0",""));

    String[] encabesados={"Iteracion","X1", "X2", "Xr", "F(x1)",  "F(x2)", "F(xr)" ,"F(x1)*F(xr)"
            ,"condicion" ,"Ea"};
    loadMatrixToJTable(mapAmatrix(mapa,encabesados),tabla,encabesados.length);
    JOptionPane.showMessageDialog(null, tabla,Titulo,JOptionPane.WARNING_MESSAGE);
    }

    /**
     *
     * @param mapa
     * @param Titulo
     * esta funcion esta echa para el punto fijp
     */
    public void imprimirTabla2(Map<String, Double> mapa,String Titulo){
        String datosTemp=String.valueOf(mapa.get("cant"));
        cantFilas=Integer.parseInt(datosTemp.replace(".0",""));
        String[] encabesados={"Iteracion","X1","Gx","Ea"};
        loadMatrixToJTable(mapAmatrix(mapa,encabesados),tabla,encabesados.length);
        JOptionPane.showMessageDialog(null, tabla,Titulo,JOptionPane.WARNING_MESSAGE);
    }

    /**
     *
     * @param mapa
     * @param Titulo
     *metodo para newthon
     */
    public void imprimirTabla3(Map<String, Double> mapa,String Titulo){
        String datosTemp=String.valueOf(mapa.get("cant"));
        cantFilas=Integer.parseInt(datosTemp.replace(".0",""));
        String[] encabesados={"Iteracion","X1","F(x1)","DF(x1)","x+1","Ea"};
        loadMatrixToJTable(mapAmatrix(mapa,encabesados),tabla,encabesados.length);
        JOptionPane.showMessageDialog(null, tabla,Titulo,JOptionPane.WARNING_MESSAGE);
    }


    private Object[][] mapAmatrix(Map<String ,Double> mapa,String[] encabesado) {

     Object[][] datos=new Object[cantFilas][encabesado.length];

     for (int i=0;i<encabesado.length;i++){
      datos[0][i]=encabesado[i];
     }

     int contador=0;
     for (int i=1;i<cantFilas;i++){
         datos[i][0]=i;

     for (int j = 1; j <encabesado.length; j++ ){
         if(encabesado[j].equals("condicion")){
             datos[i][j]=(mapa.get(encabesado[j]+(i))>0)? "  >":"  <";
         }else{
             datos[i][j]=mapa.get(encabesado[j]+(i));
         }

     }
     }

     return datos;
    }


     static void loadMatrixToJTable(Object[][] matrix, JTable table,int col) {

        // Crea el modelo de la tabla y establece las columnas
        DefaultTableModel model = new DefaultTableModel();

        int numCols = col;
        for (int i = 0; i < numCols; i++) {
            model.addColumn("Columna " + (i+1));
        }
        table.setModel(model);

        // Agrega cada fila de la matriz al modelo de la tabla
        for (int i = 0; i < matrix.length; i++) {
            model.addRow(matrix[i]);
        }
    }
}



