import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Map;

/*
 * los metodos tiene n que tener los mismos encabesados para que funcionen correcta mente
 * */
public class metodoimprimir {
    public int cantFilas;
    private JTable tabla = new JTable();
    ventanaPro frameVentana;

    public metodoimprimir() {

    }


    /**
     * @param mapa esta fucnion solo funciona xd en tablas
     *             que contengan los datos siguientes
     *             X1 X2 Xr Fx1  Fx2 Fxr Fx1*Fxr condicon Ea
     *             en si para falsa posicion ,secante,biseccion
     */
    public void imprimirTabla1(Map<String, Double> mapa, String Titulo) {
        String datosTemp = String.valueOf(mapa.get("cant"));
        cantFilas = Integer.parseInt(datosTemp.replace(".0", ""));

        String[] encabesados = {"Iteracion", "X1", "X2", "Xr", "F(x1)", "F(x2)", "F(xr)", "F(x1)*F(xr)"
                , "condicion", "Ea"};
        loadMatrixToJTable(mapAmatrix(mapa, encabesados), tabla, encabesados.length);
        frameVentana=new ventanaPro(Titulo,tabla);
        // JOptionPane.showMessageDialog(null, tabla, Titulo, JOptionPane.WARNING_MESSAGE);
    }

    /**
     * @param mapa
     * @param Titulo esta funcion esta echa para el punto fijo
     */
    public void imprimirTabla2(Map<String, Double> mapa, String Titulo) {
        String datosTemp = String.valueOf(mapa.get("cant"));
        cantFilas = Integer.parseInt(datosTemp.replace(".0", ""));
        String[] encabesados = {"Iteracion", "X1", "Gx", "Ea"};
        loadMatrixToJTable(mapAmatrix(mapa, encabesados), tabla, encabesados.length);
        frameVentana=new ventanaPro(Titulo,tabla);
        // JOptionPane.showMessageDialog(null, tabla, Titulo, JOptionPane.WARNING_MESSAGE);
    }

    /**
     * @param mapa
     * @param Titulo metodo para newthon
     */
    public void imprimirTabla3(Map<String, Double> mapa, String Titulo) {
        String datosTemp = String.valueOf(mapa.get("cant"));
        cantFilas = Integer.parseInt(datosTemp.replace(".0", ""));
        String[] encabesados = {"Iteracion", "X1", "F(x1)", "DF(x1)", "x+1", "Ea"};
        loadMatrixToJTable(mapAmatrix(mapa, encabesados), tabla, encabesados.length);
        frameVentana=new ventanaPro(Titulo,tabla);
        //JOptionPane.showMessageDialog(null, tabla, Titulo, JOptionPane.WARNING_MESSAGE);
    }

    /**
     * @param mapa
     * @param Titulo para la funcion muller
     */
    public void imprimirTabla4(Map<String, Double> mapa, String Titulo) {
        String datosTemp = String.valueOf(mapa.get("cant"));
        cantFilas = Integer.parseInt(datosTemp.replace(".0", ""));
        String[] encabesados = {"I", "x0", "x1", "x2", "xr", "h0", "h1", "alfa0", "alfa1", "f(x0)"
                , "f(x1)", "f(x2)", "a", "B", "c", "d", "Ea"};
        loadMatrixToJTable(mapAmatrix(mapa, encabesados), tabla, encabesados.length);
        frameVentana=new ventanaPro(Titulo,tabla);

       //JOptionPane.showMessageDialog(null, scroll, Titulo,
       //         JOptionPane.WARNING_MESSAGE);
    }


    private Object[][] mapAmatrix(Map<String, Double> mapa, String[] encabesado) {
        Object[][] datos = new Object[cantFilas][encabesado.length];
        for (int i = 0; i < encabesado.length; i++) {
            datos[0][i] = encabesado[i];//se cambio a 0  por cualquier error xd
        }
        int contador = 0;
        for (int i = 1; i < cantFilas; i++) {
            datos[i][0] = i;
            for (int j = 1; j < encabesado.length; j++) {
                if (encabesado[j].equals("condicion")) {
                    datos[i][j] = (mapa.get(encabesado[j] + (i)) > 0) ? "  >" : "  <";
                } else {
                    datos[i][j] = mapa.get(encabesado[j] + (i));//se resive el valor mediante el encabesado xd
                }

            }
        }

        return datos;
    }


    static void loadMatrixToJTable(Object[][] matrix, JTable table, int col) {

        // Crea el modelo de la tabla y establece las columnas
        DefaultTableModel model = new DefaultTableModel();

        int numCols = col;
        for (int i = 0; i < numCols; i++) {
            model.addColumn("Columna " + (i + 1));
        }
        table.setModel(model);

        // Agrega cada fila de la matriz al modelo de la tabla
        for (int i = 0; i < matrix.length; i++) {
            model.addRow(matrix[i]);
        }
    }
}

class ventanaPro extends JFrame {
    public ventanaPro(String titulo,JTable tabla) {
        setSize(800, 800);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle(titulo);
        add(new panelpro(tabla));
    }
}

class panelpro extends JPanel {

    public panelpro(JTable tabla) {
        tabla.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        panelProcesado = new JScrollPane(tabla);
        panelProcesado.setSize(800,800);
        Dimension pant=Toolkit.getDefaultToolkit().getScreenSize();
        panelProcesado.setPreferredSize(new java.awt.Dimension(pant.width-20,pant.height-100));
        add(panelProcesado);
    }
    JScrollPane panelProcesado;
}


