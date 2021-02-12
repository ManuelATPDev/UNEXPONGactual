package clases;

import clases.Render;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import ventanas.GestionarAlumnos;
import ventanas.InformacionAlumnos;
import static ventanas.InformacionAlumnos.materia_codigo;
import static ventanas.InformacionAlumnos.materia_nombre;
import static ventanas.InformacionAlumnos.materia_seccion;
import ventanas.ModificarMaterias;

/**
 *
 * @author Manuel
 */
public class TablaMaterias {

    public JTable tabla;
    public String[] materia;

    public void DatosTabla(JTable tabla, String[] materia) {
        this.tabla = tabla;
        this.materia = materia;
    }

    public static void Tabla(JTable tabla, String[] materia, DefaultTableModel model) {
        String[] materia2;
        tabla.setDefaultRenderer(Object.class, new Render());
        JButton jButton_modificar = new JButton("Modificar");
        jButton_modificar.setName("modificar");
        JButton jButton_eliminar = new JButton("Eliminar");
        jButton_eliminar.setName("eliminar");

        model.addColumn("Código");
        model.addColumn("Nombre de Materia");
        model.addColumn("Sección");
        model.addColumn("Modificar");
        model.addColumn("Eliminar");

        Object[] fila = new Object[5];

        if (materia.length >= 1 && !materia[0].equals("")) {
            for (int i = 0; i < materia.length; i++) {
                materia2 = materia[i].split(",");
                fila[0] = materia2[0];
                fila[1] = materia2[1];
                fila[2] = materia2[2];
                fila[3] = jButton_modificar;
                fila[4] = jButton_eliminar;
                model.addRow(fila);
            }

            tabla.setModel(model);
        }

        tabla.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int fila_point = tabla.rowAtPoint(e.getPoint());
                int columna_point = tabla.columnAtPoint(e.getPoint());

                if (fila_point >= 0 && columna_point >= 0) {
                    Object value = tabla.getValueAt(fila_point, columna_point);
                    if (value instanceof JButton) {
                        ((JButton) value).doClick();
                        JButton boton = (JButton) value;

                        if (boton.getName().equals("modificar")) {
                            materia_codigo = (String) tabla.getValueAt(fila_point, 0);
                            materia_nombre = (String) tabla.getValueAt(fila_point, 1);
                            materia_seccion = (String) tabla.getValueAt(fila_point, 2);

                            ModificarMaterias modificarmaterias = new ModificarMaterias();
                            modificarmaterias.setVisible(true);
                        } else if (boton.getName().equals("eliminar")) {
                            System.out.println("Eliminar");

                            materia_codigo = (String) tabla.getValueAt(fila_point, 0);
                            System.out.println(Arrays.toString(materia));
                            for (int i = 0; i < materia.length; i++) {
                                if (materia[i].contains(materia_codigo)) {
                                    materia[i] = "";
                                }
                            }
                            for (int i = 0; i < materia.length; i++) {
                                if (!materia[i].equals("") /**
                                         * && i < materia.length
                                         */
                                        ) {
                                    materia[i] += "-";
                                }
                                System.out.print(materia[i]);

                            }
                        }
                    }
                }
            }

        });

    }
}
